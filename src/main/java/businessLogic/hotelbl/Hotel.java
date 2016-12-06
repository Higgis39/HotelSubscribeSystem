package businessLogic.hotelbl;


import java.util.ArrayList;

import data.HotelData;
import data.OrderData;
import po.OrderPO;
import vo.HotelVO;
import dataService.HotelDataService;
import dataService.OrderDataService;
import po.HotelPO;

public class Hotel{
	HotelDataService hoteldataservice = new HotelData();
	OrderInfoForHotel orderdataservice = new OrderInfoForHotel_stub();
	/**
	 * 搜索酒店
	 * @param Address String
	 * @param BusinessArea String
	 * @param Star String
	 * @param Grade String
	 * @return 返回符合搜索条件的酒店列表
	 */
	public ArrayList<HotelPO> Search(String Address,String BusinessArea,int Star,double Grade){
		ArrayList<HotelPO> HotelList1 = new ArrayList<HotelPO>();
		HotelList1 = hoteldataservice.findByAddress(Address);
		
		
		return HotelList1;
	}
	
	/**
	 * 浏览酒店
	 * @param hotelName String
	 * @return 返回酒店的详细信息
	 */
	public HotelVO View(String hotelName){
		
		HotelPO hotelpo = hoteldataservice.findByName(hotelName);
		HotelVO hotelvo = new HotelVO(hotelpo.getId(), hotelpo.getPassword(), hotelName, hotelpo.getPhonenumber(), 
				                      hotelpo.getAddress(),hotelpo.getBusinessArea(), hotelpo.getIntroduction(),
				                      hotelpo.getFacilities(),hotelpo.getStar(), hotelpo.getGrade(), hotelpo.getWorker());
		return hotelvo;
	}
	
	/**
	 * 维护酒店信息
	 * @param hotelName String
	 * @param phoneNumber String
	 * @param Introduction String
	 * @param Facilities String
	 * @param Star Integer
	 * @param Grade double
	 * @param Worker ArrayList<String>
	 * @return 成功返回true，失败返回false
	 */
	public boolean UpdateHotelMessage(String hotelName, String phoneNumber, String Introduction, String Facilities, int Star, double Grade, ArrayList<String> Worker){
		
		HotelPO hotelpo = hoteldataservice.findByName(hotelName);
		hotelpo = new HotelPO(hotelpo.getId(),hotelpo.getPassword(),hotelName,phoneNumber,hotelpo.getAddress(),hotelpo.getBusinessArea(),Introduction,Facilities,Star,Grade,Worker);
		hoteldataservice.update(hotelpo);
		
		return true;
	}
	
	/**
	 * 录入可用客房
	 * @param roomNumber Integer
	 * @param hotelname String
	 * @return roomList ArrayList<Integer>
	 */
	public ArrayList<Integer> UpdateRoom(int roomNumber,String hotelName){
		boolean roomstate = RoomDataService.findstate(roomNumber);
		ArrayList<Integer> spareRoom = new ArrayList<Integer>();
		spareRoom = RoomDataService.findList(hotelName);
		
		if(roomstate){
			spareRoom.add(roomNumber);
		}
		else{
			System.out.println("The room is not spare!");
		}
		
		return spareRoom;
	}
	
	/**
	 * 更新退房信息
	 * @param orderID String
	 * @param checkoutTime String
	 * @return UpdateState boolean
	 */
	public boolean CheckOut(String orderID, String checkoutTime){
		boolean IsSuccess = orderdataservice.Update(orderID,checkoutTime);
		return IsSuccess;
	}
}