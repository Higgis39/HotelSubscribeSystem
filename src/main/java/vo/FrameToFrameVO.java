package vo;

import java.util.ArrayList;

import javafx.stage.Stage;

/**
 * 
 * @author 费慧通
 *
 *界面之间跳转所传输的数据
 */
public class FrameToFrameVO {
	private static ArrayList<HotelVO> hotelvolist;
	
	private static String id;
	
	private static String otherid;
	
	private static String orderid;
	
	private static Stage stage;
	
	private static Stage stage2;
	
	private static String word;
	
	private static String hotelname;
	
	public static ArrayList<HotelVO> getArrayList(){
		return hotelvolist;
	}
	
	public static void setArrayList(ArrayList<HotelVO> list){
		hotelvolist = list;
	}

	public static void setid(String i){
		id = i;
	}
	
	public static String getid(){
		return id;
	}
	
	public static String getorderid(){
		return orderid;
	}
	
	public static void setorderid(String id){
		orderid = id;
	}
	
	public static void setotherid(String id){
		otherid = id;
	}
		
	public static String getotherid(){
		return otherid;
	}
	
	public static Stage getSatge(){
		return stage;
	}
	
	public static void setStage(Stage s){
		stage = s;
	}
	
	public static Stage getSatge2(){
		return stage2;
	}
	
	public static void setStage2(Stage s){
		stage2 = s;
	}
	
	public static void setword(String w){
		word = w;
	}
	
	public static String getword(){
		return word;
	}
	
	public static String getHotelname(){
		return hotelname;
	}
	
	public static void sethotelname(String name){
		hotelname = name;
	}
}
