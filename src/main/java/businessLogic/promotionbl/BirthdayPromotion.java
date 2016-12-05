package businessLogic.promotionbl;

/**
 * 酒店生日促销策略
 * @author Thpffcj
 *
 */
public class BirthdayPromotion implements HotelPromotionType{

	public double calculateDiscount() {
		double discount = 0.8;
		if(isBirthday()){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断当前是否是用户生日
	 * @return
	 */
	public boolean isBirthday(){
		return true;
	}
}
