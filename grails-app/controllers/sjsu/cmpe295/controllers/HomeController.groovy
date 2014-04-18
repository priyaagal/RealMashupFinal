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

	def listings()
	{
		println("In class HomeController/listings()")
		render(view: "listings")
	}
	/*
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

	def listSingleAddress() {
		println("In class HomeController/listings()")
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
		println("In class HomeController/listAddressesFromCity()")

		try{

			if(params.query) {
				def city = params.query.replace(" ", "")
				printf(city)
				List properties = MasterUnSoldProperty.findAllByCity(city,[params])
				def total = properties.size()
				printf(properties.size().toString())
				flash.properties = properties

				

				render(view: "result", model:['properties':properties, 'total': total, 'watchlist': false])
			}
		} catch(Exception e) {
			flash.errorMessage = e.getMessage()
			render(view: "/home/error")
		}
	}

	def paginateAddresses() {
		println("In class HomeController/paginateAddresses()")

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

	
   def AddToUserWatchList2() {
	   println("In class HomeController/AddToUserWatchList()")
	   def address = params.address
	   printf(address)
	   MasterUnSoldProperty property = dataQueryService.findSingleAddress(address)

	   User user = User.findByEmail(session.email) // find user by email from session
	   
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
	   printf(user.props.toString())

	   for (props in user.props)
	   { 	println (props.address.toString())
		   	println (props.city.toString())
			println (props.state.toString())
	   }

	   render(view: "index")
   }
   */

   def showResult()
   {
	   println("In class HomeController/showResult()")
	   render(view:"result")
   }
	
   def showError()
   {
	   println("In class HomeController/showError()")
	   render(view:"error")
   }

}

