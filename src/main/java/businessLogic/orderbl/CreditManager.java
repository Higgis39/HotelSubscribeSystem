/**
 * @author fc
 * 对于用户信用值的操作
 */
package businessLogic.orderbl;
import businessLogic.orderbl.UserInfoForOrder;
import businessLogic.userbl.UserInfotoOrder;
import po.OrderPO;
import po.UserPO;

public  class CreditManager {

	private UserInfoForOrder UserService=new UserInfotoOrder();
	private static CreditManager manager;
	private CreditManager(){
		super();
	}
	
	public static CreditManager getInstance(){
		if(manager==null)
			manager=new CreditManager();
		return manager;
	}
	/**
	 * 根据已撤销的订单计算用户应减少的信用值
	 * @param orderID
	 * @return
	 */
	public void subCredit(OrderPO po){
		int CreditChange = (int)po.getPrice();
		UserService.ChangeCredit(po.getUserId(), "撤销订单" ,0-CreditChange);
	}
	/**
	 * 根据已执行的订单价值计算用户应增加的信用值
	 * @param orderID
	 * @return
	 */
	public void addCredit(OrderPO po){
		int CreditChange = (int)po.getPrice();
		UserService.ChangeCredit(po.getUserId(), "成功下单" ,CreditChange);
	}
	/**
	 * 根据已撤销的订单计算用户应恢复的信用值
	 * @param orderID
	 * @return
	 */
	public void recoverCredit(OrderPO po,double RecoverPercent){
		int CreditChange = (int)(po.getPrice()*RecoverPercent);
		UserService.ChangeCredit(po.getUserId(), "恢复异常订单" ,CreditChange);
	}
	/**
	 * 检查用户的信用值是否达到下订单的最低标准
	 * @param userID
	 * @return 达到返回true，否则返回false
	 */
	public boolean checkCredit(String userID){
		if(UserService.getCredit(userID)>=0)
			return true;
		else
		    return false;
	}
}
