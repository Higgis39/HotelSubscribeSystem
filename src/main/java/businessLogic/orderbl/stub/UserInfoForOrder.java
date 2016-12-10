package businessLogic.orderbl.stub;

import po.UserPO;

public interface UserInfoForOrder {

	/**
	 * 查询用户的信用值
	 * @param UserID
	 * @return
	 */
	public int getCredit(String UserID);
	/**
	 * 更改用户的信用值
	 * @param UserID
	 * @param CreditChange
	 * @return
	 */
	public boolean ChangeCredit(String UserID,int CreditChange);
}
