package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.ArrayList;

import po.HotelPO;
import businessLogic.orderbl.HotelInfoForOrder;
import data.HotelData;
import data.RoomData;
import dataService.HotelDataService;
import dataService.RoomDataService;
import po.RoomPO;

public class HotelToolForOrder implements HotelInfoForOrder{
	RoomDataService roomdataservice = new RoomData();
	HotelDataService hoteldataservice = new HotelData();
	
	/**
	 * 查询该酒店的某种房间类型的数量
	 * @param HotelID
	 * @param RoomType
	 * @return 某种房间类型的数量
	 * @throws SQLException 
	 */
	public int CheckEnoughRoom(String HotelName, String RoomType) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(HotelName);
		
		int roomnum=0;
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType().equals(RoomType)){
				roomnum=roomnum+RoomPOList.get(i).getRoomNum();
			}
		}
		
		return roomnum;
	};
	
	/**
	 * 查询该酒店某房间类型的最大入住人数
	 * @param HotelID
	 * @param RoomType
	 * @return
	 * @throws SQLException 
	 */
	public int CheckMaxInRoom(String HotelName,String RoomType) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(HotelName);
		
		int peoplenum=0;
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType().equals(RoomType)){
				peoplenum=peoplenum+RoomPOList.get(i).getPeopleNumber();
			}
		}
		
		return peoplenum;
	};
	
	/**
	 * 查询酒店某种房间类型的价格
	 * @param HotelID
	 * @param RoomType
	 * @return
	 */
	public int getHotelRoomPrice(String HotelName,String RoomType) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(HotelName);
		int roomprice=0;
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType().equals(RoomType)){
				roomprice=roomprice+RoomPOList.get(i).getRoomPrice();
			}
		}
		
		return roomprice;
	};
	
	/**
	 * 更新酒店房间数量
	 * @param HotelID
	 * @param RoomType
	 * @param RoomNum
	 * @return
	 */
	public boolean updateRoom(String HotelName,String RoomType,int RoomNum)throws SQLException{
		ArrayList<RoomPO> RoomPOList = roomdataservice.findByHotelname(HotelName);
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType().equals(RoomType)){
				RoomPOList.get(i).setRoomNum(RoomNum);
			}
		}		
		return true;
	};
	/**
	 * 更新酒店评分
	 * @param HotelID
	 * @param point
	 * @return
	 */
	public boolean updatePoint(String HotelName,double point){
		HotelPO hotelpo = hoteldataservice.findByName(HotelName);
		
		hotelpo.setGrade(point);
		return true;
	};
}
