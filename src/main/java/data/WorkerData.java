package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBUtil;
import dataService.WorkerDataService;
import po.WorkerPO;

/**
 * WorkerData的职责是实现对数据库中worker对象的增删改查
 * @author hly
 * @see
 */
public class WorkerData implements WorkerDataService{

	/**
	 * 根据酒店名称查找工作人员
	 * 
	 * @param hotelName String类型，系统用来存储酒店的名称
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public List<WorkerPO> findByHotelName(String hotelName) throws SQLException {
		List<WorkerPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from worker");
		sb.append(" where hotelname=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, hotelName);
		
		ResultSet rs = ptmt.executeQuery();
		
		WorkerPO w = null;
		while(rs.next()){
			w = new WorkerPO();
			w.setHotelName(rs.getString("hotelname"));
			w.setName(rs.getString("name"));
			w.setAge(rs.getInt("age"));
			w.setSex(rs.getString("sex"));
			w.setBeginTime(rs.getDate("begintime"));
			
			result.add(w);
		}
		return result;
	}
}
