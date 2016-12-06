package businessLogic.userbl;

import businessLogicService.userBLService.RechargeCreditBLService;

/**
 * 
 * @author 费慧通
 *
 */
public class RechargeCreditController implements RechargeCreditBLService{
	User user = new User();
	
	/**
	 * 充值信用值(controller)
	 * @param id String
	 * @param creditRecharge int
	 * @return 成功返回true,失败返回false
	 */
	public boolean RechargeCredit(String usertype,String id,int creditRecharge){
		return user.RechargeCredit(usertype,id,creditRecharge);
	}
}
