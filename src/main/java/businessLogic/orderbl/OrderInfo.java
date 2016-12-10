package businessLogic.orderbl;

import businessLogic.hotelbl.OrderInfoForHotel;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;

public class OrderInfo implements OrderInfoForHotel{

	@Override
	public boolean Update(String OrderID, String CheckOutTime) {
		OrderDataService service = new OrderData();
		OrderPO po = service.findByOrderID(OrderID);
		if(!po.getStatus().equals("已执行"))
			return false;
		po.setLastTime(CheckOutTime);
		return true;
	}
	
}