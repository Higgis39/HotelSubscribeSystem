package dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import JDBC.DBUtil;
import po.HotelPO;

public interface HotelDataService {
	/**
	 * 增加hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insert(HotelPO h);
	
	/**
	 * 更新hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void update(HotelPO h);
	
	public HotelPO findByName(String hotelname);
	public HotelPO findById(String id);
	
	public ArrayList<HotelPO> findByCityAndBusinessarea(String city, String businessarea) throws SQLException;
	public ArrayList<HotelPO> findByCityAndBusinessareaAndName(String city, String businessarea, String hotelname) throws SQLException;
	public ArrayList<HotelPO> findByCityAndBusinessareaAndStar(String city, String businessarea, int star) throws SQLException;
	public ArrayList<HotelPO> findByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade) throws SQLException;
	public ArrayList<HotelPO> findByAll(String address, String businessarea, int star, double mingrade, double maxgrade) throws SQLException;
	
	public ArrayList<HotelPO> pfindByCityAndBusinessarea(String city, String businessarea, String userId) throws SQLException;
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndName(String city, String businessarea, String hotelname, String userId) throws SQLException;
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndStar(String city, String businessarea, int star, String userId) throws SQLException;
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade, String userId) throws SQLException;
	public ArrayList<HotelPO> pfindByAll(String address, String businessarea, int star, double mingrade, double maxgrade, String userId) throws SQLException;
	
	
	public ArrayList<HotelPO> find(ArrayList<Map<String, Object>> params) throws SQLException;
	public ArrayList<HotelPO> pfind(ArrayList<Map<String, Object>> params, String userId) throws SQLException;
	
	/**
	 * 得到最后一个hotel对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeid() throws SQLException;
}
