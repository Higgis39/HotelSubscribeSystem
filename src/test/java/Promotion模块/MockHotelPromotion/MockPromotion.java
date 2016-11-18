package Mock.MockHotel;

import java.util.ArrayList;
import java.util.Date;

public class MockPromotion {
	
	ArrayList<String> Hotelpromotion = new ArrayList<String>();
	ArrayList<String> Webpromotion = new ArrayList<String>();
	String promotionName;
	Date beginTime;
	Date endTime;
	Date birthday;
	boolean isCompany; 
	boolean isThreemore;
	double discount;
	String sdiscount;
	
	String businessArea;
	boolean isVIP;
	int level;
	
	public MockPromotion(){
		
	}
	
	public MockPromotion(String promotionName, double discount){
		this.promotionName = promotionName;
		this.discount = discount;
	}
	
	public MockPromotion(String businessArea, int level){ 
		this.businessArea = businessArea;
		this.level = level;
	}
	
	//添加策略
	public ArrayList<String> addHotelPromotion(boolean isStaff, String name, double d){
		if(isStaff==false){
			return null;
		}
		promotionName = name;
		Hotelpromotion.add(name);
		discount = d;
		sdiscount = Double.toString(discount) ;
		Hotelpromotion.add(sdiscount);
		return Hotelpromotion;
	}
	
	//添加酒店特定时间促销策略
	public boolean addHotelPromotionTime(boolean isStaff, Date begintime, Date endtime){
		if(isStaff==false){
			return false;
		}else{
			beginTime = begintime;
			endTime = endtime;
			return true;
		}
	}
	
	//添加生日特惠折扣
	public boolean addBirthday(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//添加三间及以上预订特惠
	public boolean addThreemore(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//添加合作企业客户折扣
	public boolean addCompany(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//删除销售策略
	public boolean deletePromotion(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//更新销售策略
	public  ArrayList<String> updatePromotion(boolean isStaff, String name, double d){
		if(isStaff==false){
			return null;
		}
		promotionName = name;
		Hotelpromotion.add(name);
		discount = d;
		sdiscount = Double.toString(discount) ;
		Hotelpromotion.add(sdiscount);
		return Hotelpromotion;
	}
	
	//执行销售策略
	public boolean executePromotion(boolean isStaff, String promotionName){
		if(promotionName == "生日特惠折扣"){
			return addBirthday(isStaff);
		}
		else if(promotionName == "三间及以上预订特惠"){
			return addThreemore(isStaff);
		}
		return false;
	}

	public ArrayList<String> addWebPromotion(boolean isMarket, String name, double d){
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
	
	//添加网站特定时间促销策略
		public boolean addWebPromotionTime(boolean isMarket, Date begintime, Date endtime){
			if(isMarket==false){
				return false;
			}else{
				beginTime = begintime;
				endTime = endtime;
				return true;
			}
		}
	
	//制定专属商圈策略
	public double businessDistrict(boolean isMarket, String hotelAddress, int level){
		if(isMarket==false){
			return 0;
		}
		switch(hotelAddress){
		case "仙林中心" :
			discount = 0.9;
			break;
		case "新街口" :
			discount = 0.8;
			break;
		}
		discount = discount * (1-level/20);
		return discount;
	}
	
	//制定会员等级策略
	public int membershipLevel(boolean isMarket, int credit){
		if(isMarket==false){
			return 0;
		}
		int level;
		level = credit/10;
		return level;
	}
	
	public String getPromotionName() {
		return promotionName;
	}

	public double getDiscount() {
		return discount;
	}
}
