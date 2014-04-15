package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.MasterUnSoldProperty
import grails.converters.XML
import grails.converters.JSON

class RestController {
	def restService

	def index() {
		def errorMessage
		try{
			def properties = restService.getData(params)
			if(properties) {
				
				if(params.dtype &&  "xml".equals(params.dtype.toLowerCase()))
					render properties as XML
				else
					render properties as JSON
			}
			else
				errorMessage = "No properties available"
		}
		catch(Exception e){
			errorMessage = e.getMessage()
		}
		render  JSON.parse("{\"error\" : \"" + errorMessage + "\"}") as JSON
	}
}
