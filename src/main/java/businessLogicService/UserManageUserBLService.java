package businessLogicService;

import businessLogic.userbl.PersonalMessage;

public interface UserManageUserBLService {
	public PersonalMessage ViewClientMessage(boolean IsManager,String id);
	
	public boolean ChangeClientMessaage(boolean IsManager,String id,String newname,String newphonenumber);

}