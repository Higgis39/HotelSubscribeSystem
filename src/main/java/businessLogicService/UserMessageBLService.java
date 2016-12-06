package businessLogicService;

import java.util.ArrayList;

import businessLogic.userbl.PersonalMessage;

/**
 * 
 * @author 费慧通
 *
 */
public interface UserMessageBLService {
	public PersonalMessage GetMessage(String id);
	
	public boolean ChangeMessage(String id,String newname,String newphonenumber);
	
	public ArrayList<String> GetCreditChange(String id);
}
