package JDBC;

import data.UserData;
import po.UserPO;
//String name;
//String id;
//String password;
//String usertype;
//int creditvalue;
//String VIPtype;
//int VIPgrade;
//String phonenumber;
//String birthday;
//String company;

public class JDBCTest {
	
	public static void main(String[] args) {
		UserData ud = new UserData();
		
		UserPO u = new UserPO();
		u.setName("小wang");
		u.setPassword("12345");
		u.setUsertype("member");
		u.setCreditvalue(100);
		u.setVIPtype("high");
		u.setVIPgrade(100);
		u.setPhonenumber("101010");
		u.setBirthday("12");
		u.setCompany("edg");
		
		u.setId("11111");
		
		ud.updateUser(u);
	}
}
