package RMI;

import java.rmi.Remote;

import dataService.DataFactoryService;
import dataService.HotelDataService;
import dataService.HotelPromotionDataService;
import dataService.OrderDataService;
import dataService.RoomDataService;
import dataService.UserDataService;
import dataService.WebPromotionDataService;
import dataService.WorkerDataService;

public class RemoteHelper{
		private Remote remote;
		private static RemoteHelper remoteHelper = new RemoteHelper();
		public static RemoteHelper getInstance(){
			return remoteHelper;
		}
		
		private RemoteHelper() {
		}
		
		public void setRemote(Remote remote){
			this.remote = remote;
		}
		
		public HotelDataService getHotelDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getHotelDataService();
		}
		
		public HotelPromotionDataService getHotelPromotionDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getHotelPromotionDataService();
		}
		
		public OrderDataService getOrderDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getOrderDataService();
		}
		
		public RoomDataService getRoomDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getRoomDataService();
		}
		
		public UserDataService getUserDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getUserDataService();
		}
		
		public WebPromotionDataService getWebPromotionDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getWebPromotionDataService();
		}
		
		public WorkerDataService getWorkerDataService(){
			DataFactoryService service = (DataFactoryService)remote;
			return service.getWorkerDataService();
		}

}