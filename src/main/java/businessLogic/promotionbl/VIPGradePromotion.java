package businessLogic.promotionbl;

import businessLogic.userbl.UserInfotoPromotion;

/**
 * VIPGradePromotion的职责是制定会员等级（制定信用值满多少升下一等级）及其折扣
 * @author hly
 * @version 1.0
 * @see
 */
public class VIPGradePromotion implements WebPromotionType{
	
	UserInfotoPromotion info = new UserInfotoPromotion();
	double discount = 1;
	
	public double calculateDiscount(String hotelId, String userId) {
		int VIPGrade = info.getUserGrade(userId);
		switch(VIPGrade){
		case 1:
			discount = 0.95;
			break;
		case 2:
			discount = 0.90;
			break;
		case 3:
			discount = 0.85;
			break;
		case 4:
			discount = 0.80;
			break;
		case 5:
			discount = 0.75;
			break;
		default:
			break;	
		}
		return discount;
	}
}
