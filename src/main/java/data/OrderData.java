package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBUtil;
import dataService.OrderDataService;
import po.OrderPO;

/**
 * OrderData的职责是实现对数据库中user对象的增删改查
 * @author hly
 * @see
 */
public class OrderData implements OrderDataService{

	/**
	 * 增加order对象
	 * 
	 * @param o OrderPO类型，系统用来存储的Order对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public boolean insert(OrderPO o) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into order "
				+ "( orderId, hotelId, userId, status, entryTime, lastTime, orderInfo, price ) "
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, o.getorderId());
			ptmt.setString(2, o.getHotelId());
			ptmt.setString(3, o.getUserId());
			ptmt.setInt(4, o.getStatus());
			ptmt.setString(5, o.getEntryTime());
			ptmt.setString(6, o.getLastTime());
			ptmt.setString(7, o.getOrderInfo());
			ptmt.setDouble(8, o.getPrice());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新Order对象
	 * 
	 * @param o OrderPO类型，系统用来存储的Order对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public boolean update(OrderPO o) {
		Connection conn = DBUtil.getConnection();
		String sql = "update order "
				+ " hotelId=?, userId=?, status=?, entryTime=?, lastTime=?, orderInfo=?, price=? "
				+ " where orderId=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, o.getHotelId());
			ptmt.setString(2, o.getUserId());
			ptmt.setInt(3, o.getStatus());
			ptmt.setString(4, o.getEntryTime());
			ptmt.setString(5, o.getLastTime());
			ptmt.setString(6, o.getOrderInfo());
			ptmt.setDouble(7, o.getPrice());
			ptmt.setString(8, o.getorderId());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 根据订单ID查找相应订单
	 * 
	 * @param ID String型，每个订单的唯一标识
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public OrderPO findByOrderID(String ID) {
		OrderPO o = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = " select * from order "
				   + " where orderId=? ";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, ID);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				o = new OrderPO();
				o.setOrderId(rs.getString("orderId"));
				o.setHotelId(rs.getString("hotelId"));
				o.setUserId(rs.getString("userId"));
				o.setStatus(rs.getInt("status"));
				o.setEntryTime(rs.getString("entryTime"));
				o.setLastTime(rs.getString("lastTime"));
				o.setOrderInfo(rs.getString("orderInfo"));
				o.setPrice(rs.getDouble("price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	/**
	 * 增加预计入住时间查找订单
	 * 
	 * @param Date String类型,每份订单的预计入住时间
	 * @throws SQLException 
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public List<OrderPO> findByDate(String Date) throws SQLException {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from order");
		sb.append(" where entryTime=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, Date);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setOrderId(rs.getString("orderId"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(rs.getString("userId"));
			o.setStatus(rs.getInt("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setOrderInfo(rs.getString("orderInfo"));
			o.setPrice(rs.getDouble("price"));
			
			result.add(o);
		}
		return result;
	}

	/**
	 * 根据不同酒店查找相应订单
	 * 
	 * @param ID String类型，不同酒店的唯一标示
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	@Override
	public List<OrderPO> findByHotelID(String ID) throws SQLException {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from order");
		sb.append(" where hotelId=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, ID);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setOrderId(rs.getString("orderId"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(rs.getString("userId"));
			o.setStatus(rs.getInt("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setOrderInfo(rs.getString("orderInfo"));
			o.setPrice(rs.getDouble("price"));
			
			result.add(o);
		}
		return result;
	}

	/**
	 * 根据不同客户ID寻找订单
	 * 
	 * @param ID String类型，不同客户的唯一标识
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public List<OrderPO> findByClient(String ID) throws SQLException {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from order");
		sb.append(" where userId=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, ID);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setOrderId(rs.getString("orderId"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(rs.getString("userId"));
			o.setStatus(rs.getInt("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setOrderInfo(rs.getString("orderInfo"));
			o.setPrice(rs.getDouble("price"));
			
			result.add(o);
		}
		return result;
	}

	/**
	 * 根据订单的状态查找订单
	 * 
	 * @param Status String类型,表示订单的状态
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	@Override
	public List<OrderPO> findByStatus(String Status) throws SQLException {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from order");
		sb.append(" where status=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, Status);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setOrderId(rs.getString("orderId"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(rs.getString("userId"));
			o.setStatus(rs.getInt("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setOrderInfo(rs.getString("orderInfo"));
			o.setPrice(rs.getDouble("price"));
			
			result.add(o);
		}
		return result;
	}
}
