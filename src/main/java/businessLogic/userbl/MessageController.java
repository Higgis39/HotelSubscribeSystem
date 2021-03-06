package businessLogic.userbl;

import java.util.ArrayList;

import businessLogicService.userBLService.MessageBLService;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 */
public class MessageController implements MessageBLService {
	User user = new User();
	
	/**
	 * 查看个人信息(controller)
	 * @param id String
	 * @return 返回用户的基本信息
	 */
	public UserVO GetMessage(String id){
		return user.GetMessage(id);
	}
	
	/**
	 * 修改个人信息(controller)
	 * @param id String
	 * @param newname String
	 * @param newphonenumber String
	 * @return 成功返回true,失败返回false
	 */
	public boolean ChangeMessage(String id,String newname,String newphonenumber){
		return user.ChangeMessage(id,newname,newphonenumber);
	}
	
	/**
	 * 修改生日/企业
	 * @param id
	 * @param birorcom
	 * @return
	 */
	public boolean ChangeBirOrCom(String id,String birorcom){
		return user.ChangeBirOrCom(id, birorcom);
	}
	
	/**
	 * 查看信用变化(controller)
	 * @param id String
	 */
	public ArrayList<String> GetCreditChange(String id){
		return user.GetCreditChange(id);
	}
}
