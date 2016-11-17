package Mock.MockHotel;

import java.util.Date;

import businesslogic.userbl.User;

public class MockUser extends User{
	Date birthday;
	String company;
	
	public MockUser(Date birthday) {
		this.birthday = birthday;
	}
	
	public MockUser(String company) {
		this.company = company;
	}
	
	//获得用户生日信息
	public Date getBirthday(){
		return birthday;
	}
	
	//获得合作企业客户信息
	public String getCompany(){
		return company;
	}
}
