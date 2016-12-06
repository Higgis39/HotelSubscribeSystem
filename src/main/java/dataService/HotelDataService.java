package dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 根据酒店名称获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public HotelPO findByName(String hotelname);
	
	/**
	 * 根据酒店所在地区获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByAddress(String address) throws SQLException;
	
	/**
	 * 根据商圈获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByBusinessarea(String businessarea) throws SQLException;
	
	/**
	 * 根据酒店星级获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByStar(int star) throws SQLException;
	
	/**
	 * 根据评分获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByGrade(int grade) throws SQLException;
	
	/**
	 * 得到最后一个hotel对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeid() throws SQLException;
}
