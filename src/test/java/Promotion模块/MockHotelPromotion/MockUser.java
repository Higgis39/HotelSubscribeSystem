package Promotion模块.MockHotelPromotion;

import java.util.Date;



public class MockUser extends User{
	Date birthday;
	String company;
	
	public MockUser(Date birthday) {
		this.birthday = birthday;
	}
	
	public MockUser(String company) {
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
