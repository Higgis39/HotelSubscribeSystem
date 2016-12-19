package businessLogic.hotelbl;

import po.HotelPO;
import businessLogic.promotionbl.HotelInfoForPromotion;
import data.HotelData;
import dataService.HotelDataService;

public class HotelToolForPromotion implements HotelInfoForPromotion{
	
	HotelDataService hoteldataservice = new HotelData();
	
	public String getHotelBusinessDistrict(String hotelName){
		HotelPO hotelpo = hoteldataservice.findByName(hotelName);
		
		String businessArea=hotelpo.getBusinessArea();
		
		return businessArea;
	};
}
