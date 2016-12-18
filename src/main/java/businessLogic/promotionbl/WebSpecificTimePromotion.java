package businessLogic.promotionbl;

import java.time.LocalDate;
import java.util.Date;
/**
 * specificTimePromotion职责是制定特定时间的折扣
 * @author soft
 * @version 1.0
 *
 */
public class WebSpecificTimePromotion implements WebPromotionType{

	public double calculateDiscount(String hotelId) {
		
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
		String beginTime = "2016-11-11";
		String endTime = "2016-11-12";
		LocalDate begin = LocalDate.parse(beginTime);
		LocalDate end = LocalDate.parse(endTime);
		LocalDate current = LocalDate.now();
		if(current.isAfter(begin) && current.isBefore(end)){
			return true;
		}
		return false;
	}
}
