package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import data.HotelData;
import data.OrderData;
import data.UserData;
import data.WebPromotionData;
import dataService.WebPromotionDataService;
import po.HotelPO;
import po.OrderPO;
import po.UserPO;
import po.WebPromotionPO;


public class JDBCTest {
	
	public static void main(String[] args) throws SQLException {
//		WebPromotionDataService wp = new WebPromotionData();
//		ArrayList<WebPromotionPO> w = wp.find();
		
		
//		HotelData hd = new HotelData();
////		
//		ArrayList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		Map<String, Object> param = new HashMap<String, Object>();
//		//查找roomID=2;
////		param.put("name", "city");
////		param.put("rela", "=");
////		param.put("value", "'南京'");
//////		//查找star小于4
////		params.add(param);
//		
////		param.put("name", "star");
////		param.put("rela", "=");
////		param.put("value", "4");
////		params.add(param);
////		param = new HashMap<String, Object>();
//		param.put("name", "businessarea");
//		param.put("rela", "=");
//		param.put("value","'仙林中心'");
//		params.add(param);
//		param.put("name", "roomPrice");
//		param.put("rela", "<");
//		param.put("value",75);
//		params.add(param);
//		System.out.println(params.size());
//		ArrayList<HotelPO> po = hd.find(params);
//		for(int i=0; i<po.size(); i++){
//			System.out.println(po.get(i).getName());
//		}
////		System.out.println(po.get(3).getName());
//		
//		ArrayList<HotelPO> po = hd.findByAddressAndBusinessarea("南京", "仙林中心");
////		
//		for(int i=0; i<po.size(); i++){
//			System.out.print(po.get(i).toString()+" ");
//		}
		

		
		UserData ud = new UserData();
//////		
		UserPO up = new UserPO();
		up = ud.find("10002");
		System.out.println(up.getname());
//		up.setName("网站管理人员");
//		up.setId("10004");
//		up.setPassword("0");
////		up.setUsertype("普通客户");
////		up.setCreditvalue(1000);
////		up.setVIPtype("企业会员");
////		up.setVIPgrade(5);
//		up.setPhonenumber("13579246868");
////		up.setBirthday("06-20");
//		up.setCompany("google");
//		ArrayList<String> a = new ArrayList<>();
//		a.add("增加50");
//		a.add("减少50");
//		up.setCreditchange(a);
		
//		ud.insert(up);
		
//		up = ud.find("10005");
//		System.out.println(up.getname());
//		System.out.println(up.getid());
//		System.out.println(up.getpassword());
//		System.out.println(up.getphonenumber());
//		System.out.println(up.getcreditchange());
//		String id = ud.distributeid();
//		System.out.println(id);
//		UserPO up = ud.find("10000");
		
//		HotelData  hd = new HotelData();
////		ArrayList<HotelPO> h = new ArrayList<>();
////		h = hd.findByAddressAndBusinessarea("南京", "仙林中心");
//		HotelPO h = new HotelPO();
//		h = hd.findById("10000");
//		String name = h.getName();
//		System.out.println(name);
		
//		OrderData od = new OrderData();
//		OrderPO op = new OrderPO();
//		op.setId("10001");
//		op.setHotelId("10000");
//		op.setUserId("10002");
//		op.setStatus("未执行");
//		op.setEntryTime("11-11");
//		op.setLastTime("11-14");
//		op.setPrice(90);
//		op.setComment("一般般");
//		op.setRoomType("双人间");
//		op.setRoomNum(4);
//		ArrayList<String> hotelid = od.findHotelIdByUserId("10012");
//		System.out.println(hotelid);
//		List<String> o = new ArrayList<>(); 
//		o = od.findHotelIdByUserId("10005");
//		System.out.println(o.get(0));
//		o = od.findByClient("10002");
//		String name = o.get(0).getComment();
//		System.out.println(name);
	}			
}

//private String id;
//private String hotelId;
//private String userId;
//private String status;
//private String entryTime;
//private String lastTime;
//private double price;
//private String comment;
//private String RoomType;
//private int RoomNum;
