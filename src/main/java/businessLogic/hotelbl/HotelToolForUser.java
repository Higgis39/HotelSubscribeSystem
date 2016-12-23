package businessLogic.hotelbl;

import po.HotelPO;
import po.WorkerPO;
import vo.WorkerVO;

import java.sql.SQLException;
import java.util.List;

import businessLogic.userbl.HotelInfoForUser;
import data.HotelData;
import data.WorkerData;
import dataService.HotelDataService;
import dataService.WorkerDataService;
/*
 * 
 * @author 梁先伟
 * 
 */
public class HotelToolForUser implements HotelInfoForUser{
	HotelDataService hoteldataservice = new HotelData();
	WorkerDataService workerdataservice = new WorkerData();
	
    public boolean addHotel(String id,String password,String hotelname,String phonenumber,String city,String address,String businessarea,String introduction,String facilities,int star){
    	HotelPO hotelpo = new HotelPO(id, password, hotelname, phonenumber,city, address, businessarea, introduction, facilities, star, 0, 0, 1);
    	
    	hoteldataservice.insert(hotelpo);
    	
    	return true;
    };
	
	public boolean addHotelWorker(String workername,String hotelname,int age,String sex,String begindate){
		WorkerPO workerpo = new WorkerPO(hotelname, workername, age, sex, begindate);
		
		workerdataservice.insert(workerpo);
		return true;
	};
	
	public boolean ChangeHotelWorkerMessage(String hotelid,String name,int age,String sex,String begindate) throws SQLException{
		String hotelname = hoteldataservice.findById(hotelid).getName();
		List<WorkerPO> list = workerdataservice.findByHotelName(hotelname);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals(name)){
				list.get(i).setAge(age);
				list.get(i).setSex(sex);
				list.get(i).setBeginTime(begindate);
				workerdataservice.update(list.get(i));
			}
		}
		return true;
	}
}
