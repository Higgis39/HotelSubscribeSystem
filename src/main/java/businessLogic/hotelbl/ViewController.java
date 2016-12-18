package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.hotelBLService.ViewService;
import vo.HotelVO;
import vo.WorkerVO;

public class ViewController implements ViewService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 浏览酒店(Controller)
	 * @param hotelName String
	 * @return 返回酒店的详细信息
	 */
	public HotelVO View(String hotelName){
		return hotel.View(hotelName);
	}
	
	/**
	 * 浏览酒店
	 * @param id String
	 * @return 返回酒店的详细信息
	 */
	public HotelVO ViewByid(String id){
		return hotel.ViewByid(id);
	}
	
	/**
	 * 根据酒店账号查找酒店的工作人员
	 * @param hotelid
	 * @return
	 * @throws SQLException
	 */
	public List<WorkerVO> findworker(String hotelid) throws SQLException{
		return hotel.findworker(hotelid);
	}
}
