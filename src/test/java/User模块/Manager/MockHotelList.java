package Manager;

import java.util.ArrayList;

public class MockHotelList {
	ArrayList<String> Hotelname = new ArrayList<String>();
	ArrayList<String> Hoteladdress = new ArrayList<String>();
	ArrayList<String> Hotelphone = new ArrayList<String>();
	String[] HotelWorker = new String[10000];
	
	public MockHotelList(ArrayList<String> Hotelname,ArrayList<String> Hoteladdress,ArrayList<String> Hotelphone){
		this.Hotelname = Hotelname;
		this.Hoteladdress = Hoteladdress;
		this.Hotelphone = Hotelphone;
	}
	
	//添加酒店
	public boolean AddHotel(boolean IsManager,String hotelname,String addresss,String phoneNumber){
		if(IsManager==false){
			return false;
		}else{
			Hotelname.add(hotelname);
			Hoteladdress.add(addresss);
			Hotelphone.add(phoneNumber);
			return true;
		}
	}
	
	//添加酒店工作人员
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelname){
		if(IsManager==false){
			return false;
		}
		for(int i=0;i<Hotelname.size();i++){
			if(Hotelname.get(i).equals(hotelname)){
				HotelWorker[i] = HotelWorker[i]+" "+workername;
			}
		}
		return true;
	}
}
