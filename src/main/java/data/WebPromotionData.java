package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.DBUtil;
import dataService.WebPromotionDataService;
import po.WebPromotionPO;

/**
 * WebPromotionData的职责是实现对数据库中webPromotion对象的增删改查
 * @author hly
 * @see
 */
public class WebPromotionData implements WebPromotionDataService{

	/**
	 * 增加webPromotion对象
	 * 
	 * @param wp WebPromotionPO类型，系统用来存储webPromotion对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public boolean insert(WebPromotionPO wp){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into webpromotion "
				+ "( name, begintime, endtime, VIPgrade, specificbusinessarea, discount ) "
				+ " values(?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, wp.getName());
			ptmt.setString(2, wp.getBegintime());
			ptmt.setString(3, wp.getEndtime());
			ptmt.setInt(4, wp.getVIPgrade());
			ptmt.setString(5, wp.getSpecificbusinessarea());
			ptmt.setDouble(6, wp.getDiscount());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 更新webPromotion对象
	 * 
	 * @param wp WebPromotionPO类型，系统用来存储webPromotion对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public boolean update(WebPromotionPO wp){
		Connection conn = DBUtil.getConnection();
		//是否可以根据名字来改名字？
		String sql = "update webpromotion "
				+ " name=?, begintime=?, endtime=?, VIPgrade=?, specificbusinessarea=? discount=? "
				+ " where name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, wp.getName());
			ptmt.setString(2, wp.getBegintime());
			ptmt.setString(3, wp.getEndtime());
			ptmt.setInt(4, wp.getVIPgrade());
			ptmt.setString(5, wp.getSpecificbusinessarea());
			ptmt.setDouble(6, wp.getDiscount());
			ptmt.setString(7, wp.getName());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 删除hotelPromotion对象
	 * 
	 * @param name String类型,不同的网站销售策略名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void delete(String name){
		Connection conn = DBUtil.getConnection();
		String sql = " delete from webpromotion "
				   + " where name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * hotelPromotion对象
	 * 
	 * @param name String类型，不同的酒店销售策略名称
	 * @see
	 * @throws SQLException 数据库连接失败异常
	 */
	public ArrayList<WebPromotionPO> find(String name) throws SQLException{
		ArrayList<WebPromotionPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from webpromotion");
		sb.append(" where name=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, name);
		
		ResultSet rs = ptmt.executeQuery();
		
		WebPromotionPO wp = null;
		while(rs.next()){
			wp = new WebPromotionPO();
			wp.setName(rs.getString("name"));
			wp.setBegintime(rs.getString("begintime"));
			wp.setEndtime(rs.getString("endtime"));
			wp.setVIPgrade(rs.getInt("VIPgrade"));
			wp.setSpecificbusinessarea(rs.getString("specificbusinessarea"));
			wp.setDiscount(rs.getDouble("discount"));
			
			result.add(wp);
		}
		return result;
	}
	
	public ArrayList<WebPromotionPO> findByDiscount(double discount) throws SQLException{
		ArrayList<WebPromotionPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from webpromotion");
		sb.append(" where discount=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setDouble(1, discount);
		
		ResultSet rs = ptmt.executeQuery();
		
		WebPromotionPO wp = null;
		while(rs.next()){
			wp = new WebPromotionPO();
			wp.setName(rs.getString("name"));
			wp.setBegintime(rs.getString("begintime"));
			wp.setEndtime(rs.getString("endtime"));
			wp.setVIPgrade(rs.getInt("VIPgrade"));
			wp.setSpecificbusinessarea(rs.getString("specificbusinessarea"));
			wp.setDiscount(rs.getDouble("discount"));
			
			result.add(wp);
		}
		return result;
	}
}
