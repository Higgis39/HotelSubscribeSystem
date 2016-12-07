package businessLogic.userbl;

import java.sql.SQLException;

import businessLogicService.userBLService.RegisterClientBLService;

/**
 * 
 * @author 费慧通
 *
 */
public class RegisterClientController implements RegisterClientBLService{
	User user = new User();
	
	/**
	 * 注册用户(controller)
	 * @param name String
	 * @param password1 String
	 * @param password2 String
	 * @return 创建成功则返回分配的id
	 * @throws SQLException 
	 */
	public String RegisterClient(String name,String password1,String password2) throws SQLException{
		return user.RegisterClient(name,password1,password2);
	}
}
