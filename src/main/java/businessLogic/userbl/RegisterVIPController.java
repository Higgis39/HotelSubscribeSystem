package businessLogic.userbl;

import businessLogicService.userBLService.RegisterVIPBLService;

/**
 * 
 * @author 费慧通
 *
 */
public class RegisterVIPController implements RegisterVIPBLService{
	User user = new User();
	
	/**
	 * 注册会员(controller)
	 * @param id String
	 * @param VIPtype String
	 * @param CompanyOrBirthday String
	 * @return 成功返回true,失败返回false
	 */
	public boolean RegisterVIP(String id,String VIPtype,String CompanyOrBirthday){
		return user.RegisterVIP(id,VIPtype,CompanyOrBirthday);
	}
}
