package sjsu.cmpe295.controllers
import sjsu.cmpe295.models.*

class BackendController {
	def rUpdateService
	def dataCollectorService
	
	def index()
	{
		//render(view:"RUpdate")
		//dataCollectorService.getAccuracyFromRData()
		//dataCollectorService.updateMasterDataFromR()
		//redirect(action:'checkAccuracy')
		//rUpdateService.checkAccuracy()
		
		for(int i=1;i<MasterUnSoldProperty.count();i++)
		{
			def property = MasterUnSoldProperty.get(i)
			MasterSoldProperty mproperty = new MasterSoldProperty();
			mproperty.setAddress(property.getAddress())
			mproperty.setAmenities(property.getAmenities())
			mproperty.setBathroom(property.getBathroom())
			mproperty.setBedroom(property.getBedroom())
			mproperty.setCostofliving(property.getCostofliving())
			mproperty.setCrimerate(property.getCrimerate())
			mproperty.setDaysPending(property.getDaysPending())
			mproperty.setEducation(property.getEducation())
			mproperty.setEmployment(property.getEmployment())
			mproperty.setFinishedSqFt(property.getFinishedSqFt())
			mproperty.setHousing(property.getHousing())
			mproperty.setLastSoldDate(property.getLastSoldDate())
			mproperty.setLastSoldPrice(property.getLastSoldPrice())
			mproperty.setLatitude(property.getLatitude())
			mproperty.setLongitude(property.getLongitude())
			mproperty.setLotSizeSqFt(property.getLotSizeSqFt())
			mproperty.setPriceAppreciated(property.getPriceAppreciated())
			mproperty.setState(property.getState)
			mproperty.setTaxAssesment(property.getTaxAssesment()())
			mproperty.setUseCode(property.getUseCode())
			mproperty.setWeather(property.getWeather())
			mproperty.setYearBuilt(property.getYearBuilt())
			mproperty.setZest_amt(property.getZest_amt())
			mproperty.setZest_high(property.getZest_high())
			mproperty.setZest_low(property.getZest_low())
			mproperty.setZest_valueChange(property.getZest_valueChange())
			mproperty.setZipcode(property.getZipcode())
			mproperty.setZpID(property.getZpID())
			mproperty.setPredictedpriceAppreciation(property.getPredictedpriceAppreciation())
			mproperty.setRecentlySold(false)
			
			mproperty.save()
			
			if(property.getErrors().toString().contains(" 0 "))
				println("Record "+i+" updated")
			else
			{
				println("Record not updated")
			}
		}
	}
	
	def uploadR()
	{
		
	}
	
	def checkAccuracy()
	{
		
	}
}
