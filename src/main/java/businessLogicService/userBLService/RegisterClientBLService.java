package businessLogicService.userBLService;

import java.sql.SQLException;

/**
 * 
 * @author 费慧通
 *
 */
public interface RegisterClientBLService {
	public String RegisterClient(String name,String password1,String password2)throws SQLException;
}
