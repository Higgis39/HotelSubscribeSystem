package vo;

/**
 * 
 * @author 费慧通
 *
 *界面之间传输order的id
 */
public class OrderIdVO {

	private static String orderid;
	
	public static void setorderid(String id){
		orderid = id;
	}
	
	public static String getorderid(){
		return orderid;
	}
}
