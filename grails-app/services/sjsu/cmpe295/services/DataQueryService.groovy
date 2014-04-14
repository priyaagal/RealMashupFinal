package sjsu.cmpe295.services
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.Property;
import sjsu.cmpe295.models.SoldProperty

class DataQueryService {

	def public findAddress(String address)
	{	
		printf("In DataQueryService/findAddress")
		MasterUnSoldProperty property = MasterUnSoldProperty.findByAddress(address)
		printf(property.getAddress())
		return property
	}
}
