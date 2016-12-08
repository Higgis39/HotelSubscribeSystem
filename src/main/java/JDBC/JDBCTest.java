package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.HotelData;
import data.UserData;
import po.HotelPO;
import po.UserPO;


public class JDBCTest {
	
	public static void main(String[] args) throws SQLException {
//		UserData ud = new UserData();
//		
//		UserPO u = new UserPO();
//		u = ud.find("11111");
//		
//		System.out.println(u.getcompany());
//		
//		UserPO u = new UserPO();
//		u.setName("小wang");
//		u.setPassword("12345");
//		u.setUsertype("member");
//		u.setCreditvalue(100);
//		u.setVIPtype("high");
//		u.setVIPgrade(100);
//		u.setPhonenumber("101010");
//		u.setBirthday("12");
//		u.setCompany("edg");
//		
//		u.setId("11111");
//		
//		ud.updateUser(u);
		
//		HotelData hd = new HotelData();
		
//		HotelPO h = new HotelPO();
//		h.setHotelid("1");
//		h.setPassword("1");
//		h.setHotelname("1");
//		h.setPhonenumber("1");
//		h.setAddress("1");
//		h.setBusinessarea("1");
//		h.setIntroduction("1");
//		h.setFacilities("1");
//		h.setStar(3);
//		h.setGrade(3);
//		ArrayList<String> worker = new ArrayList<>();		
//		worker.add("asd");
//		worker.add("ad");
//		h.setWorker(worker);
		HotelData hd = new HotelData();
		
		ArrayList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "roomID");
		param.put("rela", "=");
		param.put("value", "2");
		params.add(param);
		
		ArrayList<HotelPO> po = hd.find(params);
		
		for(int i=0; i<po.size(); i++){
			System.out.print(po.get(i).toString()+" ");
		}
		
	}
}
