package businessLogic.promotionbl;

import java.time.LocalDate;

import businessLogic.userbl.UserInfotoPromotion;

/**
 * 酒店生日促销策略
 * @author Thpffcj
 *
 */
public class BirthdayPromotion implements HotelPromotionType{
	
	static UserInfotoPromotion info = new UserInfotoPromotion();
	
	//该策略对应的折扣
	double discount = 0.8;
	
	public double calculateDiscount(String userId, String hotelId, String entryTimeId) {
		if(isBirthday(userId)){
			System.out.println(discount);
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断当前是否是用户生日
	 * @return
	 */
	public boolean isBirthday(String userId){
		String birthday = ""; 
		birthday = info.getUserBirthday(userId);
		if(birthday != null){
			LocalDate current = LocalDate.now();
			LocalDate b = LocalDate.parse(birthday);
			if(current.isEqual(b)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BirthdayPromotion a = new BirthdayPromotion();
		a.calculateDiscount("10007", "", "");
	}
}
