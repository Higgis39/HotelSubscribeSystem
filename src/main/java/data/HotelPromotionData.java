package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBUtil;
import dataService.HotelPromotionDataService;
import po.HotelPromotionPO;

/**
 * HotelPromotionData的职责是实现对数据库中hotelPromotion对象的增删改查
 * @author hly
 * @see
 */
public class HotelPromotionData implements HotelPromotionDataService{
	
	/**
	 * 增加hotelPromotion对象
	 * 
	 * @param hp HotelPromotionPO类型，系统用来存储hotelPromotion对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public boolean insert(HotelPromotionPO hp){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into hotelpromotion "
				+ "( name, introduction, isbirthday, numberofroom, ispartner, begintime, endtime ) "
				+ " values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, hp.getName());
			ptmt.setString(2, hp.getIntroduction());
			ptmt.setBoolean(3, hp.isIsbirthday());
			ptmt.setInt(4, hp.getNumberofroom());
			ptmt.setBoolean(5, hp.isIspartner());
			ptmt.setString(6, hp.getBegintime());
			ptmt.setString(7, hp.getEndtime());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 更新hotelPromotion对象
	 * 
	 * @param hp HotelPromotionPO类型，系统用来存储hotelPromotion对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public boolean update(HotelPromotionPO hp){
		Connection conn = DBUtil.getConnection();
		//是否可以根据名字来改名字？
		String sql = "update hotelpromotion "
				+ " name=?, introduction=?, isbirthday=?, numberofroom=?, ispartner=?, begintime=?, endtime=? "
				+ " where name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, hp.getName());
			ptmt.setString(2, hp.getIntroduction());
			ptmt.setBoolean(3, hp.isIsbirthday());
			ptmt.setInt(4, hp.getNumberofroom());
			ptmt.setBoolean(5, hp.isIspartner());
			ptmt.setString(6, hp.getBegintime());
			ptmt.setString(7, hp.getEndtime());
			ptmt.setString(8, hp.getName());
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
	 * @param name String类型，不同的酒店销售策略名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void delete(String name){
		Connection conn = DBUtil.getConnection();
		String sql = " delete from hotelpromotion "
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
	 * 查看hotelPromotion对象
	 * 
	 * @param name String类型，不同的酒店销售策略名称
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public List<HotelPromotionPO> find(String name) throws SQLException{
		List<HotelPromotionPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotelpromotion");
		sb.append(" where name=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, name);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPromotionPO hp = null;
		while(rs.next()){
			hp = new HotelPromotionPO();
			hp.setName(rs.getString("name"));
			hp.setIntroduction(rs.getString("introduction"));
			hp.setIsbirthday(rs.getBoolean("isbirthday"));
			hp.setNumberofroom(rs.getInt("numberofroom"));
			hp.setIspartner(rs.getBoolean("ispartner"));
			hp.setBegintime(rs.getString("begintime"));
			hp.setEndtime(rs.getString("endtime"));
			
			result.add(hp);
		}
		return result;
	}
}
