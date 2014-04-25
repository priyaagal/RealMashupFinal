package sjsu.edu.cmpe295B;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.csvreader.CsvWriter;

public class Scraper {

	private Document doc = null;
	private JSONArray jsonArray = null;
	private String strArray = null;
	private int count = 1;
	private String csvFile = null;
	private CsvWriter writer = null;

	public Scraper() {
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanFrancisco.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanFrancisco_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanJose_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanJose_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SantaClara_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SantaClara_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MountainView_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MountainView_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Alameda_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Alameda_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Campbell_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Campbell_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanMateo_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanMateo_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/FosterCity_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/FosterCity_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Oakland_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Oakland_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanBruno_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanBruno_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Felton_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Felton_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SantaCruz_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SantaCruz_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/ScottsValley_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/ScottsValley_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Fremont_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Fremont_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Pleasanton_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Pleasanton_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Livermore_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Livermore_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SouthSanFrancisco_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SouthSanFrancisco_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanRamon_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanRamon_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/DalyCity_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/DalyCity_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/RedwoodCity_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/RedwoodCity_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanCarlos_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/SanCarlos_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Belmont_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Belmont_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Brisbane_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Brisbane_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Hillsborough_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Hillsborough_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Millbrae_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Millbrae_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MossBeach_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MossBeach_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Pacifica_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Pacifica_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/EastPaloAlto_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/EastPaloAlto_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MenloPark_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MenloPark_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/HalfMoonBay_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/HalfMoonBay_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/ElGranada_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/ElGranada_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/LaHonda_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/LaHonda_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MountainHouse_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MountainHouse_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Tracy_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Tracy_sold.csv";
		
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MenloPark_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/MenloPark_sold.csv";
		
		this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Sunnyvale_ForSale.csv";
		//this.csvFile = "/Users/snehal/Documents/MS-Software Engineering/SEM-IV/CMPE 295B/Data Sets/Sunnyvale_sold.csv";
		
		try {
			boolean alreadyExists = new File(csvFile).exists();
			this.writer = new CsvWriter(new FileWriter(this.csvFile, true), ',');

			System.out.println("alreadyExists : " + alreadyExists);

			// if the file didn't already exist then we need to write out the
			// header line
			if (!alreadyExists) {
				System.out.println("In createCSVFile !alreadyExists");
				this.writer.write("id");
				this.writer.write("address");
				this.writer.write("bathroom");
				this.writer.write("bedroom");
				this.writer.write("city");
				this.writer.write("formattedSqft");
				this.writer.write("lastSaleDate");
				this.writer.write("lastSalePrice");
				this.writer.write("latitude");
				this.writer.write("longitude");
				this.writer.write("stateCode");
				this.writer.write("typeDisplay");
				this.writer.write("price");
				this.writer.write("formattedTruliaEstimate");
				this.writer.write("zipCode");
				this.writer.write("neighborhood");
				this.writer.write("walkScore");
				this.writer.write("transitScore");
				this.writer.write("status");
				this.writer.write("county");
				this.writer.endRecord();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String fetchData(Integer pageNumber) {
		try {
			// Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
			//String url = "http://www.trulia.com/for_sale/San_Francisco,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/San_Francisco,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/San_Jose,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/San_Jose,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Santa_Clara,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Santa_Clara,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Mountain_View,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Mountain_View,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Alameda,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Alameda,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Campbell,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Campbell,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/San_Mateo,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/San_Mateo,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Foster_City,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Foster_City,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Oakland,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Oakland,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/San_Bruno,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/San_Bruno,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Felton,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Felton,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Santa_Cruz,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Santa_Cruz,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Scotts_Valley,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Scotts_Valley,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Fremont,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Fremont,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Pleasanton,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Pleasanton,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Livermore,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Livermore,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/South_San_Francisco,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/South_San_Francisco,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/San_Ramon,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/San_Ramon,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Daly_City,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Daly_City,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Redwood_City,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Redwood_City,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/San_Carlos,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/San_Carlos,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Belmont,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Belmont,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Brisbane,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Brisbane,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Hillsborough,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Hillsborough,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Millbrae,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Millbrae,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Moss_Beach,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Moss_Beach,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Pacifica,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Pacifica,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/East_Palo_Alto,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/East_Palo_Alto,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Menlo_Park,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Menlo_Park,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Half_Moon_Bay,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Half_Moon_Bay,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/El_Granada,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/El_Granada,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/La_Honda,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/La_Honda,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Mountain_House,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Mountain_House,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Tracy,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Tracy,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Half_Moon_Bay,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Half_Moon_Bay,CA/"+ pageNumber + "_p";
			
			//String url = "http://www.trulia.com/for_sale/Half_Moon_Bay,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Half_Moon_Bay,CA/"+ pageNumber + "_p";
			
			String url = "http://www.trulia.com/for_sale/Sunnyvale,CA/"+ pageNumber + "_p";
			//String url = "http://www.trulia.com/sold/Sunnyvale,CA/"+ pageNumber + "_p";
			
			System.out.println(url);
			doc = Jsoup.connect(url).get();

			// String doc =
			// Jsoup.connect("http://www.trulia.com/for_sale/San_Francisco,CA/2_p").ignoreContentType(true).execute().body();
			// System.out.println(doc);

			if (doc == null) {
				System.out.println("TRULIA RETURNED NULL VALUES");
				return null;
			}

			Elements script = doc.select("script");
			//Element script1 = doc.select("script").get(53);
			//Element script2 = doc.select("script").get(58);

			//String s = script2.toString();
			String s = script.toString();
			// System.out.println(script2);

			
			//strArray = s.substring(s.indexOf("[{"), (s.indexOf("}],") + 2));
			strArray = s.substring(s.indexOf("data: [{"), (s.indexOf("}],") + 2)).trim();
			System.out.println("strArray1 = " + strArray);
			strArray = strArray.substring(6);
			System.out.println("strArray2 = " + strArray);

		} catch (Exception e) {
			System.out.println("Exception : " +e.getMessage());
		}

		return strArray;
	}

	private JSONObject convertToJSON(String strArray) {
		JSONObject childJSONObject = null;

		try {
			jsonArray = new JSONArray(strArray);

			for (int i = 0; i < jsonArray.length(); i++) {

				childJSONObject = jsonArray.getJSONObject(i);
				this.writeToCSVFile(childJSONObject);
				// System.out.println(childJSONObject);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return childJSONObject;
	}


	private void writeToCSVFile(JSONObject childJSONObject) {
		System.out.println("In writeCSVFile");

		String address, bathroom, bedroom, city, formattedSqft, lastSaleDate, lastSalePrice, latitude, longitude, stateCode, typeDisplay, price, formattedTruliaEstimate, zipCode, id, neighborhood, walkScore, transitScore, status, county;

		try {
			// id(increment), version
			address = childJSONObject.getString("shortDescription");
			// String address = childJSONObject.getString("addressForDisplay");
			if(!childJSONObject.isNull("numBathrooms"))
					bathroom = "" + childJSONObject.getDouble("numBathrooms");
			else bathroom = null;
			
			if(!childJSONObject.isNull("numBedrooms"))
					bedroom = "" + childJSONObject.getDouble("numBedrooms");
			else bedroom = null;
			
			city = childJSONObject.getString("city");
			formattedSqft = childJSONObject.getString("formattedSqft");// finished_sq_ft
			lastSaleDate = childJSONObject.getString("lastSaleDate"); // last_sold_date
			lastSalePrice = childJSONObject.getString("lastSalePrice");// last_sold_price
			latitude = "" + childJSONObject.getDouble("latitude");
			longitude = "" + childJSONObject.getDouble("longitude");
			// lot_size_sq_ft
			stateCode = childJSONObject.getString("stateCode");
			// tax_assesment,tax_assesment_year,total_room
			typeDisplay = childJSONObject.getString("typeDisplay"); // use_code
			// year_built
			price = "" + childJSONObject.getLong("price");// zest_amt
			formattedTruliaEstimate = childJSONObject
					.getString("formattedTruliaEstimate"); // zestimate(Not
															// present)
			// zest_high, zest_low,zest_value_change
			zipCode = childJSONObject.getString("zipCode");
			id = "" + childJSONObject.getLong("id"); // zpid
			
			if(!childJSONObject.isNull("neighborhood"))
				neighborhood = childJSONObject.getString("neighborhood");
			else neighborhood=null;
			
			if(!childJSONObject.isNull("walkScore"))
				walkScore = "" + childJSONObject.getInt("walkScore");
			else walkScore = null;
			
			if(!childJSONObject.isNull("transitScore"))
				transitScore = "" + childJSONObject.getInt("transitScore");
			else transitScore = null;
			
			status = childJSONObject.getString("status"); // Eg: for sale
			county = childJSONObject.getString("county");
			
			//System.out.println("formattedTruliaEstimate : "+formattedTruliaEstimate);

			// write out a few records
			this.writer.write("" + (this.count)++);
			this.writer.write(address);
			this.writer.write(bathroom);
			this.writer.write(bedroom);
			this.writer.write(city);
			this.writer.write(formattedSqft);
			this.writer.write(lastSaleDate);
			this.writer.write(lastSalePrice);
			this.writer.write(latitude);
			this.writer.write(longitude);
			this.writer.write(stateCode);
			this.writer.write(typeDisplay);
			this.writer.write(price);
			this.writer.write(formattedTruliaEstimate);
			this.writer.write(zipCode);
			this.writer.write(neighborhood);
			this.writer.write(walkScore);
			this.writer.write(transitScore);
			this.writer.write(status);
			this.writer.write(county);

			this.writer.endRecord();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
			System.out.println(childJSONObject.toString());
		}
	}

	private void closeWriter(){
		this.writer.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scraper ph = new Scraper();
		// WalkScore ws = new WalkScore();

		for (int pageNumber = 1; pageNumber <= 12; pageNumber++) {
			String strArray = ph.fetchData(pageNumber);
			if (strArray == null)
				continue;
			ph.convertToJSON(strArray);

			System.out.println("Successful");
			// ws.addToMongoDB(jsonData);
			System.out.println("*****************");
		}
		ph.closeWriter();
	}
}
