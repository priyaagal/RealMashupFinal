package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.MasterUnSoldProperty
import grails.converters.XML
import grails.converters.JSON

class RestController {
	def restService

	def index() {
		println("In index()")
		def errorMessage
		try{
			def properties = restService.getProperties(params)
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
	
	def users() {
		println("In users()")
		def errorMessage
		try{
			def user = restService.getUser(params)
			if(user){
				println("User Present")
				if(params.dtype &&  "xml".equals(params.dtype.toLowerCase()))
					render user as XML
				else
					render user as JSON	
			}
			else
				errorMessage = "No user available"
		}
		catch(Exception e){
			errorMessage = e.getMessage()
		}
		render  JSON.parse("{\"error\" : \"" + errorMessage + "\"}") as JSON
	}
	
	def watchlist(){
		println("In watchlist()")
		def errorMessage
		try{
			def user = restService.addToWatchList(params)
			if(user){
				println("User Present")
				if(params.dtype &&  "xml".equals(params.dtype.toLowerCase()))
					render user as XML
				else
					render user as JSON
			}
			else
				errorMessage = "No user available"
		}
		catch(Exception e){
			errorMessage = e.getMessage()
		}
		render  JSON.parse("{\"error\" : \"" + errorMessage + "\"}") as JSON
	}
	
}
