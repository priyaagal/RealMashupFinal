package sjsu.cmpe295.services

import grails.transaction.Transactional
import sjsu.cmpe295.models.MasterUnSoldProperty

@Transactional
class RestService {

	def getData(params) {
		def properties
		
		def offset = 0
		def max = 10
		if(params.offset)
			offset = params.offset
		if(params.max)
			max = params.max
			
		
		def filters = [ max : max, offset : offset, sort : "id"]		
		if(params.city)
		{
			def city = params.city
			//masterUnSoldProperty = MasterUnSoldProperty.findByCity(city)
			properties = MasterUnSoldProperty.findAllByCity(city, filters)
		}
		else if(params.address) {
			def address = params.address
			println(address)
			properties = MasterUnSoldProperty.findByAddress("\"" + address + "\"", filters)
		}

		printf("A")
		return properties
	}
}
