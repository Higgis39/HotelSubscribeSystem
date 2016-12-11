package businessLogicService.hotelBLService;

import vo.HotelVO;

public interface ViewService {
	public HotelVO View(String hotelName);

	public HotelVO ViewByid(String id);
}
