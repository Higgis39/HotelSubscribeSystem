package businessLogic.promotionbl;

import java.util.Date;
/**
 * specificTimePromotion职责是制定特定时间的折扣
 * @author soft
 * @version 1.0
 *
 */
public class WebSpecificTimePromotion implements WebPromotionType{

	public double calculateDiscount() {
		Date beginTime = null;
		Date endTime = null;
		double discount;
		if(true){
			discount = 0.8;
		}
		return discount;
	}
}
