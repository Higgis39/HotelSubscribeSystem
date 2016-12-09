package businessLogic.userbl;

import data.UserData;
import dataService.UserDataService;

/**
 * 
 * @author 费慧通
 *
 *根据信用值修改会员等级
 */
public class CreditGrade {
	UserDataService userdataservice = new UserData();
	
	/**
	 * 根据信用值修改会员等级
	 * @param creditvalue
	 * @param VIPtype
	 * @return 会员等级
	 */
	public int setVIPgradeByCredit(int creditvalue,String VIPtype){
		int VIPgrade = 0;
		if(VIPtype.equals("普通会员")){
			if(creditvalue>=0&&creditvalue<=999){
				VIPgrade = 1;
			}else if(creditvalue>=1000&&creditvalue<=1999){
				VIPgrade = 2;
			}else if(creditvalue>=2000&&creditvalue<=2999){
				VIPgrade = 3;
			}else if(creditvalue>=3000&&creditvalue<=3999){
				VIPgrade = 4;
			}else if(creditvalue>=4000){
				VIPgrade = 5;
			}
		}else{
			if(creditvalue>=0&&creditvalue<1200){
				VIPgrade = 1;
			}else if(creditvalue>=1200&&creditvalue<2400){
				VIPgrade = 2;
			}else if(creditvalue>=2400&&creditvalue<3600){
				VIPgrade = 3;
			}else if(creditvalue>=3600&&creditvalue<4800){
				VIPgrade = 4;
			}else if(creditvalue>=4800){
				VIPgrade = 5;
			}
		}
		return VIPgrade;
	}
}
