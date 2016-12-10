package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.DBUtil;
import dataService.RoomDataService;
import po.RoomPO;

/**
 * RoomData的职责是实现对数据库中room对象的增删改查
 * @author hly
 * @see
 */
public class RoomData implements RoomDataService{

	/**
	 * 增加room对象
	 * 
	 * @param r RoomPO类型，系统用来存储的Room对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insert(RoomPO r) {
		Connection conn = DBUtil.getConnection();
		String sql = " insert into room "
				+ " (hotelName, roomID, roomType, roomPrice, peopleNumber, IsEmpty) "
				+ " values(?,?,?,?,?,?) ";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, r.getHotelName());
			ptmt.setInt(2, r.getRoomID());
			ptmt.setString(3, r.getRoomType());
			ptmt.setDouble(4, r.getRoomPrice());
			ptmt.setInt(5, r.getPeopleNumber());
			ptmt.setBoolean(6, r.getIsEmpty());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新room对象
	 * 
	 * @param r RoomPO类型，系统用来存储的Room对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void update(RoomPO r) {
		Connection conn = DBUtil.getConnection();
		String sql = "update room "
				+ " set hotelName=?, roomID=?, roomType=?, roomPrice=?, peopleNumber=?, IsEmpty=? "
				+ " where roomID=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, r.getHotelName());
			ptmt.setInt(2, r.getRoomID());
			ptmt.setString(3, r.getRoomType());
			ptmt.setDouble(4, r.getRoomPrice());
			ptmt.setInt(5, r.getPeopleNumber());
			ptmt.setBoolean(6, r.getIsEmpty());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据酒店名字查看房间
	 * 
	 * @param hotelName String类型，酒店的名
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	public ArrayList<RoomPO> findByHotelname(String hotelName) throws SQLException {
		ArrayList<RoomPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from room");
		sb.append(" where hotelName=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, hotelName);
		
		ResultSet rs = ptmt.executeQuery();
		
		RoomPO r = null;
		while(rs.next()){
			r = new RoomPO();
			r.setRoomID(rs.getInt("roomID"));
			r.setRoomType(rs.getString("roomType"));
			r.setRoomPrice(rs.getDouble("roomPrice"));
			r.setPeopleNumber(rs.getInt("peopleNumber"));
			r.setIsEmpty(rs.getBoolean("IsEmpty"));
			
			result.add(r);
		}
		return result;
	}
	
	
	public RoomPO findByIDAndHotelname(String roomID,String hotelName) throws SQLException{
		RoomPO result=new RoomPO();
		
		return result;
	};

}
