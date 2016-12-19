package vo;

import java.util.ArrayList;

/**
 * 
 * @author 费慧通
 *
 *用户主界面和搜索结果界面之间传输搜索得到的酒店列表
 */
public class ArrayListVO {
	private static ArrayList<HotelVO> hotelvolist;
	
	public static ArrayList<HotelVO> getArrayList(){
		return hotelvolist;
	}
	
	public static void setArrayList(ArrayList<HotelVO> list){
		hotelvolist = list;
	}
}
