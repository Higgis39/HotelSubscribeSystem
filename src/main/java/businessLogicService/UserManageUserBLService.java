package businessLogicService;

/**
 * 
 * @author 费慧通
 *
 */
import businessLogic.userbl.PersonalMessage;

public interface UserManageUserBLService {
	public PersonalMessage ViewClientMessage(boolean IsManager,String id);
	
	public boolean ChangeClientMessaage(boolean IsManager,String id,String newname,String newphonenumber);

}
