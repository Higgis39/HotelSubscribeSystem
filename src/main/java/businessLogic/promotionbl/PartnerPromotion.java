package businessLogic.promotionbl;

import businessLogic.userbl.UserInfotoPromotion;

/**
 * 酒店合作伙伴优惠策略
 * @author Thpffcj
 *
 */
public class PartnerPromotion implements HotelPromotionType{

	//得到用户是否是企业合作会员
	UserInfotoPromotion info = new UserInfotoPromotion();
	
	public double calculateDiscount(String userId, String hotelId, String entryTime) {
		double discount = 0.8;
		if(isPartner(userId)){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断用户是否为酒店合作伙伴
	 * @return
	 */
	public boolean isPartner(String userId){
		String partner = info.getUserCompany(userId);
		if(partner==""){
			return true;
		}
		return false;
	}
}
