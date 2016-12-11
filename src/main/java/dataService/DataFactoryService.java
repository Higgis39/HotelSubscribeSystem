package dataService;

import java.rmi.Remote;

public interface DataFactoryService extends Remote{
	public HotelDataService getHotelDataService();
	
	public HotelPromotionDataService getHotelPromotionDataService();
	
	public OrderDataService getOrderDataService();
	
	public RoomDataService getRoomDataService();
	
	public UserDataService getUserDataService();
	
	public WebPromotionDataService getWebPromotionDataService();
	
	public WorkerDataService getWorkerDataService();

}
