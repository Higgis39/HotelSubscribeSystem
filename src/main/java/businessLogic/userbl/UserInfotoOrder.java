package businessLogic.userbl;

import data.UserData;
import dataService.UserDataService;
import po.UserPO;

/**
 * 
 * @author 费慧通
 *
 *实现UserInfoForOrder接口
 */
public class UserInfotoOrder {
	/**
	 * 得到用户的信用值
	 * @param UserID
	 * @return
	 */
	public int getCredit(String UserID){
		UserDataService service = new UserData();
		UserPO userpo = service.find(UserID);
		return userpo.getcreditvalue();
	}

	/**
	 * 得到用户
	 * @param ID
	 * @return
	 */
	public UserPO getUserByID(String ID){
		UserDataService service = new UserData();
		UserPO userpo = service.find(ID);
		return userpo;
	}
	
	/**
	 * 修改用户的信用值
	 * @param ID
	 * @param creditchange
	 * @return
	 */
	public boolean ChangeCredit(String ID,int creditchange){
		UserDataService service = new UserData();
		CreditGrade grade = new CreditGrade();
		UserPO userpo = service.find(ID);
		userpo.setCreditvalue(userpo.getcreditvalue()+creditchange);
		userpo.setVIPgrade(grade.setVIPgradeByCredit(userpo.getcreditvalue(),userpo.getVIPtype()));
		return true;
	}
}
