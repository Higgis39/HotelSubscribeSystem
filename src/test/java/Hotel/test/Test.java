package Hotel.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import vo.HotelVO;
import vo.WorkerVO;
import businessLogic.hotelbl.Hotel;
import po.HotelPO;

public class Test {
	Hotel hotel = new Hotel();
	
	@org.junit.Test
	public void testSearch() throws SQLException{
		ArrayList<HotelVO> hotelList1 = new ArrayList<HotelVO>(); 
		ArrayList<HotelVO> hotelList2 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList3 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList4 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList5 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList6 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList7 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList8 = new ArrayList<HotelVO>();
		
		assertEquals(hotelList1,hotel.Search("", "格林豪泰酒店", "南京市", "仙林中心", "双人间", "", "", "", 0, "", false));
		assertEquals(hotelList2,hotel.Search("00001", "格林豪泰酒店", "南京市", "仙林中心", "双人间", "", "", "", 0, "", true));
		assertEquals(hotelList3,hotel.Search("", "七天快捷酒店", "南京市", "仙林中心", "单人间", "", "", "", 0, "", false));
		assertEquals(hotelList4,hotel.Search("00001", "七天快捷酒店", "南京市", "仙林中心", "单人间", "", "", "", 0, "", true));
		assertEquals(hotelList5,hotel.Search("", "格林豪泰酒店", "南京市", "仙林中心", "", "", "", "", 0, "3~4分", false));
		assertEquals(hotelList6,hotel.Search("00001", "格林豪泰酒店", "南京市", "仙林中心", "", "", "", "", 0, "4分以上", true));
		assertEquals(hotelList7,hotel.Search("", "格林豪泰酒店", "南京市", "仙林中心", "", "", "", "", 4, "", false));
		assertEquals(hotelList8,hotel.Search("00001", "格林豪泰酒店", "南京市", "仙林中心", "", "", "", "", 5, "", true));
	}
	
	@org.junit.Test
	public void testSortHotel() throws SQLException {
		ArrayList<HotelVO> hotelList1 = new ArrayList<HotelVO>(); 
		ArrayList<HotelVO> hotelList2 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList3 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> hotelList4 = new ArrayList<HotelVO>();
		
		assertEquals(hotelList1,hotel.SortHotel(hotel.Search("", "格林豪泰酒店", "南京市", "仙林中心", "双人间", "", "", "", 0, "", false), "按酒店星级排序", "从小到大"));
		assertEquals(hotelList2,hotel.SortHotel(hotel.Search("00001", "格林豪泰酒店", "南京市", "仙林中心", "双人间", "", "", "", 0, "", true), "按酒店评分排序", "从大到小"));
		assertEquals(hotelList3,hotel.SortHotel(hotel.Search("", "七天快捷酒店", "南京市", "仙林中心", "单人间", "", "", "", 0, "", false), "按酒店星级排序", "从小到大"));
		assertEquals(hotelList4,hotel.SortHotel(hotel.Search("00001", "七天快捷酒店", "南京市", "仙林中心", "单人间", "", "", "", 0, "", true), "按酒店价格排序", "从大到小"));
	}
	
	@org.junit.Test
	public void testView() throws SQLException {
		ArrayList<HotelPO> hotelList1 = new ArrayList<HotelPO>();
		ArrayList<HotelPO> hotelList2 = new ArrayList<HotelPO>();
		
		assertEquals(hotelList1,hotel.View("格林豪泰酒店"));
		assertEquals(hotelList2,hotel.View("七天快捷酒店"));
	}
	
	@org.junit.Test
	public void testViewByid() throws SQLException {
		ArrayList<HotelPO> hotelList1 = new ArrayList<HotelPO>();
		ArrayList<HotelPO> hotelList2 = new ArrayList<HotelPO>();
		
		assertEquals(hotelList1,hotel.ViewByid("000001"));
		assertEquals(hotelList2,hotel.ViewByid("000002"));
	}
	
	@org.junit.Test
	public void testgetRoom() throws SQLException {
		ArrayList<HotelVO> roomList1 = new ArrayList<HotelVO>();
		ArrayList<HotelVO> roomList2 = new ArrayList<HotelVO>();
		
		assertEquals(roomList1,hotel.getRoom("格林豪泰酒店"));
		assertEquals(roomList2,hotel.getRoom("七天快捷酒店"));
	}
	
	@org.junit.Test
	public void testHastRoom() throws SQLException {
		assertEquals(true,hotel.HasRoom("格林豪泰酒店"));
		assertEquals(false,hotel.HasRoom("七天快捷酒店"));
	}
	
	@org.junit.Test
	public void testUpdateRoom() throws SQLException {
		assertEquals(true,hotel.UpdateRoom("格林豪泰酒店", "双人间", 2, 56, 259));
		assertEquals(true,hotel.UpdateRoom("七天快捷酒店", "单人间", 1, 35, 199));
	}
	
	@org.junit.Test
	public void testCheckOut() throws SQLException {
		assertEquals(true,hotel.CheckOut("格林豪泰酒店", "双人间", 56));
		assertEquals(true,hotel.CheckOut("七天快捷酒店", "单人间", 35));
	}
	
	@org.junit.Test
	public void testfindWorker() throws SQLException {
		ArrayList<WorkerVO> workerList1 = new ArrayList<WorkerVO>();
		ArrayList<WorkerVO> workerList2 = new ArrayList<WorkerVO>();
		
		assertEquals(workerList1,hotel.findworker("000001"));
		assertEquals(workerList2,hotel.findworker("000002"));
	}
}
