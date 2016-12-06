package businessLogic.orderbl.stub;

import po.UserPO;

public class UserInfoForOrder_stub implements UserInfoForOrder{

	@Override
	public int getCredit() {
		return 0;
	}

	@Override
	public UserPO getUserByID(String ID) {
		return new UserPO();
	}

}
