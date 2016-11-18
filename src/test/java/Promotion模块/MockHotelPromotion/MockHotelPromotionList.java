package Mock.MockHotel;

import java.util.ArrayList;
import java.util.Date;

public class MockHotelPromotionList {
	
	ArrayList<String> Hotelpromotion = new ArrayList<String>();
	String promotionName;
	Date beginTime;
	Date endTime;
	Date birthday;
	boolean isCompany; 
	boolean isThreemore;
	double discount;
	String sdiscount;
	
	public MockHotelPromotionList(){
		
	}
	
	public MockHotelPromotionList(String name, double d){
		promotionName = name;
		Hotelpromotion.add(name);
		discount = d;
		sdiscount = Double.toString(discount) ;
		Hotelpromotion.add(sdiscount);
	}
	
	public ArrayList<String> addPromotion(boolean isMarket, String name, double d){
		if(isMarket==false){
			return null;
		}
		promotionName = name;
		Hotelpromotion.add(name);
		discount = d;
		sdiscount = Double.toString(discount) ;
		Hotelpromotion.add(sdiscount);
		return Hotelpromotion;
	}
}
