package businessLogic.hotelbl;

import po.HotelPO;
import po.WorkerPO;
import businessLogic.userbl.HotelInfoForUser;
import data.HotelData;
import data.WorkerData;
import dataService.HotelDataService;
import dataService.WorkerDataService;

public class HotelToolForUser implements HotelInfoForUser{
	HotelDataService hoteldataservice = new HotelData();
	WorkerDataService workerdataservice = new WorkerData();
	
    public boolean addHotel(String id,String password,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star){
    	HotelPO hotelpo = new HotelPO(id, password, hotelname, phonenumber, address, businessarea, introduction, facilities, star, 0);
    	
    	hoteldataservice.insert(hotelpo);
    	
    	return true;
    };
	
	public boolean addHotelWorker(String workername,String hotelname,int age,String sex,String begindate){
		WorkerPO workerpo = new WorkerPO(hotelname, workername, age, sex, begindate);
		
		workerdataservice.insert(workerpo);
		return true;
	};
}
