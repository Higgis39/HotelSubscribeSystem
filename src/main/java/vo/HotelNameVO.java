package vo;

/**
 * 
 * @author 费慧通
 *
 *界面之间传输酒店的名称
 */
public class HotelNameVO {
	private static String hotelname;
	
	public static String getHotelname(){
		return hotelname;
	}
	
	public static void sethotelname(String name){
		hotelname = name;
	}
}
