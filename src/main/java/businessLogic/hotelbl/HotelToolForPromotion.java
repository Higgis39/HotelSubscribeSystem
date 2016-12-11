package businessLogic.hotelbl;

import po.HotelPO;
import businessLogic.promotionbl.HotelInfoForPromotion;
import data.HotelData;
import dataService.HotelDataService;

public class HotelToolForPromotion implements HotelInfoForPromotion{
	HotelDataService hoteldataservice = new HotelData();
	
	public String getHotelBusinessDistrict(String hotelId){
		HotelPO hotelpo = hoteldataservice.fingById(hotelId);
		
		String businessArea=hotelpo.getBusinessArea();
		
		return businessArea;
	};
}
