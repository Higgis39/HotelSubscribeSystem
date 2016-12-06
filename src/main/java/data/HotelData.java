package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBUtil;
import dataService.HotelDataService;
import po.HotelPO;

/**
 * HotelData的职责是实现对数据库中hotel对象的增删改查
 * @author hly
 * @see
 */
public class HotelData implements HotelDataService{

	/**
	 * 增加hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insert(HotelPO h){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into hotel "
				+ " (hotelid, password, hotelname, phonenumber, address, businessarea, introduction, facilities, star, grade, worker)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, h.getId());
			ptmt.setString(2, h.getPassword());
			ptmt.setString(3, h.getName());
			ptmt.setString(4, h.getPhonenumber());
			ptmt.setString(5, h.getAddress());
			ptmt.setString(6, h.getBusinessArea());
			ptmt.setString(7, h.getIntroduction());
			ptmt.setString(8, h.getFacilities());
			ptmt.setInt(9, h.getStar());
			ptmt.setDouble(10, h.getGrade());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void update(HotelPO h){
		Connection conn = DBUtil.getConnection();
		String sql = "update hotel "
				+ " hotelid=?, password=?, hotelname=?, phonenumber=?, address=?, businessarea=?, introduction=?, facilities=?, star=?, grade=?, worker=?"
				+ " where hotelname=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, h.getId());
			ptmt.setString(2, h.getPassword());
			ptmt.setString(3, h.getName());
			ptmt.setString(4, h.getPhonenumber());
			ptmt.setString(5, h.getAddress());
			ptmt.setString(6, h.getBusinessArea());
			ptmt.setString(7, h.getIntroduction());
			ptmt.setString(8, h.getFacilities());
			ptmt.setInt(9, h.getStar());
			ptmt.setDouble(10, h.getGrade());
			ptmt.setString(11, h.getName());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * 删除hotel对象
//	 * 
//	 * @param hotelname String类型，酒店的名称
//	 * @see
//	 * try/catch块捕获数据库连接失败异常
//	 */
//	public void delete(String hotelname){
//		Connection conn = DBUtil.getConnection();
//		String sql = " delete from hotel "
//				   + " where hotelname=?";
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setString(1, hotelname);
//			ptmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 根据酒店名称获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public HotelPO findByName(String hotelname){
		HotelPO h = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = " select * from hotel "
				   + " where hotelname=? ";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, hotelname);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				h = new HotelPO();
				h.setHotelid(rs.getString("hotelid"));
				h.setPassword(rs.getString("password"));
				h.setHotelname(rs.getString("hotelname"));
				h.setPhonenumber(rs.getString("phonenumber"));
				h.setAddress(rs.getString("address"));
				h.setBusinessarea(rs.getString("businessarea"));
				h.setIntroduction(rs.getString("introduction"));
				h.setFacilities(rs.getString("facilities"));
				h.setStar(rs.getInt("star"));
				h.setGrade(rs.getDouble("grade"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	/**
	 * 根据酒店所在地区获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByAddress(String address) throws SQLException{
		List<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotel");
		sb.append(" where address=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, address);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 根据商圈获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByBusinessarea(String businessarea) throws SQLException{
		List<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotel");
		sb.append(" where businessarea=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, businessarea);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 根据酒店星级获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByStar(int star) throws SQLException{
		List<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotel");
		sb.append(" where star=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setInt(1, star);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 根据评分获得hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public List<HotelPO> findByGrade(int grade) throws SQLException{
		List<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotel");
		sb.append(" where grade=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setInt(1, grade);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 得到最后一个hotel对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeid() throws SQLException {
		Connection conn = DBUtil.getConnection();
			
		String sql = " select top 1 from hotel "
				   + " order by key desc ";
			
		PreparedStatement ptmt = conn.prepareStatement(sql);
			
		ResultSet rs = ptmt.executeQuery();
					
		return rs.getString("id");
	}
	
//	/**
//	 * 将Arraylist中传来的worker对象转化为string并存储
//	 * @param workers
//	 * @return
//	 */
//	public static String workersToSql(ArrayList<String> workers){
//		String worker = "";
//		for(int i=0; i<workers.size(); i++){
//			worker = worker +"#"+ workers.get(i);
//		}
//		worker = worker + "#";
//		return worker;
//	}
//	
//	/**
//	 * 将数据库读出的worker转换为ArrayList类型
//	 * @param worker
//	 * @return
//	 */
//	public static ArrayList<String> workersToList(String worker){
//		ArrayList<String> workers = new ArrayList<>();
//		String tempworker="";
//		for(int i=1; i<worker.length(); i++){
//			if(worker.charAt(i) == '#'){
//				workers.add(tempworker);
//				tempworker = "";
//			}
//			else{
//				tempworker = tempworker + worker.charAt(i);
//			}
//		}
//		return workers;
//	}
}
