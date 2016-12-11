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
		
		HotelData hd = new HotelData();
		
		ArrayList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> param = new HashMap<String, Object>();
		//查找roomID=2;
		param.put("name", "roomID");
		param.put("rela", "=");
		param.put("value", "2");
		//查找star小于4
		param.put("name", "star");
		param.put("rela", "<");
		param.put("value", "4");
		params.add(param);
		
		ArrayList<HotelPO> po = hd.find(params);
		
		for(int i=0; i<po.size(); i++){
			System.out.print(po.get(i).toString()+" ");
		}
		
	}
}
