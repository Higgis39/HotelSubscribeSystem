package Hotel模块.searchAndView;

public class MockHotel extends Hotel{
	String condition1;
	String condition2;
	public MockHotel(String p1, String p2){
		condition1=p1;
		condition2=p2;
	}

	public boolean Search(String p1,String p2){
		if(condition1==p1 && condition2==p2)
			return true;
		else
			return false;
	}
	
	public String View(String name){
		HotelPO hotel1 = new HotelPO("���", "�Ͼ�", "��ϼ��", "", "Wifi���ڷ�������Ч", "8.8", 4.0);
		HotelPO hotel2 = new HotelPO("���ֺ�̩", "�Ͼ�", "��ϼ��", "", "Wifiȫ����", "8.6", 3.8);
		String HotelName1=hotel1.getName();
		String HotelName2=hotel2.getName();
		if(HotelName1==name){
			String hotelMessage=hotel1.getHotelMessage();
			return hotelMessage;
		}else if(HotelName2==name){
			String hotelMessage=hotel2.getHotelMessage();
			return hotelMessage;
		}else{
			return "No Hotel";
		}
	}
}
