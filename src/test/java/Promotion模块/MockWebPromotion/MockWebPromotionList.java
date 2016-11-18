package Promotion模块.MockWebPromotion;

import java.util.ArrayList;
import java.util.Date;

public class MockWebPromotionList {
	ArrayList<String> Webpromotion = new ArrayList<String>();
	String promotionName;
	Date beginTime;
	Date endTime;
	boolean isVIP;
	int VIPGrades;
	double discount;
	String sdiscount;
	
	public MockWebPromotionList(){
		
	}
	
	public MockWebPromotionList(String name, double d){
		promotionName = name;
		Webpromotion.add(name);
		discount = d;
		sdiscount = Double.toString(discount) ;
		Webpromotion.add(sdiscount);
	}
	
	public ArrayList<String> addPromotion(boolean isMarket, String name, double d){
		if(isMarket==false){
			return null;
		}
		promotionName = name;
		Webpromotion.add(name);
		discount = d;
		sdiscount = Double.toString(discount) ;
		Webpromotion.add(sdiscount);
		return Webpromotion;
	}
}
