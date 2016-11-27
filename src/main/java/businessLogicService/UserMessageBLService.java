package businessLogicService;

import businessLogic.userbl.CreditChange;
import businessLogic.userbl.PersonalMessage;

public interface UserMessageBLService {
	public PersonalMessage GetMessage(String id);
	
	public boolean ChangeMessage(String id,String newname,String newphonenumber);
	
	public CreditChange GetCreditChange(String id);
}
