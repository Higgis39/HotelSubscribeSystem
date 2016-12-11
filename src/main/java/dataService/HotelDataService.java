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
	
	public ArrayList<HotelPO> findByAddressAndBusinessarea(String address, String businessarea) throws SQLException;
	public ArrayList<HotelPO> findByAddressAndBusinessareaAndStar(String address, String businessarea, int star) throws SQLException;
	public ArrayList<HotelPO> findByAddressAndBusinessareaAndGrade(String address, String businessarea, double grade) throws SQLException;
	public ArrayList<HotelPO> findByAll(String address, String businessarea, int star, double grade) throws SQLException;
	public ArrayList<HotelPO> find(ArrayList<Map<String, Object>> params) throws SQLException;
	/**
	 * 得到最后一个hotel对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeid() throws SQLException;
}
