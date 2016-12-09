package businessLogic.userbl;

import java.sql.SQLException;

import businessLogicService.userBLService.RegisterClientBLService;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 */
public class RegisterClientController implements RegisterClientBLService{
	User user = new User();
	
	/**
	 * 注册用户(controller)
	 * @param uservo UserVO
	 * @return 创建成功则返回分配的id
	 * @throws SQLException 
	 */
	public String RegisterClient(UserVO uservo) throws SQLException{
		return user.RegisterClient(uservo);
	}
}
