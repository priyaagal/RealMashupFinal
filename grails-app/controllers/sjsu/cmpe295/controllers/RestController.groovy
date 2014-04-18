package sjsu.cmpe295.controllers
import grails.converters.JSON
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.User

class RestController {

	def getProperties() {
		println("In RestController/getProperties()")
		println(params.toString())
		
		def properties

		def offset = 0
		def max = 10
		if(params.offset)
			offset = params.offset
		if(params.max)
			max = params.max
		
		def query = params.query
		def valid = true
			
		if(query.contains(",") )
		{
			def address = query.split(",")
			params.address = address[0]
		}
		else if (query.count(" ") > 1 && query.count(" ") < 4 )
		{
			params.address = query
		}
		else if( query.count(" ") <= 1)
		{	
			params.city = query.replace(" ", "")
		}
		else
		{	
			valid = false
			def message = "Invalid input"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
			
		if(valid)
		{
			def filters = [ max : max, offset : offset, sort : "id"]
			
			if(params.city)
			{
				properties = MasterUnSoldProperty.findAllByCity(params.city, filters)
				if(properties)
				{
					render properties as JSON
				}
				else
				{
					def message = "Record not found"
					render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
				}
			}
			else if(params.address) 
			{
				properties = MasterUnSoldProperty.findByAddress(params.address, filters)
				if(properties)
				{	
					render properties as JSON
				}
				else
				{
					def message = "Property not found"
					render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
				}
			}
		}
	
	}

	def authenticateUser() {
		println("In RestController/authenticateUser()")
		def user
			
		if(request.JSON.email && request.JSON.password) {
			
			def email = request.JSON.email
			def password = request.JSON.password
			user = User.findByEmailAndPassword(email, password)
			println(user.toString())
			
			if(user)
			{
				session.username = user.getFirstname()
				session.lastname = user.getLastname()
				session.email = user.getEmail()
				render user as JSON
			}
			else
			{
					def message = "User not found"
					render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
			}
				
		}
		else
		{
			def message = "invalid username or password"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
		
	}
	
	def registerUser()
	{	println("In RestController/registerUser()")
		def user
		print(request.JSON)
		
		// dump out params
		params?.each { key, value ->
			println( "params: $key = $value" )
		}
		
		if(request.JSON.fname && request.JSON.lname && request.JSON.email && request.JSON.password)
		{	
			User ruser = new User();
			ruser.setFirstname(request.JSON.fname )
			ruser.setLastname(request.JSON.lname)
			ruser.setEmail(request.JSON.email)
			ruser.setPassword(request.JSON.password)
			
			ruser.save(flush: true)
			
			def cuser =  User.findByEmail(request.JSON.email)
			if(cuser)
			{
				render cuser as JSON
			}
			else
			{
				def message = "User not inserted"
				render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
			}
		}
		else
		{	
			 def message = "invalid or incorrect parameters provided"
			 render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
	}

	def addToUserWatchlist()
	{
		
		println("In RestController/addToUserWatchlist()")
		
		def user
		def property
		def address = request.JSON.address
		
		if(address)
		{
		
		   property = MasterUnSoldProperty.findByAddress(address)
		   user = User.findByEmail(session.email) // find user by email from session
		   HashSet<MasterUnSoldProperty> properties
	 
		   // set association
		   if(user.props != null)
			   properties =  user.props
		   else
			   properties = new HashSet<MasterUnSoldProperty>()
			   
		   properties.add(property)
		   printf(properties.toString())
		   user.props =  properties
	
		   // save objects
		   user.save(flush:true)
		   printf(user.getErrors().toString())
	
		   for (props in user.props)
		   { 	println (props.address.toString())
			   	println (props.city.toString())
				println (props.state.toString())
		   }
			
		   render user as JSON
		}
		else
		{
			def message = "invalid parameters provided"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
	}
	
	def getUserWatchlist() {
		println("In class RestController/getUserWatchlist()")
		def user = User.findByEmail(session.email)
		//MasterUnSoldProperty[] properties = user.props
		//println(properties.size().toString())
		
		if(user.props !=null && user.props.size() > 0)
		{
			List properties = new ArrayList<MasterUnSoldProperty>()
			properties.addAll(user.props)
			
			def total = properties.size()
			 
			// render(view: "result", model:['properties':properties, 'total': total, 'watchlist': true])
			 render user as JSON
		}
		else
		{
			def message = "Empty"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
	}
}
