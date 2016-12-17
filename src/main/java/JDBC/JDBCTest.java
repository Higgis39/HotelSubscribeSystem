package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.HotelData;
import data.OrderData;
import data.UserData;
import po.HotelPO;
import po.OrderPO;
import po.UserPO;


public class JDBCTest {
	
	public static void main(String[] args) throws SQLException {
		
//		HotelData hd = new HotelData();
//		
//		ArrayList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		Map<String, Object> param = new HashMap<String, Object>();
//		//查找roomID=2;
//		param.put("name", "roomID");
//		param.put("rela", "=");
//		param.put("value", "2");
//		//查找star小于4
//		param.put("name", "star");
//		param.put("rela", "<");
//		param.put("value", "4");
//		params.add(param);
//		
//		ArrayList<HotelPO> po = hd.find(params);
//		
//		for(int i=0; i<po.size(); i++){
//			System.out.print(po.get(i).toString()+" ");
//		}
		
//		OrderData od = new OrderData();
//		
//		OrderPO op = new OrderPO();
//		op.setId("");
//		op.setHotelId("12");
//		op.setUserId("2");
//		op.setStatus("sdf");
//		op.setEntryTime("12");
//		op.setLastTime("adf");
//		op.setPrice(90);
//		op.setComment("asdf");
//		op.setRoomType("a");
//		op.setRoomNum(4);
//		
//		od.insert(op);
		
		UserData ud = new UserData();
		
		UserPO up = new UserPO();
//		up.setName("学神");
//		up.setId("10002");
//		up.setPassword("7k7k4399");
//		up.setUsertype("普通用户");
//		up.setCreditvalue(1000);
//		up.setVIPtype("企业会员");
//		up.setVIPgrade(5);
//		up.setPhonenumber("13579246868");
//		up.setBirthday("06-19");
//		up.setCompany("google");
//		up.setCreditchange(null);
//		
//		ud.insert(up);
		
		up = ud.find("10002");
		System.out.println(up.getname());
		System.out.println(up.getid());
		System.out.println(up.getpassword());
		System.out.println(up.getphonenumber());
		
//		String id = ud.distributeid();
//		System.out.println(id);
//		UserPO up = ud.find("10000");
	}			
}

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
//ArrayList<String> creditchange;
