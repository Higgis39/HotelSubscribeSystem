package businessLogicService.userBLService;

import java.util.ArrayList;

import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 */
public interface MessageBLService {
	public UserVO GetMessage(String id);
	
	public boolean ChangeMessage(String id,String newname,String newphonenumber);
	
	public boolean ChangeBirOrCom(String id,String birorcom);
	
	public ArrayList<String> GetCreditChange(String id);
}
