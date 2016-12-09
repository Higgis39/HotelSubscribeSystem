package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

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
	 * 根据城市和所属商圈获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	public ArrayList<HotelPO> findByAddressAndBusinessarea(String address, String businessarea) throws SQLException{
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where address=? and businessarea=? ");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, address);
		ptmt.setString(2, businessarea);
		
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
	 * 根据城市和所属商圈和酒店星级获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @param star int,酒店星级
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	public ArrayList<HotelPO> findByAddressAndBusinessareaAndStar(String address, String businessarea, int star) throws SQLException{
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where address=? and businessarea=? and star=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, address);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, star);
		
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
	 * 根据城市和所属商圈和酒店评分获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @param grade int类型,酒店评分
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	public ArrayList<HotelPO> findByAddressAndBusinessareaAndGrade(String address, String businessarea, int grade) throws SQLException{
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where address=? and businessarea=? and grade=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, address);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, grade);
		
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
	 * 根据城市和所属商圈和星级和评分获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @param star int类型，酒店星级
	 * @param grade int类型，酒店评分
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	public ArrayList<HotelPO> findByAll(String address, String businessarea, int star, int grade) throws SQLException{
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where address=? and businessarea=? and star=? and grade=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, address);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, star);
		ptmt.setInt(4, grade);
		
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
	
	public ArrayList<HotelPO> findBy(String address, int roomID) throws SQLException{
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel INNER JOIN room on hotel.hotelname=room.hotelName");
		sb.append(" where room.roomID=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
//		ptmt.setString(1, address);
		ptmt.setInt(1, roomID);
		
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
	 * 根据输入的不同条件获得hotel对象
	 * 
	 * @param params ArrayList<Map<String, Object>>类型,不同的筛选条件
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
//	sb.append("select * from hotel INNER JOIN room on hotel.hotelname=room.hotelName");
//	sb.append(" where room.roomID=?");
	public ArrayList<HotelPO> find(ArrayList<Map<String, Object>> params) throws SQLException{
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel INNER JOIN room on hotel.hotelname=room.hotelName where 1=1");
		
		if(params!=null && params.size()>0){
			for(int i=0; i<params.size(); i++){
				Map<String, Object> map = params.get(i);
				sb.append(" and "+map.get("name")+" "+ map.get("rela") +" "+map.get("value"));
			}
		}
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
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
}
