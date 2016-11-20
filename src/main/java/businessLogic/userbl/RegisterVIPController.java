package businessLogic.userbl;

public class RegisterVIPController {
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
