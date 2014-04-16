package sjsu.cmpe295.controllers

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


	def listings() {
		println("In class DataQueryController/listings()")
		def errorMessage

		try{
			def address = params.query
			printf(address)
			if(address) {
				MasterUnSoldProperty property = dataQueryService.findAddress(address)
				//AddToUserWatchList(property)

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
			else {
				errorMessage = "Address not provided"
				render(view: "error")
			}
		} catch(Exception e) {
			errorMessage = e.getMessage()
			render(view: "error")
		}
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
	def AddToUserWatchList() {
		def errorMessage
		println("In class DataQueryController/AddToUserWatchList()")
		try{
			def address = params.address
			printf(address)
			if(address)
				Property property = dataQueryService.findAddress(address)
			else
				errorMessage = "Address not provided"

			if(session.email)
				User user = User.findByEmail(session.email) // find user by email from session
			else
				errorMessage = "User not logged in. Please log in"

			// set association
			if(property && user) {
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
			else {
				errorMessage = "Property or User is null"
				render(view: "error")
			}
		} catch(Exception e) {
			errorMessage = e.getMessage()
			render(view: "error")
		}
	}



}

