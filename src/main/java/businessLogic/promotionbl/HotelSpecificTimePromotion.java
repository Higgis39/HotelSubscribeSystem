package businessLogic.promotionbl;

import java.time.LocalDate;

import data.HotelData;
import data.HotelPromotionData;
import dataService.HotelDataService;
import dataService.HotelPromotionDataService;

/**
 * 酒店特定时间优惠策略
 * @author Thpffcj
 *
 */
public class HotelSpecificTimePromotion implements HotelPromotionType{

	HotelPromotionDataService hpds = new HotelPromotionData();
	HotelDataService hds = new HotelData();
	
	public double calculateDiscount(String userId, String hotelId, String entryTime) {
		String hotelName = hds.findById(hotelId).getName();
		double discount = hpds.findByHotelNameAndName(hotelName, "特定时间促销策略").getDiscount();
		if(isInPromotionTime(hotelName, "特定时间促销策略")){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断当前时间是否是促销时间
	 * @return
	 */
	public boolean isInPromotionTime(String hotelName, String name){
		String beginTime = hpds.findByHotelNameAndName(hotelName, name).getBegintime();
		String endTime = hpds.findByHotelNameAndName(hotelName, name).getEndtime();
		LocalDate begin = LocalDate.parse(beginTime);
		LocalDate end = LocalDate.parse(endTime);
		LocalDate current = LocalDate.now();
		if(current.isAfter(begin) && current.isBefore(end)){
			return true;
		}
		return false;
	}
}
