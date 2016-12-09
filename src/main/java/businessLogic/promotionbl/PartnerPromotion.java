package businessLogic.promotionbl;

/**
 * 酒店合作伙伴优惠策略
 * @author Thpffcj
 *
 */
public class PartnerPromotion implements HotelPromotionType{

	public double calculateDiscount(String userId, String hotelId, String entryTime) {
		double discount = 0.8;
		if(isPartner()){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断用户是否为酒店合作伙伴
	 * @return
	 */
	public boolean isPartner(){
		return false;
		
	}

}
