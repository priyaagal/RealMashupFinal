package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.Property;


class DataNormalizerController {
	def dataCollectorService



	def index() {
		println("In class DataPopulaterController.groovy/index()")
		redirect(action : 'home')
	}

	def home() {
		//construct home page
		def errorMessage
		println("In class DataPopulaterController.groovy/home()")
		
		try{
			dataCollectorService.generateNormalizedDataFromResultCsv();
			render(view:'/index')
			
		} catch(Exception e) {
			errorMessage = e.getMessage()
			render(view:'error')
		}		
	}

	def details(){
		//@TODO: fetch property details and pass to the view
	}
}
