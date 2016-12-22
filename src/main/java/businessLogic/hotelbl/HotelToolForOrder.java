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
/*
 * 
 * @author 梁先伟
 * 
 */
public class HotelToolForOrder implements HotelInfoForOrder{
	RoomDataService roomdataservice = new RoomData();
	HotelDataService hoteldataservice = new HotelData();
	
	/**
	 * 查询该酒店的某种房间类型的数量
	 * @param HotelName String
	 * @param RoomType String
	 * @return 某种房间类型的数量  Integer
	 * @throws SQLException 
	 */
	public int CheckEnoughRoom(String HotelName, String RoomType) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelName(HotelName);
		
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
	 * @param HotelName String
	 * @param RoomType String
	 * @return 某种房间的入住人数  Integer
	 * @throws SQLException 
	 */
	public int CheckMaxInRoom(String HotelName,String RoomType) throws SQLException{
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelName(HotelName);
		
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
	 * @param HotelName String
	 * @param RoomType String
	 * @return 某种房间的价格  Integer
	 */
	public int getHotelRoomPrice(String HotelId,String RoomType) throws SQLException{
		String HotelName = hoteldataservice.findById(HotelId).getName();
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelName(HotelName);
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
	 * @param HotelName String
	 * @param RoomType String
	 * @param RoomNum Integer
	 * @return
	 */
	public boolean updateRoom(String HotelId,String RoomType,int RoomNum)throws SQLException{
		String HotelName = hoteldataservice.findById(HotelId).getName();
		ArrayList<RoomPO> RoomPOList = roomdataservice.findByHotelName(HotelName);
		
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
	 * @param HotelName String
	 * @param point double
	 * @return
	 */
	public boolean updatePoint(String HotelId,double point){
		String HotelName = hoteldataservice.findById(HotelId).getName();
		HotelPO hotelpo = hoteldataservice.findByName(HotelName);
		
		hotelpo.setGrade(point);
		return true;
	};
	
	/**
	 * 更新酒店评分及评价人数
	 */
	public void updateGrade(String HotelName, int grade) {
		HotelPO tempHotel = hoteldataservice.findByName(HotelName);
		int number = tempHotel.getNumberofevaluators();
		double avegrade = (tempHotel.getGrade()*number+grade)/(number+1);
		number++;
		tempHotel.setNumberofevaluators(number);
		tempHotel.setGrade(avegrade);
		hoteldataservice.update(tempHotel);
	}
	
	public static void main(String[] args) {
		HotelToolForOrder a = new HotelToolForOrder();
		a.updateGrade("皇冠", 100);
	}
}
