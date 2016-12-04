package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.DBUtil;
import dataService.UserDataService;
import po.UserPO;

/**
 * UserData的职责是实现对数据库中user对象的增删改查
 * @author hly
 * @see
 */
public class UserData implements UserDataService{
	
	/**
	 * 增加user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void addUser(UserPO u){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into user "
				+ "(name, id, password, usertype, creditvalue, VIPtype, VIPgrade, phonenumber, birthday, company)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getname());
			ptmt.setString(2, u.getid());
			ptmt.setString(3, u.getpassword());
			ptmt.setString(4, u.getusertype());
			ptmt.setInt(5, u.getcreditvalue());
			ptmt.setString(6, u.getVIPtype());
			ptmt.setInt(7, u.getVIPgrade());
			ptmt.setString(8, u.getphonenumber());
			ptmt.setString(9, u.getbirthday());
			ptmt.setString(10, u.getcompany());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void updateUser(UserPO u){
		Connection conn = DBUtil.getConnection();
		String sql = "update user "
				+ " set name=?, password=?, usertype=?, creditvalue=?, VIPtype=?, VIPgrade=?, phonenumber=?, birthday=?, company=? "
				+ " where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getname());
			ptmt.setString(2, u.getpassword());
			ptmt.setString(3, u.getusertype());
			ptmt.setInt(4, u.getcreditvalue());
			ptmt.setString(5, u.getVIPtype());
			ptmt.setInt(6, u.getVIPgrade());
			ptmt.setString(7, u.getphonenumber());
			ptmt.setString(8, u.getbirthday());
			ptmt.setString(9, u.getcompany());
			ptmt.setString(10, u.getid());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除user对象
	 * 
	 * @param id String类型，用户的唯一标识id
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void deleteUser(String id){
		Connection conn = DBUtil.getConnection();
		String sql = " delete from user "
				   + " where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得单个user对象
	 * 
	 * @param id String类型，用户的唯一标识id
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public UserPO get(String id){
		UserPO u = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = " select * from order "
				   + " where =? ";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, id);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				u = new UserPO();
				u.setName(rs.getString("name"));
				u.setId(rs.getString("id"));
				u.setPassword(rs.getString("password"));
				u.setUsertype(rs.getString("usertype"));
				u.setCreditvalue(rs.getInt("creditvalue"));
				u.setVIPtype(rs.getString("VIPtype"));
				u.setVIPgrade(rs.getInt("VIPgrade"));
				u.setPhonenumber(rs.getString("phonenumber"));
				u.setBirthday(rs.getString("birthday"));
				u.setCompany(rs.getString("company"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public UserPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserPO userpo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserPO userpo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String distributeid() {
		// TODO Auto-generated method stub
		return null;
	}
}
