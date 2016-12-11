package businessLogic.promotionbl;

import businessLogic.userbl.UserInfotoPromotion;

/**
 * 酒店生日促销策略
 * @author Thpffcj
 *
 */
public class BirthdayPromotion implements HotelPromotionType{
	
	UserInfotoPromotion info = new UserInfotoPromotion();
	
	//该策略对应的折扣
	double discount = 0.8;
	
	public double calculateDiscount(String userId, String hotelId, String entryTimeId) {
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
		if(birthday==" "){
			return true;
		}
		return false;
	}
}
