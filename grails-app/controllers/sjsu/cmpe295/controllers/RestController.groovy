package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.MasterUnSoldProperty
<<<<<<< HEAD
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
=======

class RestController {
	def masterUnSoldProperty;
	
	//def address = params.address
	//def radius = params.radius
	/*def city = params.city

    def index() { }
	
	def getUnsoldProperties() {
		printf("In RestController/getUnsoldProperties")
		MasterUnSoldProperty masterUnSoldProperty = MasterUnSoldProperty.findByCity(city)
		return masterUnSoldProperty
	}*/
>>>>>>> branch 'Snehal' of https://github.com/abhidditpro2009/RealMashupFinal.git
}
