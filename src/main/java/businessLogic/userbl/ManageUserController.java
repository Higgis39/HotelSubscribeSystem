package businessLogic.userbl;

import businessLogicService.UserManageUserBLService;

/**
 * 
 * @author 费慧通
 *
 */
public class ManageUserController implements UserManageUserBLService {
	User user = new User();
	
	/**
	 * 管理人员查看其它用户信息(controller)
	 * @param IsManager boolean
	 * @param id String
	 * @return 返回其它用户信息
	 */
	public PersonalMessage ViewClientMessage(boolean IsManager,String id){
		return user.ViewClientMessage(IsManager,id);
	}
	
	/**
	 * 管理人员修改其它用户信息(controller)
	 * @param IsManager boolean
	 * @param id String
	 * @param newname String
	 * @param newphonenumber String
	 * @return 成功返回true,失败返回false
	 */
	public boolean ChangeClientMessaage(boolean IsManager,String id,String newname,String newphonenumber){
		return user.ChangeClientMessaage(IsManager,id,newname,newphonenumber);
	}


}
