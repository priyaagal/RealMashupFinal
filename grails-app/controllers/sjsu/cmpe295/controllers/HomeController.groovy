package sjsu.cmpe295.controllers

import java.text.DecimalFormat
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.Property
import sjsu.cmpe295.models.User

class HomeController {
	def dataQueryService
	
	def index() {
		println("In class HomeController/index()")
		render(view: "index")
	}

	def parseRequest() {
		def query = params.query

		if(query.contains(",") ) {
			def address = query.split(",")
			redirect(action : 'listSingleAddress', params: [query: address[0]])
		}
		else if (query.count(" ") > 1 && query.count(" ") < 4 )
			redirect(action : 'listSingleAddress', params: [query: query])
		else if( query.count(" ") <= 1)
			redirect(action : 'listAddressesFromCity' , params: [query: query])
		else {
			printf("Invalid input")
			render(view: "/error")
		}
	}

	def listingSingleAddress() {
		println("In class DataQueryController/listings()")
		def errorMessage

		try{
			def address = params.query
			printf(address)
			if(address) {
				MasterUnSoldProperty property = dataQueryService.findSingleAddress(address)

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
				flash.crimeRate = property.getCrimerate()
				flash.education = property.getEducation()
				flash.employment = property.getEmployment()
				flash.weather = property.getWeather()
				flash.costOfLiving = property.getCostofliving()
				flash.priceAppreciated = property.getPriceAppreciated()
				println(property.getPriceAppreciated())
		
				if(flash.costOfLiving > 1.5 && flash.priceAppreciated && flash.crimeRate <= 0.5) {
					flash.ifBuy = false;
				}
				else if (flash.costOfLiving < 1.5 && flash.priceAppreciated) {
					if(flash.weather > 0.5 && flash.education > 0.5 && flash.education > 0.5 && flash.crimeRate > 0.5)
						flash.ifBuy = true;	
					else {
						flash.ifBuy = false;
					}
				}
				else {
					flash.ifBuy = true;
				}
		
			}
			else {
				errorMessage = "Address not provided"
				flash.errorMessage = errorMessage
			}

			render(view: "listings")
		} catch(Exception e) {
			flash.errorMessage = e.getMessage()
			render(view: "/home/error")
		}
	}

	def listAddressesFromCity() {
		println("In class DataQueryController/listAddressesFromCity()")

		try{

			if(params.query) {
				def city = params.query.replace(" ", "")
				printf(city)
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

				render(view: "result", model:['properties':properties, 'total': total])
			}
		} catch(Exception e) {
			flash.errorMessage = e.getMessage()
			render(view: "/home/error")
		}
	}

	def paginateAddresses() {
		println("In class DataQueryController/paginateAddresses()")

		try {

			if(params.query && params.total) {
				def city = params.query.replace(" ", "")
				def total = params.total
				List properties = MasterUnSoldProperty.findAllByCity(city,[ max : params.max, offset : params.offset ])
				printf(properties.toString())
				printf(properties.size().toString())

				render(view: "result", model:['properties':properties, 'total': total])
			}
		} catch (Exception e) {
			flash.errorMessage = e.getMessage()
		}
	}

	/*
	 def getUserWatchlist() {
	 def user = User.findByEmail(session.email)
	 for (prop in user.props) {
	 println (prop.Address.toString())
	 println (prop.city.toString())
	 println (prop.state.toString())
	 }
	 }*/

	def AddToUserWatchList() {
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

