package businessLogic.promotionbl;

import java.time.LocalDate;

import businessLogic.userbl.UserInfotoPromotion;
import data.HotelData;
import data.HotelPromotionData;
import dataService.HotelDataService;
import dataService.HotelPromotionDataService;

/**
 * 酒店生日促销策略
 * @author Thpffcj
 *
 */
public class BirthdayPromotion implements HotelPromotionType{
	
	HotelPromotionDataService hpds = new HotelPromotionData();
	HotelDataService hds = new HotelData();
	UserInfotoPromotion info = new UserInfotoPromotion();
	
	//该策略对应的折扣
	double discount = 1;
	
	public double calculateDiscount(String userId, String hotelId, String entryTimeId) {
		String hotelName = hds.findById(hotelId).getName();
		discount = hpds.findByHotelNameAndName(hotelName, "生日特惠策略").getDiscount();
		if(isBirthday(userId)){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断当前是否是用户生日
	 * @return
	 */
	public boolean isBirthday(String userId){
		String birthday = info.getUserBirthday(userId);
		if(birthday!=null){
			LocalDate current = LocalDate.now();
			LocalDate b = LocalDate.parse(birthday);
			if(current.isEqual(b)){
				return true;
			}
		}
		return false;
	}
}
