package businessLogic.userbl;

import java.util.ArrayList;

import businessLogic.orderbl.UserInfoForOrder;
import data.UserData;
import dataService.UserDataService;
import po.UserPO;

/**
 * 
 * @author 费慧通
 *
 *实现UserInfoForOrder接口
 */
public class UserInfotoOrder implements UserInfoForOrder{
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
		ArrayList<String> change = userpo.getcreditchange();
		if(creditchange>0){
			change.add("增加"+Integer.toString(creditchange));
		}else{
			change.add("减少"+Integer.toString(creditchange));
		}
		userpo.setCreditchange(change);
		service.update(userpo);
		return true;
	}
}
