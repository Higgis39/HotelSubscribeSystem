package businessLogicService.userBLService;

import java.sql.SQLException;

/**
 * 
 * @author 费慧通
 *
 */

import vo.UserVO;

public interface ManageUserBLService {
	public UserVO ViewClientMessage(String id);
	
	public boolean ChangeClientMessaage(boolean IsManager,String id,String newname,String newphonenumber,int creditvalue,String birthday,String company);

	public String AddMarketer(boolean IsManager,String name,String password1,String password2) throws NumberFormatException, SQLException;
}
