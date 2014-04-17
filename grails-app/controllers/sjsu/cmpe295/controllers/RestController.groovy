package sjsu.cmpe295.controllers
import grails.converters.JSON
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.User

class RestController {

	def getProperties() {
		println("In RestController/getProperties()")
		
		def properties

		def offset = 0
		def max = 10
		if(params.offset)
			offset = params.offset
		if(params.max)
			max = params.max
		
		def query = params.query
			
		if(query.contains(",") ) {
				def address = query.split(",")
				params.address = address[0]
			}
		else if (query.count(" ") > 1 && query.count(" ") < 4 )
				 params.address = query
		else if( query.count(" ") <= 1)
				 params.city = query.replace(" ", "")
		else {
				printf("Invalid input")
				render(view: "/error")
			}
			

		def filters = [ max : max, offset : offset, sort : "id"]
		
		if(params.city){
			//masterUnSoldProperty = MasterUnSoldProperty.findByCity(city)
			properties = MasterUnSoldProperty.findAllByCity(params.city, filters)
		}
		else if(params.address) {
			properties = MasterUnSoldProperty.findByAddress(params.address, filters)
		}
		
		print(params.toString())
		
		print(properties.toString())
		
		if(properties) 
			render properties as JSON
				
	}

	def getUser() {
		println("In RestController/getUser()")
		def user
			
		if(params.email) {
			
			def email = params.email
			user = User.findByEmail(email)
			printf(user.toString())
			render user as JSON
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
		
		if(request.JSON.fname && request.JSON.lname && request.JSON.email && request.JSON.pass)
		{
			User ruser = new User();
			ruser.setFirstname(request.JSON.fname )
			ruser.setLastname(request.JSON.lname)
			ruser.setEmail(request.JSON.email)
			ruser.setPassword(request.JSON.pass)
			
			ruser.save(flush: true)
			
			render User.findByEmail(request.JSON.email) as JSON
		}
		
	}

	def addToWatchList(){
		def user
		def property

		
		if(params.uid){
			user = User.findById(params.uid)
		}else if(params.email) {
			user = User.findByEmail(params.email)
		}

		if(user && params.pid) {
			property = MasterUnSoldProperty.findById(params.pid)
			if(property) {
				//fix issue here
				//user.addToProperties(property).save()
			}
		}

		return user
	}
}
