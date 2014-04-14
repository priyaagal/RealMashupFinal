package sjsu.cmpe295.models

class MasterSoldProperty {

		
		// location factors
		String address
		String zipcode
		String city
		String state
		Double latitude
		Double longitude
		
		// external factors
		Double amenities
		Double crimerate
		Double education
		Double housing
		Double weather
		Double costofliving
		Double employment
		Double age
		Double daysPending
		Boolean priceAppreciated
		
		//internal factors
		String useCode
		Double yearBuilt
		Double lotSizeSqFt
		Double finishedSqFt
		Double bathroom
		Double bedroom
		String lastSoldDate
		Double lastSoldPrice
		
		// price data from Zillow
		Double taxAssesment
		Double zest_amt
		Double zest_valueChange
		Double zest_low
		Double zest_high
		Double zpID
	
	static mapping = {
	}
	
	
	// unique key
	static constraints = {
		address(unique: true)
	}

			
}
