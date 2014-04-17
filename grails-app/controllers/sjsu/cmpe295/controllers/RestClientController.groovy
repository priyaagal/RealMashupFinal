package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.MasterUnSoldProperty
import grails.converters.XML
import grails.converters.JSON
import groovyx.net.http.HTTPBuilder

class RestClientController {
	def restService

	def getProperties() {
		
		def http = new HTTPBuilder("http://localhost:8080/RealMashupFinal/rest")
		
		println("In RestClientController/getProperties()")
		/*
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
		*/
	}
	
	
	def getUsers() {
		println("In getUsers()")
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
