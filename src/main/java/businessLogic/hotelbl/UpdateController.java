package businessLogic.hotelbl;

public class UpdateController {
	
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
}
