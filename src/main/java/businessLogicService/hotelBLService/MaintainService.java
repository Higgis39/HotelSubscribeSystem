package businessLogicService.hotelBLService;

import java.util.ArrayList;

public interface MaintainService {
	public boolean Maintain(String hotelName, String phoneNumber, String Introduction, String Facilities, int Star, double Grade, ArrayList<String> Worker);
}
