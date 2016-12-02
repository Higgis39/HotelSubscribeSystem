package businessLogic.userbl;

import businessLogicService.UserRegisterClientBLService;

/**
 * 
 * @author 费慧通
 *
 */
public class RegisterClientController implements UserRegisterClientBLService{
	User user = new User();
	
	/**
	 * 注册用户(controller)
	 * @param name String
	 * @param password1 String
	 * @param password2 String
	 * @return 创建成功则返回分配的id
	 */
	public String RegisterClient(String name,String password1,String password2){
		return user.RegisterClient(name,password1,password2);
	}
}
