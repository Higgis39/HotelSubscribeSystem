package businessLogic.promotionbl;

import java.util.Date;
/**
 * specificTimePromotion职责是制定特定时间的折扣
 * @author soft
 * @version 1.0
 *
 */
public class WebSpecificTimePromotion implements WebPromotionType{

	public double calculateDiscount(String hotelId) {
		String beginTime = null;
		String endTime = null;
		double discount = 0.8;
		if(isInPromotionTime()){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断当前时间是否是促销时间
	 * @return
	 */
	public boolean isInPromotionTime(){
		return false;
	}
}
