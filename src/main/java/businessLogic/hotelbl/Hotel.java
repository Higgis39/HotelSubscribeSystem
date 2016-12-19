package businessLogic.hotelbl;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import po.RoomPO;
import po.WorkerPO;
import businessLogic.orderbl.OrderToolForHotel;
import data.HotelData;
import data.RoomData;
import data.WorkerData;
import vo.HotelVO;
import vo.RoomVO;
import vo.WorkerVO;
import dataService.HotelDataService;
import dataService.RoomDataService;
import dataService.WorkerDataService;
import po.HotelPO;
/*
 * 
 * @author 梁先伟
 * 
 */
public class Hotel{
	HotelDataService hoteldataservice = new HotelData();
	OrderInfoForHotel orderdataservice = new OrderToolForHotel();
	RoomDataService roomdataservice = new RoomData();
	WorkerDataService workerdataservice = new WorkerData();
	
	/**
	 * 搜索酒店
	 * @param userID String
	 * @param hotelName String
	 * @param city String
	 * @param businessArea String
	 * @param roomType String
	 * @param price String
	 * @param checkinTime String
	 * @param checkoutTime String
	 * @param star String
	 * @param grade String
	 * @param hasfixed boolean
	 * @return 返回符合搜索条件的酒店列表
	 * @throws SQLException 
	 */
	public ArrayList<HotelVO> Search(String userID, String hotelName, String city, String businessArea, String roomType, String price, String checkinTime, String checkoutTime, int star, String grade,boolean hasfixed) throws SQLException{
		double minGrade,maxGrade;
		
		if(grade.equals("1分以下")){
			minGrade = 0;
			maxGrade = 1.0;
		}else if(grade.equals("1~2分")){
			minGrade = 1.0;
			maxGrade = 2.0;
		}else if(grade.equals("2~3分")){
			minGrade = 2.0;
			maxGrade = 3.0;
		}else if(grade.equals("3~4分")){
			minGrade = 3.0;
			maxGrade = 4.0;
		}else{
			minGrade = 4.0;
			maxGrade = 5.0;
		}
		
		ArrayList<HotelPO> HotelPOList = new ArrayList<HotelPO>();
		
		if(hasfixed == true){
			if(hotelName == ""){
				if(star == 0){
					if(grade.equals(null)){
						HotelPOList=hoteldataservice.pfindByCityAndBusinessarea(city, businessArea, userID);
					}
					else{
						HotelPOList=hoteldataservice.pfindByCityAndBusinessareaAndGrade(city, businessArea, minGrade, maxGrade, userID);
					}
				}
				else{
					if(grade.equals(null)){
						HotelPOList=hoteldataservice.pfindByCityAndBusinessareaAndStar(city, businessArea, star, userID);
					}
					else{
						HotelPOList=hoteldataservice.pfindByAll(city, businessArea, star, minGrade, maxGrade, userID);
					}
				}
			}
			else{
				HotelPOList = hoteldataservice.pfindByCityAndBusinessareaAndName(city, businessArea, hotelName, userID);
			}
		}
		else{
			if(hotelName == ""){
				if(star == 0){
					if(grade.equals(null)){
						HotelPOList=hoteldataservice.findByCityAndBusinessarea(city, businessArea);
					}
					else{
						HotelPOList=hoteldataservice.findByCityAndBusinessareaAndGrade(city, businessArea, minGrade, maxGrade);
					}
				}
				else{
					if(grade.equals(null)){
						HotelPOList=hoteldataservice.findByCityAndBusinessareaAndStar(city, businessArea, star);
					}
					else{
						HotelPOList=hoteldataservice.findByAll(city, businessArea, star, minGrade, maxGrade);
					}
				}
			}
			else{
				HotelPOList = hoteldataservice.findByCityAndBusinessareaAndName(city, businessArea, hotelName);
			}
		}

		ArrayList<HotelVO> HotelVOList = new ArrayList<HotelVO>();

		int length=HotelPOList.size();
		for(int i=0;i<length;i++){
			HotelVO hotelvo = new HotelVO(HotelPOList.get(i).getHotelId(), HotelPOList.get(i).getPassword(), HotelPOList.get(i).getName(), 
					                      HotelPOList.get(i).getPhonenumber(),HotelPOList.get(i).getCity(), HotelPOList.get(i).getAddress(), HotelPOList.get(i).getBusinessArea(),
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
				hotelpo.getCity(),hotelpo.getAddress(),hotelpo.getBusinessArea(), hotelpo.getIntroduction(),
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
				hotelpo.getCity(),hotelpo.getAddress(),hotelpo.getBusinessArea(), hotelpo.getIntroduction(),
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
		boolean IsFind = false;
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType().equals(roomtype)){
				IsFind = true;
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()+roomnum);
				RoomPOList.get(i).setPeopleNumber(peoplenum);
				RoomPOList.get(i).setRoomPrice(price);
				roomdataservice.update(RoomPOList.get(i));
			}
		}
		
		if(IsFind == false){
			RoomPO roompo = new RoomPO(hotelName,roomnum,peoplenum,price,roomtype);
			roomdataservice.insert(roompo);
		}
	
		return true;
	}
	
	/**
	 * 更新退房信息(线上)
	 * @param orderID String
	 * @param checkoutTime String
	 * @return UpdateState boolean
	 * @throws SQLException 
	 */
	public boolean CheckOut(String hotelname,String orderID,String room,int num, String checkoutTime) throws SQLException{
		boolean IsSuccess = orderdataservice.Update(orderID,checkoutTime);
		ArrayList<RoomPO> RoomPOList = new ArrayList<RoomPO>();
		RoomPOList = roomdataservice.findByHotelname(hotelname);
		
		int length=RoomPOList.size();
		for(int i=0;i<length;i++){
			if(RoomPOList.get(i).getRoomType().equals(room)){
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()+num);
				roomdataservice.update(RoomPOList.get(i));
			}
		}
		
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
			if(RoomPOList.get(i).getRoomType().equals(roomType)){
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()+num);
				roomdataservice.update(RoomPOList.get(i));
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
			if(RoomPOList.get(i).getRoomType().equals(roomType)){
				RoomPOList.get(i).setRoomNum(RoomPOList.get(i).getRoomNum()-num);
				roomdataservice.update(RoomPOList.get(i));
			}
		}
		
		return true;
	}
	
	/**
	 * 根据酒店账号查找酒店的工作人员
	 * @param hotelid
	 * @return
	 * @throws SQLException
	 */
	public List<WorkerVO> findworker(String hotelid) throws SQLException{
		String hotelname = hoteldataservice.findById(hotelid).getName();
		List<WorkerPO> po = workerdataservice.findByHotelName(hotelname);
		List<WorkerVO> vo = new ArrayList<WorkerVO>();
		for(int i=0;i<po.size();i++){
			vo.add(new WorkerVO(po.get(i).getHotelName(),po.get(i).getName(),po.get(i).getAge(),po.get(i).getSex(),po.get(i).getBeginTime()));
		}
		return vo;
	}
}