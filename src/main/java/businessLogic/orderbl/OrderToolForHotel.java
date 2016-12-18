 package businessLogic.orderbl;

import businessLogic.hotelbl.OrderInfoForHotel;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;


public class OrderToolForHotel implements OrderInfoForHotel{
	/**
	 * @param orderID String
	 * @param checkoutTime String
	 * @return 更新订单信息成功返回true，否则返回false
	 */
	public boolean Update(String orderID,String checkoutTime){
		OrderDataService service = new OrderData();
		OrderPO po = service.findByOrderID(orderID);
		if(!po.getStatus().equals("已执行"))
			return false;
		po.setLastTime(checkoutTime);
		return true;
	};
}
