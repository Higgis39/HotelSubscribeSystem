package businessLogicService.userBLService;

import java.sql.SQLException;

import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 */
public interface RegisterClientBLService {
	public String RegisterClient(UserVO uservo)throws SQLException;
}
