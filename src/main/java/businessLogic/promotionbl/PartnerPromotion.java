package businessLogic.promotionbl;

import businessLogic.userbl.UserInfotoPromotion;
import data.HotelData;
import data.HotelPromotionData;
import dataService.HotelDataService;
import dataService.HotelPromotionDataService;

/**
 * 酒店合作伙伴优惠策略
 * @author Thpffcj
 *
 */
public class PartnerPromotion implements HotelPromotionType{

	HotelPromotionDataService hpds = new HotelPromotionData();
	HotelDataService hds = new HotelData();
	//得到用户是否是企业合作会员
	UserInfotoPromotion info = new UserInfotoPromotion();
	
	public double calculateDiscount(String userId, String hotelId, String entryTime) {
		String hotelName = hds.findById(hotelId).getName();
		double discount = hpds.findByHotelNameAndName(hotelName, "合作企业客户折扣").getDiscount();
		if(isPartner(hotelName)){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断用户是否为酒店合作伙伴
	 * @return
	 */
	public boolean isPartner(String hotelName){
		if(hpds.findByHotelNameAndName(hotelName, "合作企业客户折扣").isIspartner()){
			return true;
		}
		return false;
	}
}
