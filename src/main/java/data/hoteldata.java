package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.DBUtil;
import dataService.HotelDataService;
import po.HotelPO;

/**
 * HotelData的职责是实现对数据库中hotel对象的增删改查
 * @author hly
 * @see
 */
public class HotelData implements HotelDataService {

	/**
	 * 增加hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void addHotel(HotelPO h){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into hotel "
				+ "(hotelid, password, hotelname, phonenumber, address, businessarea, introduction, facilities, star, grade)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
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
	public void updateHotel(HotelPO h){
		Connection conn = DBUtil.getConnection();
		String sql = "update hotel "
				+ " hotelid=?, password=?, hotelname=?, phonenumber=?, address=?, businessarea=?, introduction=?, facilities=?, star=?, grade=?"
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
	
	/**
	 * 删除user对象
	 * 
	 * @param hotelname String类型，酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void deleteHotel(String hotelname){
		Connection conn = DBUtil.getConnection();
		String sql = " delete from hotel "
				   + " where hotelname=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, hotelname);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得单一hotel对象
	 * 
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public HotelPO get(String hotelname){
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

	@Override
	public HotelPO find(String hotelid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(HotelPO hotelpo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HotelPO hotelpo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String distributeid() {
		// TODO Auto-generated method stub
		return null;
	}
}
