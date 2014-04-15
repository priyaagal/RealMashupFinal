package sjsu.cmpe295.services
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.Property;
import sjsu.cmpe295.models.SoldProperty

class DataQueryService {

	def public findSingleAddress(String address)
	{	
		printf("In DataQueryService/findSingleAddress")
		MasterUnSoldProperty property = MasterUnSoldProperty.findByAddress(address)
		printf(property.getAddress())
		return property
	}
	
	def public findAddressFromCtiy(String city)
	{
		printf("In DataQueryService/findAddressFromCtiy")
		def properties = MasterUnSoldProperty.findAllByCity(city)
		printf(properties.toString())
		return properties
	}
}
