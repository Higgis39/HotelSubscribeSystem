package businessLogic.promotionbl;

/**
 * VIPGradePromotion的职责是制定会员等级（制定信用值满多少升下一等级）及其折扣
 * @author hly
 * @version 1.0
 * @see
 */
public class VIPGradePromotion implements WebPromotionType{
	
	public double calculateDiscount() {
		//获得用户的信用值
		int credit = 0;
		int level;
		//制定等级升级标准
		int levelProportion = 10;
		level = credit/levelProportion;
			
		double discount;
		//制定折扣标准
		int discountPromotion = 20;
		discount = 1 - level/discountPromotion;
		return discount;
	}
}
