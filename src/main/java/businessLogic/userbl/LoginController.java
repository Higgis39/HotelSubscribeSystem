package businessLogic.userbl;

public class LoginController {
	User user = new User();
	
	/**
	 * 登录(Controller)
	 * @param id String
	 * @param password String
	 * @param usertype String
	 * @return 成功返回true,失败返回false
	 */
	public boolean Login(String id,String password,String usertype){
		return user.Login(id,password,usertype);
	}
}
