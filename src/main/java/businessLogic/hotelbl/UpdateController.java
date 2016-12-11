package businessLogic.hotelbl;

import businessLogicService.hotelBLService.UpdateService;

public class UpdateController implements UpdateService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 更新退房信息
	 * @param orderID String
	 * @param checkoutTime String
	 * @param checkoutDate String
	 * @return UpdateState boolean
	 */
	
	public boolean CheckOut(String orderID, String checkoutTime){
		return hotel.CheckOut(orderID, checkoutTime);
	}
	
	/**
	 * 登记入住信息(线下)
	 * @param num int
	 */
	public boolean CheckIn(int num){
		return hotel.CheckIn(num);
	}
	
	/**
	 * 更新退房信息(线下)
	 * @param num
	 * @return
	 */
	public boolean CheckOut(int num){
		return hotel.CheckOut(num);
	}
}
