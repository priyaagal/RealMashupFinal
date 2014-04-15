package sjsu.cmpe295.services

import org.apache.jasper.compiler.Node.ParamsAction;

import grails.transaction.Transactional
import sjsu.cmpe295.models.MasterUnSoldProperty
import sjsu.cmpe295.models.User

@Transactional
class RestService {

	def getProperties(params) {
		def properties

		def offset = 0
		def max = 10
		if(params.offset)
			offset = params.offset
		if(params.max)
			max = params.max


		def filters = [ max : max, offset : offset, sort : "id"]
		if(params.pid){
			properties = MasterUnSoldProperty.findById(params.pid)
		}
		else if(params.city){
			//masterUnSoldProperty = MasterUnSoldProperty.findByCity(city)
			properties = MasterUnSoldProperty.findAllByCity(params.city, filters)
		}
		else if(params.address) {
			properties = MasterUnSoldProperty.findByAddress("\"" + params.address + "\"", filters)
		}

		return properties
	}

	def getUser(params) {
		def user

		if(params.email) {
			user = User.findByEmail(params.email)
		}
		else if(params.uid) {
			user = User.findById(params.uid)
		}

		return user
	}

	def addToWatchList(params){
		def user
		def property

		
		if(params.uid){
			user = User.findById(params.uid)
		}else if(params.email) {
			user = User.findByEmail(params.email)
		}

		if(user && params.pid) {
			property = MasterUnSoldProperty.findById(params.pid)
			if(property) {
				//fix issue here
				//user.addToProperties(property).save()
			}
		}

		return user
	}
}
