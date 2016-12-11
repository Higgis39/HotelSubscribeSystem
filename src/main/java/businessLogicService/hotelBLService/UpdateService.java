package businessLogicService.hotelBLService;

public interface UpdateService {
	public boolean CheckOut(String orderID, String checkoutTime);
	
	public boolean CheckIn(int num);
	
	public boolean CheckOut(int num);
}
