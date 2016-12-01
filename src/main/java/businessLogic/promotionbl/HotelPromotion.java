package businessLogic.promotionbl;

import java.util.Date;

import businessLogicService.PromotionHotelpromotionBLService;

public class HotelPromotion implements PromotionHotelpromotionBLService{
	
	PromotionMessage hotelPromotion = new PromotionMessage();
//	String promotionName;
//	Date beginTime;
//	Date endTime;
//	Date birthday;	
//	boolean isCompany; 	
//	boolean isThreemore;
//	double discount;

	public PromotionMessage hotelCreate(String name, String introduction, double d) {
		hotelPromotion.promotionname = name;
		hotelPromotion.introduction = introduction;
		hotelPromotion.discount = d;
		return hotelPromotion;
	}

	public PromotionMessage hotelUpdate(String name, String introduction, double d) {
		hotelPromotion.promotionname = name;
		hotelPromotion.introduction = introduction;
		hotelPromotion.discount = d;
		return hotelPromotion;
	}

	public void hotelDelete() {
		// TODO Auto-generated method stub
		
	}

	public void hotelexecute() {
		// TODO Auto-generated method stub
		
	}
}