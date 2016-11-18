package Promotion模块.MockHotelPromotion;

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
	
	//��Ӳ���
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
	
	//��ӾƵ��ض�ʱ���������
	public boolean addHotelPromotionTime(boolean isStaff, Date begintime, Date endtime){
		if(isStaff==false){
			return false;
		}else{
			beginTime = begintime;
			endTime = endtime;
			return true;
		}
	}
	
	//��������ػ��ۿ�
	public boolean addBirthday(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//������估����Ԥ���ػ�
	public boolean addThreemore(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//��Ӻ�����ҵ�ͻ��ۿ�
	public boolean addCompany(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//ɾ�����۲���
	public boolean deletePromotion(boolean isStaff){
		if(isStaff==false){
			return false;
		}
		return true;
	}
	
	//�������۲���
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
	
	//ִ�����۲���
	public boolean executePromotion(boolean isStaff, String promotionName){
		if(promotionName == "�����ػ��ۿ�"){
			return addBirthday(isStaff);
		}
		else if(promotionName == "���估����Ԥ���ػ�"){
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
	
	//�����վ�ض�ʱ���������
		public boolean addWebPromotionTime(boolean isMarket, Date begintime, Date endtime){
			if(isMarket==false){
				return false;
			}else{
				beginTime = begintime;
				endTime = endtime;
				return true;
			}
		}
	
	//�ƶ�ר����Ȧ����
	public double businessDistrict(boolean isMarket, String hotelAddress, int level){
		if(isMarket==false){
			return 0;
		}
		switch(hotelAddress){
		case "��������" :
			discount = 0.9;
			break;
		case "�½ֿ�" :
			discount = 0.8;
			break;
		}
		discount = discount * (1-level/20);
		return discount;
	}
	
	//�ƶ���Ա�ȼ�����
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
