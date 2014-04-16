package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.Property

class DataQueryController {
	def dataQueryService

	def listings() {
		def errorMessage
		println("In class DataQueryController/listings()")
		try{
			def address = params.query
			if(address) {
				Property property = dataQueryService.findAddress(address)
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
			}
			else
				errorMessage = "Address is not provided"
				
			render(view: "listings")
			
		} catch(Exception e) {
			errorMessage = e.getMessage()
			render(view: "error")
		}


	}
}
