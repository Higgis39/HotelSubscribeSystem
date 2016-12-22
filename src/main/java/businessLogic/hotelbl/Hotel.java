package businessLogic.hotelbl;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
		
		if(grade==null){
			minGrade = 0;
			maxGrade = 0;
		}else if(grade.equals("1分以下")){
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
		
		double minPrice, maxPrice;
		if(price==null){
			minPrice = 0;
			maxPrice = 20000;
		}else if(price.equals("150以下")){
			minPrice = 0;
			maxPrice = 150;
		}else if(price.equals("150~300")){
			minPrice = 150;
			maxPrice = 300;
		}else if(price.equals("300~500")){
			minPrice = 300;
			maxPrice = 500;
		}else if(price.equals("500~700")){
			minPrice = 500;
			maxPrice = 700;
		}else if(price.equals("700~1000")){
			minPrice = 700;
			maxPrice = 1000;
		}else{
			minPrice = 1000;
			maxPrice = 20000;
		}
		
		ArrayList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<HotelPO> HotelPOList = new ArrayList<HotelPO>();
		ArrayList<HotelPO> HotelPOList2 = new ArrayList<HotelPO>();
		
		if(hasfixed == true){
			String tcity = '\''+city+'\'';
			String tbusinessArea = '\''+businessArea+'\'';
			param.put("name", "city");
			param.put("rela", "=");
			param.put("value", tcity);
			params.add(param);
			param = new HashMap<String, Object>();
			param.put("name", "businessarea");
			param.put("rela", "=");
			param.put("value", tbusinessArea);
			params.add(param);
			if(!hotelName.equals("")){
				param = new HashMap<String, Object>();
				String thotelName = '\''+hotelName+'\'';
				param.put("name", "hotelname");
				param.put("rela", "=");
				param.put("value", thotelName);
				params.add(param);
			}
			if(star!=0){
				param = new HashMap<String, Object>();
				param.put("name", "star");
				param.put("rela", "=");
				param.put("value", star);
				params.add(param);
			}
			if(grade!=null){
				param = new HashMap<String, Object>();
				param.put("name", "grade");
				param.put("rela", ">");
				param.put("value", minGrade);
				params.add(param);
				param = new HashMap<String, Object>();
				param.put("name", "grade");
				param.put("rela", "<");
				param.put("value", maxGrade);
				params.add(param);
			}
			if(price!=null){
				param = new HashMap<String, Object>();
				param.put("name", "roomPrice");
				param.put("rela", ">");
				param.put("value", minPrice);
				params.add(param);
				param = new HashMap<String, Object>();
				param.put("name", "roomPrice");
				param.put("rela", "<");
				param.put("value", maxPrice);
				params.add(param);
			}
			if(roomType!=null){
				param = new HashMap<String, Object>();
				String troomType = '\''+roomType+'\'';
				param.put("name", "roomType");
				param.put("rela", "=");
				param.put("value", troomType);
				params.add(param);
			}
			HotelPOList = hoteldataservice.pfind(params, userID);
			HotelPOList2 = HotelPOList;
//			if(hotelName.equals("")){
//				if(star == 0){
//					if(grade==null){
//						HotelPOList=hoteldataservice.pfindByCityAndBusinessarea(city, businessArea, userID);
//					}
//					else{
//						HotelPOList=hoteldataservice.pfindByCityAndBusinessareaAndGrade(city, businessArea, minGrade, maxGrade, userID);
//					}
//				}
//				else{
//					if(grade==null){
//						HotelPOList=hoteldataservice.pfindByCityAndBusinessareaAndStar(city, businessArea, star, userID);
//					}
//					else{
//						HotelPOList=hoteldataservice.pfindByAll(city, businessArea, star, minGrade, maxGrade, userID);
//					}
//				}
//			}
//			else{
//				HotelPOList = hoteldataservice.pfindByCityAndBusinessareaAndName(city, businessArea, hotelName, userID);
//			}
		}
		else{
//			if(hotelName.equals("")){
//				if(star == 0){
//					if(grade==null){
//						HotelPOList=hoteldataservice.findByCityAndBusinessarea(city, businessArea);
//					}
//					else{
//						HotelPOList=hoteldataservice.findByCityAndBusinessareaAndGrade(city, businessArea, minGrade, maxGrade);
//					}
//				}
//				else{
//					if(grade==null){
//						HotelPOList=hoteldataservice.findByCityAndBusinessareaAndStar(city, businessArea, star);
//					}
//					else{
//						HotelPOList=hoteldataservice.findByAll(city, businessArea, star, minGrade, maxGrade);
//					}
//				}
//			}
//			else{
//				HotelPOList = hoteldataservice.findByCityAndBusinessareaAndName(city, businessArea, hotelName);
//			}
			String tcity = '\''+city+'\'';
			String tbusinessArea = '\''+businessArea+'\'';
			param.put("name", "city");
			param.put("rela", "=");
			param.put("value", tcity);
			params.add(param);
			param = new HashMap<String, Object>();
			param.put("name", "businessarea");
			param.put("rela", "=");
			param.put("value", tbusinessArea);
			params.add(param);
			if(! hotelName.equals("")){
				param = new HashMap<String, Object>();
				String thotelName = '\''+hotelName+'\'';
				param.put("name", "hotelname");
				param.put("rela", "=");
				param.put("value", thotelName);
				params.add(param);
			}
			if(star!=0){
				param = new HashMap<String, Object>();
				param.put("name", "star");
				param.put("rela", "=");
				param.put("value", star);
				params.add(param);
			}
			if(grade!=null){
				param = new HashMap<String, Object>();
				param.put("name", "grade");
				param.put("rela", ">");
				param.put("value", minGrade);
				params.add(param);
				param = new HashMap<String, Object>();
				param.put("name", "grade");
				param.put("rela", "<");
				param.put("value", maxGrade);
				params.add(param);
			}
			if(price!=null){
				param = new HashMap<String, Object>();
				param.put("name", "roomPrice");
				param.put("rela", ">");
				param.put("value", minPrice);
				params.add(param);
				param = new HashMap<String, Object>();
				param.put("name", "roomPrice");
				param.put("rela", "<");
				param.put("value", maxPrice);
				params.add(param);
			}
			if(roomType!=null){
				param = new HashMap<String, Object>();
				String troomType = '\''+roomType+'\'';
				param.put("name", "roomType");
				param.put("rela", "=");
				param.put("value", troomType);
				params.add(param);
			}
			HotelPOList = hoteldataservice.find(params);
			HotelPOList2 = hoteldataservice.pfind(params, userID);
		}
		
		ArrayList<HotelVO> HotelVOList = new ArrayList<HotelVO>();

		int length=HotelPOList.size();
		for(int i=0;i<length;i++){
			HotelVO hotelvo = new HotelVO(HotelPOList.get(i).getHotelId(), HotelPOList.get(i).getPassword(), HotelPOList.get(i).getName(), 
					                      HotelPOList.get(i).getPhonenumber(),HotelPOList.get(i).getCity(), HotelPOList.get(i).getAddress(), HotelPOList.get(i).getBusinessArea(),
					                      HotelPOList.get(i).getIntroduction(), HotelPOList.get(i).getFacilities(), HotelPOList.get(i).getStar(), HotelPOList.get(i).getGrade(),HotelPOList.get(i).getminprice());
			
			if(FindFixedHotel(HotelPOList2,HotelPOList.get(i))){
				hotelvo.setIsIn(true);
			}else{
				hotelvo.setIsIn(false);
			}
			HotelVOList.add(hotelvo);
		}
		
		return HotelVOList;
	}
	
	/**
	 * 根据不同的排序方式进行排序
	 * @param list
	 * @param sortstyle
	 * @param sortaspect
	 * @return
	 */
	public ArrayList<HotelVO> SortHotel(ArrayList<HotelVO> list,String sortstyle,String sortaspect){
		ArrayList<HotelVO> result = new ArrayList<HotelVO>();
		if(sortstyle.equals("按酒店星级排序")){
			result = SortHotelByStar(list);
		}else if(sortstyle.equals("按酒店评分排序")){
			result = SortHotelByGrade(list);
		}else{
			result = SortHotelByMinprice(list);
		}
		
		if(sortaspect.equals("从小到大")){
			result = ReverseList(list);
		}
		System.out.println(result);
		return result;
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
				                      hotelpo.getFacilities(),hotelpo.getStar(), hotelpo.getGrade(),hotelpo.getminprice());
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
				                      hotelpo.getFacilities(),hotelpo.getStar(), hotelpo.getGrade(),hotelpo.getminprice());
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
		hotelpo = new HotelPO(hotelpo.getHotelId(),hotelpo.getPassword(),hotelName,phoneNumber,hotelpo.getCity(),address,hotelpo.getBusinessArea(),Introduction,Facilities,Star,hotelpo.getGrade(),hotelpo.getminprice());
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
		RoomPOList = roomdataservice.findByHotelName(HotelName);
		
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
		ArrayList<RoomPO> RoomPOList = roomdataservice.findByHotelName(hotelName);
		
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
		RoomPOList = roomdataservice.findByHotelName(hotelname);
		
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
		RoomPOList = roomdataservice.findByHotelName(HotelName);
		
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
		RoomPOList = roomdataservice.findByHotelName(HotelName);
		
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
		HotelPO hotelpo = hoteldataservice.findById(hotelid);
		if(hotelpo!=null){
			String hotelname = hotelpo.getName();
			List<WorkerPO> po = workerdataservice.findByHotelName(hotelname);
			List<WorkerVO> vo = new ArrayList<WorkerVO>();
			for(int i=0;i<po.size();i++){
				vo.add(new WorkerVO(po.get(i).getHotelName(),po.get(i).getName(),po.get(i).getAge(),po.get(i).getSex(),po.get(i).getBeginTime()));
			}
			return vo;
		}
		return null;
	}
	
	/**
	 * 判断酒店是否被预定过
	 * @param list
	 * @param po
	 * @return
	 */
	public boolean FindFixedHotel(ArrayList<HotelPO> list,HotelPO po){
		String id = po.getHotelId();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getHotelId().equals(id)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 根据酒店星级排序
	 * @param list
	 * @return
	 */
	public ArrayList<HotelVO> SortHotelByStar(ArrayList<HotelVO> list){
		ArrayList<HotelVO> result = new ArrayList<HotelVO>();
		int k = 0;
		while(list.size()!=0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getStar()>list.get(k).getStar()){
					k = i;
				}
			}
			result.add(list.get(k));
			list.remove(k);
			k = 0;
		}
		return result;
	}
	
	/**
	 * 根据酒店评分排序
	 * @param list
	 * @return
	 */
	public ArrayList<HotelVO> SortHotelByGrade(ArrayList<HotelVO> list){
		ArrayList<HotelVO> result = new ArrayList<HotelVO>();
		int k = 0;
		while(list.size()!=0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getGrade()>list.get(k).getGrade()){
					k = i;
				}
			}
			result.add(list.get(k));
			list.remove(k);
			k = 0;
		}
		return result;
	}
	
	/**
	 * 根据酒店房间最低价格排序
	 * @param list
	 * @return
	 */
	public ArrayList<HotelVO> SortHotelByMinprice(ArrayList<HotelVO> list){
		ArrayList<HotelVO> result = new ArrayList<HotelVO>();
		int k = 0;
		while(list.size()!=0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getminprice()>list.get(k).getminprice()){
					k = i;
				}
			}
			result.add(list.get(k));
			list.remove(k);
			k = 0;
		}
		return result;
	}
	
	/**
	 * 反转酒店列表
	 * @param list
	 * @return
	 */
	public ArrayList<HotelVO> ReverseList(ArrayList<HotelVO> list){
		ArrayList<HotelVO> result = new ArrayList<HotelVO>();
		for(int i=list.size()-1;i>=0;i--){
			result.add(list.get(i));
		}
		return result;
	}
}