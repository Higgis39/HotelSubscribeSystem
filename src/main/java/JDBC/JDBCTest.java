package JDBC;

import java.util.ArrayList;

import data.HotelData;
import po.HotelPO;


public class JDBCTest {
	
	public static void main(String[] args) {
//		UserData ud = new UserData();
		
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
		
		HotelData hd = new HotelData();
		
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
		
		HotelPO po = hd.findByName("1");
		ArrayList<String> result = po.getWorker();
		for(int i=0; i<result.size(); i++){
			System.out.print(result.get(i)+" ");
		}
	}
}
