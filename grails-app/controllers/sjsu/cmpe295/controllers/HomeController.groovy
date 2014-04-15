package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.Property
import sjsu.cmpe295.models.User

class HomeController {
	def dataQueryService
	
	def index() {
		println("In class HomeController/index()")
		render(view: "index")	
	}

	
	def listingSingleAddress()
	{
		println("In class DataQueryController/listings()")
		def address = params.query
		printf(address)
		MasterUnSoldProperty property = dataQueryService.findSingleAddress(address)
		
		flash.address = address
		flash.city = property.getCity()
		flash.zestAmt = property.getZest_amt()
		flash.address = property.getAddress()
		flash.bathroom = property.getBathroom()
		flash.bedroom = property.getBedroom()
		flash.fArea = property.getFinishedSqFt()
		flash.lArea = property.getLotSizeSqFt()
		flash.lat = property.getLatitude()
		flash.lon = property.getLongitude()
		flash.zip = property.getZipcode()
		render(view: "listings")
	}
	
	def listAddressesFromCity()
	{
		println("In class DataQueryController/listAddressesFromCity()")
		def city = params.query.replace(" ", "")
		printf(city)
		//List properties = dataQueryService.findAddressFromCtiy(city,[params])
		List properties = MasterUnSoldProperty.findAllByCity(city,[params])
		def total = properties.size()
		printf(properties.size().toString())
		flash.properties = properties
		
		/*
		for (it in properties)
		{ 	println (it.address.toString())
			println (it.city.toString())
			println (it.state.toString())
		}
		*/
		
		def maxPageCount = 0
		render(view: "result", model:['properties':properties, 'total': total])
		
	}
	
	def paginateAddresses()
	{
		println("In class DataQueryController/paginateAddresses()")
		def city = params.query 
		def total = params.total
		printf(total.toString())
		printf(city.toString())
		printf(params.toString())
		List properties = MasterUnSoldProperty.findAllByCity(city,[ max : params.max, offset : params.offset ])
		printf(properties.toString())
		printf(properties.size().toString())
		
		render(view: "result", model:['properties':properties, 'total': total])
		
		/*
		def properties = flash.properties as List
		def maxPageCount = params.offset.toInteger() + 20
		//['properties':properties, 'offset':maxPageCount]
		printf(maxPageCount.toString())
		printf(properties.toString())
		
		render(view: "result", model:['properties':properties, 'offset':maxPageCount])
		*/
	}
	
	
	/*
	def getUserWatchlist()
	{	
		def user = User.findByEmail(session.email)
		for (prop in user.props)
		{ 	println (prop.Address.toString())
			println (prop.city.toString())
			println (prop.state.toString())
		}
		 
	}
	*/
	def AddToUserWatchList()
	{
		println("In class DataQueryController/AddToUserWatchList()")
		def address = params.address
		printf(address)
		Property property = dataQueryService.findSingleAddress(address)
		
		User user = User.findByEmail(session.email) // find user by email from session
		
		
		// set association
		Set properties = new HashSet()
		properties.add(property)
		user.props =  properties
		
		// save objects
		user.save(flush:true)
		printf(user.getErrors().toString())
		
		for (prop in user.props)
		{ 	println (prop.Address.toString())
			println (prop.city.toString())
			println (prop.state.toString())
		}
		
		render(view: "index")
	}
	
	
	
}

