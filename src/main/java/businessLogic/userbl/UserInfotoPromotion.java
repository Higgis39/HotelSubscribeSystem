package businessLogic.userbl;

import businessLogic.promotionbl.UserInfoForPromotion;
import data.UserData;
import dataService.UserDataService;
import po.UserPO;

/**
 * 
 * @author 费慧通
 *
 *实现UserInfoForPromotion接口
 */
public class UserInfotoPromotion implements UserInfoForPromotion{

	public String getUserBirthday(String userId){
		UserDataService service = new UserData();
		UserPO userpo = service.find(userId);
		return userpo.getbirthday();
	}
	
	public String getUserCompany(String userId){
		UserDataService service = new UserData();
		UserPO userpo = service.find(userId);
		return userpo.getcompany();
	}

	public int getUserGrade(String userId) {
		UserDataService service = new UserData();
		UserPO userpo = service.find(userId);
		return userpo.getVIPgrade();
	}
}
