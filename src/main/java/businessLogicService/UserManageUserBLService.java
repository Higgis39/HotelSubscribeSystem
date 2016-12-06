package businessLogicService;

import java.sql.SQLException;

/**
 * 
 * @author 费慧通
 *
 */

import vo.UserVO;

public interface UserManageUserBLService {
	public UserVO ViewClientMessage(String id);
	
	public boolean ChangeClientMessaage(boolean IsManager,String id,String newname,String newphonenumber);

	public String AddMarketer(boolean IsManager,String name,String password1,String password2) throws NumberFormatException, SQLException;
}
