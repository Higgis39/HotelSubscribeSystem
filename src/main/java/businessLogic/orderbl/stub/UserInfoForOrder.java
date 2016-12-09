package businessLogic.orderbl.stub;

import po.UserPO;

public interface UserInfoForOrder {

	public int getCredit(String UserID);
	
	public boolean ChangeCredit(String UserID,int CreditChange);
}
