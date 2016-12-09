package businessLogic.promotionbl;

/**
 * 酒店特定时间优惠策略
 * @author Thpffcj
 *
 */
public class HotelSpecificTimePromotion implements HotelPromotionType{

	public double calculateDiscount(String userId, String hotelId, String entryTime) {
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
