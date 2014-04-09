package sjsu.cmpe295.services
import sjsu.cmpe295.models.Property;
import sjsu.cmpe295.models.SoldProperty

class DataQueryService {

	def public findAddress(String address)
	{
		Property property = Property.findByAddress(address)
		return property
	}
}
