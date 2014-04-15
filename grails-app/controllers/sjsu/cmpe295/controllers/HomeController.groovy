package sjsu.cmpe295.controllers

import java.text.DecimalFormat
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.Property
import sjsu.cmpe295.models.User

class HomeController {
	def dataQueryService
	
	def index() {
		println("In class HomeController/index()")
		//redirect(action : 'home')
		render(view: "index")	
	}

	
	def listings()
	{
		println("In class DataQueryController/listings()")
		def address = params.query
		printf(address)
		MasterUnSoldProperty property = dataQueryService.findAddress(address)
		//AddToUserWatchList(property)
		
		flash.address = address
		String city = property.getCity()
//		char[] a = city.toLowerCase().toCharArray();
//		for (int i = 0; i < a.length; i++ ) {
//			a[i] = i == 0 || a[i-1] == ' ' ? a[i].toString().toUpperCase().toCharacter() : a[i];
//		}
//		String convertedCity = new String(a);
		flash.city = city;
		
		DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
		String zestAmount = '$' + (dFormat.format(property.getZest_amt()));
		println(zestAmount)
		flash.zestAmt = zestAmount;
		
		flash.address = property.getAddress()
		flash.bathroom = String.valueOf(property.getBathroom());
		
		flash.bedroom = String.valueOf(property.getBedroom());
		flash.fArea = property.getFinishedSqFt()
		flash.lArea = property.getLotSizeSqFt()
		flash.lat = property.getLatitude()
		flash.lon = property.getLongitude()
		flash.zip = property.getZipcode()
		
		flash.amenities = property.getAmenities()
		println(property.getAmenities())
		flash.crimeRate = property.getCrimerate()
		flash.education = property.getEducation()
		flash.employment = property.getEmployment()
		flash.weather = property.getWeather()
		
		render(view: "listings")
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
		Property property = dataQueryService.findAddress(address)
		
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

