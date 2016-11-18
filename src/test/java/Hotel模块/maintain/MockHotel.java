package maintain;

public class MockHotel extends Hotel{
	String Hotelname;
	
	public MockHotel(String p1){
		Hotelname=p1;
	}
	
	public boolean UpdateHotelMessage(String new_name,String new_phone){
		HotelPO hotel1 = new HotelPO("如家", "151XXXX7532", "南京", "栖霞区", "", "Wifi仅在房间内有效", "8.8", 4.0);
		HotelPO hotel2 = new HotelPO("格林豪泰", "152XXXX5098", "南京", "栖霞区", "", "Wifi全覆盖", "8.6", 3.8);
//		String HotelName1=hotel1.getName();
//		String HotelPhone1=hotel1.getPhone();
//		
//		String HotelName2=hotel2.getName();
//		String HotelPhone2=hotel2.getPhone();
		
		hotel1.UpdateMessage(new_name, new_phone);
		hotel2.UpdateMessage(new_name, new_phone);
		
		if(hotel1.getName()==new_name && hotel1.getPhone()==new_phone){
			return true;
		}else if(hotel2.getName()==new_name && hotel2.getPhone()==new_phone){
			return true;
		}else{
			return false;
		}
		
	}
}
