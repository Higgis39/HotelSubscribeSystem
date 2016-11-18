package Promotion模块.MockWebPromotion;

import java.util.Date;

import Promotion模块.MockHotelPromotion.User;



public class MockUser extends User{
	Date birthday;
	String company;
	
	public MockUser(Date birthday, String company) {
		this.birthday = birthday;
		this.company = company;
	}
	
	//����û�������Ϣ
	public Date getBirthday(){
		return birthday;
	}
	
	//��ú�����ҵ�ͻ���Ϣ
	public String getCompany(){
		return company;
	}
}
