package dataService;

import java.sql.SQLException;
import java.util.ArrayList;
import po.UserPO;

/**
 * 
 * @author 费慧通
 *
 */
public interface UserDataService {
	/**
	 * 增加user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insert(UserPO u);
	
	/**
	 * 更新user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void update(UserPO u);
	
	/**
	 * 获得单个user对象
	 * 
	 * @param id String类型，用户的唯一标识id
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public UserPO find(String id);

	/**
	 * 得到最后一个user对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeid() throws SQLException;
	
	/**
	 * 将信用值变化情况转化为String类型
	 * @param cc ArrayList<String>类型
	 */
	public static String creditchangeToSql(ArrayList<String> cc) {
		return null;
	}
	
	/**
	 * 将数据库读出的String类型信用变化转化为ArrayList类型
	 * @param creditchange String类型
	 */
	public static ArrayList<String> creditchangeToList(String creditchange){
		return null;
	}
}
