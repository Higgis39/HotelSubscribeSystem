package businessLogicService;

import java.sql.SQLException;

/**
 * 
 * @author 费慧通
 *
 */
public interface UserRegisterClientBLService {
	public String RegisterClient(String name,String password1,String password2)throws SQLException;
}
