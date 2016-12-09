package businessLogic.orderbl.stub;

import po.UserPO;

public class UserInfoForOrder_stub implements UserInfoForOrder{

	@Override
	public int getCredit(String UserID) {
		return 0;
	}

	@Override
	public boolean ChangeCredit(String UserID, int CreditChange) {
		// TODO Auto-generated method stub
		return false;
	}

}
