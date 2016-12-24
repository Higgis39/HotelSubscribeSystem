package businessLogic.promotionbl;

import data.HotelData;
import data.HotelPromotionData;
import dataService.HotelDataService;
import dataService.HotelPromotionDataService;

/**
 * 酒店预订三件以上客房优惠
 * @author Thpffcj
 *
 */
public class ThreemorePromotion implements HotelPromotionType{

	HotelPromotionDataService hpds = new HotelPromotionData();
	HotelDataService hds = new HotelData();
	
	public double calculateDiscount(String userId, String hotelId, String entryTimeId) {
		String hotelName = hds.findById(hotelId).getName();
		double discount = hpds.findByHotelNameAndName(hotelName, "三间及以上预订特惠").getDiscount();
		if(isThreemore(hotelName)){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断用户预订客房是否为三间以上
	 * @return
	 */
	public boolean isThreemore(String hotelName){
		if(hpds.findByHotelNameAndName(hotelName, "三间及以上预订特惠").getNumberofroom() >=3){
			return true;
		}
		return false;
		
	}

}
