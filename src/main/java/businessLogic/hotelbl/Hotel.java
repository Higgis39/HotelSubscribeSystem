package businessLogic.hotelbl;


import java.util.ArrayList;

import businessLogic.orderbl.OrderToolForHotel;
import data.HotelData;
import data.OrderData;
import po.OrderPO;
import vo.HotelVO;
import dataService.HotelDataService;
import dataService.OrderDataService;
import po.HotelPO;

public class Hotel{
	HotelDataService hoteldataservice = new HotelData();
	OrderInfoForHotel orderdataservice = new OrderToolForHotel();
	/**
	 * 搜索酒店
	 * @param Address String
	 * @param BusinessArea String
	 * @param RoomType String
	 * @param minPrice double
	 * @param maxPrice double
	 * @param checkinTime String
	 * @param checkoutTime String
	 * @param Star String
	 * @param minGrade double
	 * @param maxGrade double
	 * @return 返回符合搜索条件的酒店列表
	 */
	public ArrayList<HotelPO> Search(String Address, String BusinessArea, String RoomType, double minPrice, double maxPrice, String checkinTime, String checkoutTime, int Star, double minGrade, double maxGrade){
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
				                      hotelpo.getFacilities(),hotelpo.getStar(), hotelpo.getGrade());
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
	 * @param roomID String
	 * @param hotelname String
	 * @return roomList ArrayList<String>
	 */
	public boolean UpdateRoom(String roomID,String hotelName){
		boolean roomstate = RoomDataService.findstate(roomID);
		ArrayList<String> spareRoom = new ArrayList<String>();
		spareRoom = RoomDataService.findList(hotelName);
		
		if(roomstate){
			spareRoom.add(roomID);
		}
		else{
			System.out.println("The room is not spare!");
		}
		
		return true;
	}
	
	/**
	 * 更新退房信息
	 * @param orderID String
	 * @param checkoutTime String
	 * @return UpdateState boolean
	 */
	public boolean CheckOut(String orderID, String checkoutTime){
		
		orderdataservice.Update(orderID,checkoutTime);
		boolean IsSuccess = orderdataservice.Update(orderID,checkoutTime);
		
		return IsSuccess;
	}
}