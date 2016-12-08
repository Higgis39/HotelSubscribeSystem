package businessLogic.promotionbl;

/**
 * 酒店生日促销策略
 * @author Thpffcj
 *
 */
public class BirthdayPromotion implements HotelPromotionType{
	
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
		
		return true;
	}
}
