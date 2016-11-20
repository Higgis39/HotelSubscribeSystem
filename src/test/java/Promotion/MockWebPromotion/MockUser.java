package Promotion.MockWebPromotion;

import java.util.Date;

import Promotion.MockHotelPromotion.User;



public class MockUser extends User{
	Date birthday;
	String company;
	
	public MockUser(Date birthday, String company) {
		this.birthday = birthday;
		this.company = company;
	}
	
	//����û��������?
	public Date getBirthday(){
		return birthday;
	}
	
	//��ú�����ҵ�ͻ����?
	public String getCompany(){
		return company;
	}
}
