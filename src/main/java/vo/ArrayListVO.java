package vo;

import java.util.ArrayList;

public class ArrayListVO {
	private static ArrayList<HotelVO> hotelvolist;
	
	public static ArrayList<HotelVO> getArrayList(){
		return hotelvolist;
	}
	
	public static void setArrayList(ArrayList<HotelVO> list){
		hotelvolist = list;
	}
}
