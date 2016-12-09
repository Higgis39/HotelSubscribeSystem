package businessLogic.userbl;

import java.sql.SQLException;

import businessLogicService.userBLService.ManageUserBLService;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 */
public class ManageUserController implements ManageUserBLService {
	User user = new User();
	
	/**
	 * 管理人员查看其它用户信息(controller)
	 * @param IsManager boolean
	 * @param id String
	 * @return 返回其它用户信息
	 */
	public UserVO ViewClientMessage(String id){
		return user.ViewClientMessage(id);
	}
	
	/**
	 * 管理人员修改其它用户信息(controller)
	 * @param id
	 * @param newname
	 * @param newphonenumber
	 * @param creditvalue
	 * @param birthday
	 * @param company
	 * @return
	 */
	public boolean ChangeClientMessaage(String id,String newname,String newphonenumber,int creditvalue,String birthday,String company){
		return user.ChangeClientMessaage(id,newname,newphonenumber,creditvalue,birthday,company);
	}

	public String AddMarketer(UserVO uservo) throws NumberFormatException, SQLException {
		return user.AddMarketer(uservo);
	}
}
