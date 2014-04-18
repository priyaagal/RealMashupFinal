package sjsu.cmpe295.controllers
import grails.converters.JSON
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.User

// This class acts as a backend for all the urls mapped from urlMappings.groovy

class RestController {

	def getProperties() {
		println("In RestController/getProperties()")
		println(params.toString())
		
		def properties

		def offset = 0
		def max = 10
		println(params.toString())
		
		if(params.offset)
			offset = params.offset
		if(params.max)
			max = params.max
		
		def query = params.query.replace("+", " ")
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
			def message = "failue:Invalid input"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
			
		if(valid)
		{
			def filters = [ max : max, offset : offset, sort : "zest_amt"]
			
			if(params.city)
			{	
				println(params.paginate)
				if(params.paginate == "true")
					{	println("paginated")
						properties = MasterUnSoldProperty.findAllByCity(params.city, filters)
						println(properties.size().toString())
					}
				else
					properties = MasterUnSoldProperty.findAllByCity(params.city)
				
				if(properties)
				{
					//render properties as JSON
					render(contentType: 'text/json')
					{[
							'error': "success",
							'type' : "city",
							'properties': properties
					]}
				}
				else
				{
					def message = "failue:Record not found"
					render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
				}
			}
			else if(params.address) 
			{
				properties = MasterUnSoldProperty.findByAddress(params.address, filters)
				if(properties)
				{	
					//render properties as JSON
					render(contentType: 'text/json') 
						{[
								'error': "success",
								'type' : "address",
								'properties': properties
						]}
				}
				else
				{
					def message = "failue:Property not found"
					render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
				}
			}
		}
	
	}

	def authenticateUser() {
		
		println("In RestController/authenticateUser()")
		
		if(request.JSON.email && request.JSON.password) {
			
			def email = request.JSON.email
			def password = request.JSON.password
			User user = User.findByEmailAndPassword(email, password)
			println(user.toString())
			
			
			if(user)
			{	
			
				//render user as JSON
				render(contentType: 'text/json')
				{[
						'error': "success",
						'user': user
				]}
			}
			else
			{
					def message = "failue:User not found"
					render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
			}
				
		}
		else
		{
			def message = "failue:invalid username or password"
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
		println(request.JSON.fname )
		
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
				
				//render cuser as JSON
				render(contentType: 'text/json')
				{[
						'error': "success",
						'user': cuser
				]}
			}
			else
			{
				def message = "failue:User not inserted"
				render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
			}
		}
		else
		{	
			 def message = "failue:invalid or incorrect parameters provided"
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
		   println(user.errors)
		   
		   for (props in user.props)
		   { 	println (props.address.toString())
			   	println (props.city.toString())
				println (props.state.toString())
		   }
			
		   //render user as JSON
		   render(contentType: 'text/json')
		   {[
				   'error': "success",
		   ]}
		}
		else
		{
			def message = "failue:Property not added to Watchlist"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
	}
	
	def getUserWatchlist() {
		println("In class RestController/getUserWatchlist()")
		println(params.email)
		def user = User.findByEmail(params.email)
		//MasterUnSoldProperty[] properties = user.props
		//println(properties.size().toString())
		
		if(user.props !=null && user.props.size() > 0 )
		{
			List properties = new ArrayList<MasterUnSoldProperty>()
			properties.addAll(user.props)
			
			def total = properties.size()
			
			render(contentType: 'text/json')
			{[
					'error': "success",
					'type' : "address",
					'properties': properties
			]}
			 
			// render(view: "result", model:['properties':properties, 'total': total, 'watchlist': true])
			// render user as JSON
		}
		else
		{
			def message = "failue:Empty Watchlist"
			render JSON.parse("{\"error\" : \"" + message + "\"}") as JSON
		}
	}
}
