package businessLogic.promotionbl;

/**
 * 酒店预订三件以上客房优惠
 * @author Thpffcj
 *
 */
public class ThreemorePromotion implements HotelPromotionType{

	public double calculateDiscount() {
		double discount = 0.8;
		if(isThreemore()){
			return discount;
		}
		return 1;
	}
	
	/**
	 * 判断用户预订客房是否为三间以上
	 * @return
	 */
	public boolean isThreemore(){
		return false;
		
	}

}
