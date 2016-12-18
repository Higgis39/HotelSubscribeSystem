package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.ArrayList;

import po.RoomPO;
import businessLogic.orderbl.OrderToolForHotel;
import data.HotelData;
import data.RoomData;
import vo.HotelVO;
import vo.RoomVO;
import dataService.HotelDataService;
import dataService.RoomDataService;
import po.HotelPO;

public class Hotel{
	HotelDataService hoteldataservice = new HotelData();
	OrderInfoForHotel orderdataservice = new OrderToolForHotel();
	RoomDataService roomdataservice = new RoomData();
	/**
	 * 搜索酒店
	 * @param Address String
	 * @param BusinessArea String
	 * @param RoomType String
	 * @param price String
	 * @param checkinTime String
	 * @param checkoutTime String
	 * @param Star String
	 * @param grade String
	 * @param hasfixed boolean
	 * @return 返回符合搜索条件的酒店列表
	 * @throws SQLException 
	 */
	
	public ArrayList<HotelVO> Search(String hotelName, String city, String BusinessArea, String RoomType, String price, String checkinTime, String checkoutTime, int Star, String grade,boolean hasfixed) throws SQLException{
//		double mingrade,maxgrade;
//		if(grade.equals("1分以下")){
//			mingrade = 0;
//			maxgrade = 1;
//		}else if(grade.equals("1~2分")){
//			mingrade = 1;
//			maxgrade = 2;
//		}else if(grade.equals("2~3分")){
//			mingrade = 2;
//			maxgrade = 3;
//		}else if(grade.equals("3~4分")){
//			mingrade = 3;
//			maxgrade = 4;
//		}else{
//			mingrade = 4;
//			maxgrade = 5;
//		}
		ArrayList<HotelPO> HotelPOList = new ArrayList<HotelPO>();
		HotelPOList = hoteldataservice.findByAddressAndBusinessarea(city, BusinessArea);
		ArrayList<HotelVO> HotelVOList = new ArrayList<HotelVO>();
		
//		if(Star==-1 && mingrade==-1 && maxgrade==-1){
//			HotelPOList=hoteldataservice.findByAddressAndBusinessarea(Address, BusinessArea);
//		}else if(mingrade ==-1 && maxgrade==-1){
//			HotelPOList=hoteldataservice.findByAddressAndBusinessareaAndStar(Address, BusinessArea, Star);
//		}else{
//			if(mingrade==-1){
//				HotelPOList=hoteldataservice.findByAddressAndBusinessareaAndGrade(Address, BusinessArea, Star);
//			}
//			else{
//				HotelPOList=hoteldataservice.findByAddressAndBusinessareaAndGrade(Address, BusinessArea, Star);
//			}
//		}
		

		int length=HotelPOList.size();
		for(int i=0;i<length;i++){
			HotelVO hotelvo = new HotelVO(HotelPOList.get(i).getHotelId(), HotelPOList.get(i).getPassword(), HotelPOList.get(i).getName(), 
					                      HotelPOList.get(i).getPhonenumber(), HotelPOList.get(i).getAddress(), HotelPOList.get(i).getBusinessArea(),
					                      HotelPOList.get(i).getIntroduction(), HotelPOList.get(i).getFacilities(), HotelPOList.get(i).getStar(), HotelPOList.get(i).getGrade());
			
			HotelVOList.add(hotelvo);
		}
		return HotelVOList;
	}
	
	/**
	 * 浏览酒店
	 * @param hotelName String
	 * @return 返回酒店的详细信息
	 */
	public HotelVO View(String hotelName){
		
		HotelPO hotelpo = hoteldataservice.findByName(hotelName);
		HotelVO hotelvo = new HotelVO(hotelpo.getHotelId(), hotelpo.getPassword(), hotelName, hotelpo.getPhonenumber(), 
				                      hotelpo.getAddress(),hotelpo.getBusinessArea(), hotelpo.getIntroduction(),
				                      hotelpo.getFacilities(),hotelpo.getStar(), hotelpo.getGrade());
		return hotelvo;
	}
	
	/**
	 * 浏览酒店
	 * @param id String
	 * @return 返回酒店的详细信息
	 */
	public HotelVO ViewByid(String id){
		
		HotelPO hotelpo = hoteldataservice.findById(id);
		
		HotelVO hotelvo = new HotelVO(id, hotelpo.getPassword(), hotelpo.getName(), hotelpo.getPhonenumber(), 
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
	public boolean UpdateHotelMessage(String hotelName,String address, String phoneNumber, String Introduction, String Facilities, int Star){
		
		HotelPO hotelpo = hoteldataservice.findByName(hotelName);
		hotelpo = new HotelPO(hotelpo.getHotelId(),hotelpo.getPassword(),hotelName,phoneNumber,address,hotelpo.getBusinessArea(),Introduction,Facilities,Star,hotelpo.getGrade());
		hoteldataservice.update(hotelpo);
		
		return true;
	}
	
	/**
	 * 得到酒店的空闲客房
	 * @param HotelName
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<RoomVO> getRoom(String HotelName) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(HotelName);
		
		ArrayList<RoomVO> RoomVOList = new ArrayList<RoomVO>();
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getIsEmpty()==true){
				RoomPO roompo = RoomPOList.get(i);
				RoomVO roomvo = new RoomVO(HotelName,roompo.getRoomType(), roompo.getPeopleNumber(), roompo.getRoomNum(), roompo.getRoomPrice());
				RoomVOList.add(roomvo);
			}
		}
		
		return RoomVOList;
	}
	
	/**
	 * 录入可用客房
	 * @param hotelname String
	 * @param roomtype String
	 * @param peoplenum Integer
	 * @param roomnum Integer
	 * @param price Integer
	 * @return 
	 */
	public boolean UpdateRoom(String hotelName,String roomtype,int peoplenum,int roomnum,int price)throws SQLException{
		ArrayList<RoomPO> RoomPOList = roomdataservice.findByHotelname(hotelName);
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType()==roomtype){
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()+roomnum);
				RoomPOList.get(i).setPeopleNumber(peoplenum);
				RoomPOList.get(i).setRoomPrice(price);
			}
		}
	
		return true;
	}
	
	/**
	 * 更新退房信息(线上)
	 * @param orderID String
	 * @param checkoutTime String
	 * @return UpdateState boolean
	 */
	public boolean CheckOut(String orderID, String checkoutTime){
		
		orderdataservice.Update(orderID,checkoutTime);
		boolean IsSuccess = orderdataservice.Update(orderID,checkoutTime);
		
		return IsSuccess;
	}
	
	/**
	 * 更新退房信息(线下)
	 * @param HotelName String
	 * @param roomType String
	 * @param num
	 * @return
	 * @throws SQLException 
	 */
	public boolean CheckOut(String HotelName,String roomType,int num) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(HotelName);
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType()==roomType){
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()+num);
			}
		}
		
		return true;
	}
	
	/**
	 * 登记入住信息(线下)
	 * @param HotelName String
	 * @param roomType String
	 * @param num
	 * @return
	 * @throws SQLException 
	 */
	public boolean CheckIn(String HotelName,String roomType,int num) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(HotelName);
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType()==roomType){
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()-num);
			}
		}
		
		return true;
	}
}