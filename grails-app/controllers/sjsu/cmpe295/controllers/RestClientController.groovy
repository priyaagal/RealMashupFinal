package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.User
import grails.converters.XML
import grails.converters.JSON
import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.RESTClient
import grails.plugins.rest.client.*
import grails.rest.*
import java.text.DecimalFormat
import static groovyx.net.http.ContentType.JSON
import groovyx.net.http.*

// This class calls all the URLs defined in REST controllers making making REST API calls

class RestClientController 
{
	def getProperties() 
	{
		println("In RestClientController/getProperties()")
		
		if(params.query)
		{
			// make the REST api call
			def data = new URL("http://realmashup.aws.af.cm/rest/getProperties?query="+params.query.replace(" ","+")+"&paginate=false").getText()
			
			println(data)
			
			def json = new JsonSlurper().parseText(data)
			println(json)
			
			if(json.error == "success")
			{
				if(json.type == "address")
				{
					flash.address = json.properties.address
					//		char[] a = city.toLowerCase().toCharArray();
					//		for (int i = 0; i < a.length; i++ ) {
					//			a[i] = i == 0 || a[i-1] == ' ' ? a[i].toString().toUpperCase().toCharacter() : a[i];
					//		}
					//		String convertedCity = new String(a);
					flash.city = json.properties.city;
					
					
					DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
					String zestAmount = '$' + (dFormat.format(json.properties.zest_amt));
					println(zestAmount)
					
					flash.zestAmt = zestAmount;
					flash.bathroom = String.valueOf(json.properties.bathroom);
					flash.bedroom = String.valueOf(json.properties.bedroom);
					flash.fArea = json.properties.finishedSqFt
					flash.lArea = json.properties.lotSizeSqFt
					flash.lat = json.properties.latitude
					flash.lon = json.properties.longitude
					flash.zip = json.properties.zipcode
					flash.amenities = json.properties.amenities
					flash.crimeRate = json.properties.crimerate
					flash.education = json.properties.education
					flash.employment = json.properties.employment
					flash.weather = json.properties.weather
					flash.costOfLiving = json.properties.costofliving
					flash.priceAppreciated = json.properties.priceAppreciated
					println(json.properties.priceAppreciated)
					
					if(flash.costOfLiving > 1.5 && flash.priceAppreciated && flash.crimeRate <= 0.5)
					{
						flash.ifBuy = false;
					}
					else if (flash.costOfLiving < 1.5 && flash.priceAppreciated) 
					{
						if(flash.weather > 0.5 && flash.education > 0.5 && flash.education > 0.5 && flash.crimeRate > 0.5)
						{
							flash.ifBuy = true;
						}
						else
						 {
							flash.ifBuy = false;
						 }
					}
					else 
					{
						flash.ifBuy = true;
					}
					
					//render(view: "/home/listings")
					//redirect(controller:"home", action:"listings"  )
					render(view: "/home/listings", model:['watchlist': params.watchlist])
				}
				else if(json.type == "city")
				{	
					def properties = json.properties
					def total = properties.size()
					println(total.toString())
					printf(properties.size().toString())
					
					for (it in properties)
					{
						DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
						String zestAmount = '$' + (dFormat.format(it.zest_amt));
						println(zestAmount)
						it.zest_amt = zestAmount
					}
					
					flash.properties = properties
					
					//redirect(controller: "home", action:"showResult",  model:['properties':properties, 'total': total, 'watchlist': false])
					render(view: "/home/result", model:['properties':properties, 'total': total, 'watchlist': false])
				}
				else
				{
					flash.errorMessage = (json.error.split(":"))[1]
					redirect(controller:"home", action: "showError")
				}
			}
			else
			{
				flash.errorMessage = (json.error.split(":"))[1]
				redirect(controller:"home", action: "showError")
			}
		}	
	}
	
	def paginateAddresses()
	{
		println("In RestClientController/paginateAddresses()")
		
		// make the REST api call
		def data = new URL("http://realmashup.aws.af.cm/rest/getProperties?query="+params.query.replace(" ","+")
			+"&paginate=true"+"&max="+params.max+"&offset="+params.offset).getText()
		println(data)
		
		def json = new JsonSlurper().parseText(data)
		def properties = json.properties
		def total = params.total
		println(properties.size())
		for (it in properties)
		{
			DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
			String zestAmount = '$' + (dFormat.format(it.zest_amt));
			println(zestAmount)
			it.zest_amt = zestAmount
		}
		
		flash.properties = properties
		render(view: "/home/result", model:['properties':properties, 'total': total, 'watchlist': false])
	}
	
	def paginateWatchList()
	{
		println("In RestClientController/paginateWatchList()")
		
		// make the REST api call
		def data = new URL("http://realmashup.aws.af.cm/rest/watchlist/getUserWatchlist?email="+session.email
			+"&paginate=true"+"&max="+params.max+"&offset="+params.offset).getText()
		println(data)
		
		def json = new JsonSlurper().parseText(data)
		def properties = json.properties
		def total = params.total
		println(properties.size())
		for (it in properties)
		{
			DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
			String zestAmount = '$' + (dFormat.format(it.zest_amt));
			println(zestAmount)
			it.zest_amt = zestAmount
		}
		
		flash.properties = properties
		render(view: "/home/result", model:['properties':properties, 'total': total, 'watchlist': true])
	}
	
	def authenticateUser() 
	{
		println("In RestClientController/authenticateUser()")
		// make the REST api call
		//def data = new URL("http://localhost:8080/RealMashupFinal/rest/user/authenticateUser").getText()
		println(params.toString())
		def error
		User user
		def http = new HTTPBuilder("http://realmashup.aws.af.cm/rest/user/authenticateUser")
		http.request(Method.POST, groovyx.net.http.ContentType.JSON)
		{
			body = [email:params.email, password:params.password];
			response.success = { resp, json ->
								println(json)
								user = json.user
								error =json.error
							}
		}
		
		if(error == "success")
		{	
			//render(view: '/home/index')
			session.username = user.firstname
			session.lastname = user.lastname
			session.email = user.email
			redirect(controller: "home", action:"index")
		}
		else
		{
			flash.errorMessage = (error.split(":"))[1]
			redirect(controller:"home", action: "showError")
		}
		
	}
	
	def registerUser()
	{
		println("In RestClientController/registerUser()")
		// make the REST api call
		//def data = new URL("http://localhost:8080/RealMashupFinal/rest/user/registerUser").getText()
		def error
		User user
		//def http = new HTTPBuilder("http://localhost:8080/RealMashupFinal/rest/user/registerUser")
		def http = new HTTPBuilder("http://realmashup.aws.af.cm/rest/user/registerUser")
		http.request(Method.PUT, groovyx.net.http.ContentType.JSON)
		{
			body = [fname:params.fname, lname:params.lname, email:params.email, password:params.password];
			response.success = { resp, json ->
								println(json)
								user = json.user
								error =json.error
							}
		}
		
		if(error == "success")
		{
			//render(view: '/home/index')
			session.username = user.firstname
			session.lastname = user.lastname
			session.email = user.email
			redirect(controller: "home", action:"index")
		}
		else
		{
			flash.errorMessage = (error.split(":"))[1]
			redirect(controller:"home", action: "showError")
		}
		
	}
	
	def getUserWatchlist() {
		println("In class RestClientController/getUserWatchlist()")
		
		def data = new URL("http://realmashup.aws.af.cm/rest/watchlist/getUserWatchlist?email="+session.email).getText()
		println(data)
		
		def json = new JsonSlurper().parseText(data)
		
		
		//redirect(controller: "home", action:"showResult",  model:['properties':properties, 'total': total, 'watchlist': false])
		if(json.error == "success")
		{	
			def properties = json.properties
			def total = properties.size()
			println(total.toString())
			printf(properties.size().toString())
			for (it in properties)
			{
				DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
				String zestAmount = '$' + (dFormat.format(it.zest_amt));
				println(zestAmount)
				it.zest_amt = zestAmount
			}
			flash.properties = properties
			render(view: "/home/result", model:['properties':properties, 'total': total, 'watchlist': true])
		}
		else
		{
			flash.errorMessage = (json.error.split(":"))[1]
			println(flash.errorMessage)
			redirect(controller:"home", action: "showError")
		}
	}

   def addToUserWatchList() {
	   println("In class RestClientController/addToUserWatchList()")
	   
	   def error
	   def properties
	   def http = new HTTPBuilder("http://realmashup.aws.af.cm/rest/watchlist/addToUserWatchList?email="+session.email)
	   println(params.toString())
	   
	   http.request(Method.POST, groovyx.net.http.ContentType.JSON)
	   {
		   body = [address:params.address];
		   response.success = { resp, json ->
							   println(json)
							   error =json.error
							   properties = json.properties
						   }
	   }
	  
	   
	   if(error == "success")
	   {	
		   def total = properties.size()
		   println(total.toString())
		   printf(properties.size().toString())
		   flash.properties = properties
		   render(view: "/home/result", model:['properties':properties, 'total': total, 'watchlist': true])
		   //redirect(controller: "home", action:"index")
	   }
	   else
	   {
		   flash.errorMessage = (error.split(":"))[1]
		   println(flash.errorMessage)
		   redirect(controller:"home", action: "showError")
	   }
	   
   }

	
}
