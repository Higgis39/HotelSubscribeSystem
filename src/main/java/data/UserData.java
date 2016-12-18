package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.DBUtil;
import dataService.UserDataService;
import po.UserPO;

/**
 * UserData的职责是实现对数据库中user对象的增删改查
 * @author hly
 * @see
 */
public class UserData implements UserDataService{
	
	Encryption encryption = new Encryption();
	
	/**
	 * 增加user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insert(UserPO u){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into user "
				+ "(name, id, password, usertype, creditvalue, VIPtype, VIPgrade, phonenumber, birthday, company, creditchange)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, encryption.encryption(u.getname()));
			ptmt.setString(2, encryption.encryption(u.getid()));
			ptmt.setString(3, encryption.encryption(u.getpassword()));
			ptmt.setString(4, u.getusertype());
			ptmt.setInt(5, u.getcreditvalue());
			ptmt.setString(6, u.getVIPtype());
			ptmt.setInt(7, u.getVIPgrade());
			ptmt.setString(8, encryption.encryption(u.getphonenumber()));
			ptmt.setString(9, u.getbirthday());
			ptmt.setString(10, u.getcompany());
			ptmt.setString(11, creditchangeToSql(u.getcreditchange()));
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @return 
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void update(UserPO u){
		Connection conn = DBUtil.getConnection();
		String sql = "update user "
				+ " set name=?, password=?, usertype=?, creditvalue=?, VIPtype=?, VIPgrade=?, phonenumber=?, birthday=?, company=?, creditchange=? "
				+ " where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, encryption.encryption(u.getname()));
			ptmt.setString(2, encryption.encryption(u.getpassword()));
			ptmt.setString(3, u.getusertype());
			ptmt.setInt(4, u.getcreditvalue());
			ptmt.setString(5, u.getVIPtype());
			ptmt.setInt(6, u.getVIPgrade());
			ptmt.setString(7, encryption.encryption(u.getphonenumber()));
			ptmt.setString(8, u.getbirthday());
			ptmt.setString(9, u.getcompany());
			ptmt.setString(10, creditchangeToSql(u.getcreditchange()));
			ptmt.setString(11, encryption.encryption(u.getid()));
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
	public UserPO find(String id){
		UserPO u = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = " select * from user "
				   + " where id=? ";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, encryption.encryption(id));
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				u = new UserPO();
				u.setName(encryption.decryption(rs.getString("name")));
				u.setId(encryption.decryption(rs.getString("id")));
				u.setPassword(encryption.decryption(rs.getString("password")));
				u.setUsertype(rs.getString("usertype"));
				u.setCreditvalue(rs.getInt("creditvalue"));
				u.setVIPtype(rs.getString("VIPtype"));
				u.setVIPgrade(rs.getInt("VIPgrade"));
				u.setPhonenumber(encryption.decryption(rs.getString("phonenumber")));
				u.setBirthday(rs.getString("birthday"));
				u.setCompany(rs.getString("company"));
//				System.out.println(rs.getString("creditchange"));
				u.setCreditchange(creditchangeToList(rs.getString("creditchange")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	/**
	 * 得到最后一个user对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeid() throws SQLException {
		UserPO u = null;
		Connection conn = DBUtil.getConnection();
			
		String sql = " select * from user where userkey=(select MAX(userkey) from user) ";
			
		PreparedStatement ptmt = conn.prepareStatement(sql);
			
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()){
			u = new UserPO();
			u.setId(encryption.decryption(rs.getString("id")));
		}
					
		return u.getid();
	}
	
	/**
	 * 将信用值变化情况转化为String类型
	 * @param cc ArrayList<String>类型
	 * @return
	 */
	public String creditchangeToSql(ArrayList<String> cc){
		if(cc!=null){
			String creditchange = "";
			for(int i=0; i<cc.size(); i++){
				creditchange = creditchange +"#"+ cc.get(i);
			}
			creditchange = creditchange + "#";
			return creditchange;
		}
		else{
			return null;
		}
	}
	
	/**
	 * 将数据库读出的String类型信用变化转化为ArrayList类型
	 * @param creditchange String类型
	 * @return
	 */
	public ArrayList<String> creditchangeToList(String creditchange){
		ArrayList<String> cc = new ArrayList<>();
		if(creditchange!=null){
			String tempcreditchange = "";
			for(int i=1; i<creditchange.length(); i++){
				if(creditchange.charAt(i) == '#'){
					cc.add(tempcreditchange);
					tempcreditchange = "";
				}
				else{
					tempcreditchange = tempcreditchange + creditchange.charAt(i);
				}
			}
			return cc;
		}
		else{
			return null;
		}
	}
}
