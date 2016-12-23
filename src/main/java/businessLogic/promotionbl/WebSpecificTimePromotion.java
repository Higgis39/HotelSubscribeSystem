package businessLogic.promotionbl;

import java.time.LocalDate;
import java.util.Date;
/**
 * specificTimePromotion职责是制定特定时间的折扣
 * @author soft
 * @version 1.0
 *
 */

import data.WebPromotionData;
import dataService.WebPromotionDataService;
public class WebSpecificTimePromotion implements WebPromotionType{

	WebPromotionDataService wpds = new WebPromotionData();
	
	public double calculateDiscount(String hotelId, String userId) {
		double discount = wpds.findByName("特定时间促销策略").getDiscount();
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
		String beginTime = wpds.findByName("特定时间促销策略").getBegintime();
		String endTime = wpds.findByName("特定时间促销策略").getEndtime();
		LocalDate begin = LocalDate.parse(beginTime);
		LocalDate end = LocalDate.parse(endTime);
		LocalDate current = LocalDate.now();
		if(current.isAfter(begin) && current.isBefore(end)){
			return true;
		}
		return false;
	}
}
