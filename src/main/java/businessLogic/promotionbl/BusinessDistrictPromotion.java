package businessLogic.promotionbl;
/**
 * businessDistrictPromotion的职责是制定VIP会员特定商圈专属折扣
 * @author hly
 *
 */
public class BusinessDistrictPromotion implements WebPromotionType{
	
	//获得酒店商圈
	String hotelAddress = null;
	double discount = 0;
		
	//计算会员等级折扣
	VIPGradePromotion v = new VIPGradePromotion();
	double VIPDiscount = v.calculateDiscount();
		
	/**
	 * 设定不同商圈折扣
	 * @param hotelAddress String型，传来酒店的商圈信息、
	 * @return 不同商圈的特定折扣
	 */
	public double location(String hotelAddress){
		switch(hotelAddress){
		case "仙林中心" :
			discount = 0.9;
			break;
		case "新街口" :
			discount = 0.8;
			break;
		}
		return discount;
	}
	
	/**
	 * 计算折扣=不同商圈折扣*不同等级折扣
	 * @return 会员特定商圈专属折扣值
	 */
	public double calculateDiscount() {
		discount = location(hotelAddress)*VIPDiscount;
		return discount;
	}
}
