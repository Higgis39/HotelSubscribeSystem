package businessLogic.orderbl.stub;

public interface HotelInfoForOrder {

	public int CheckEnoughRoom(String HotelID,String RoomType);
	
	public String[] getHotelRoomPrice(String Hotel);
	
	public boolean updateRoom(String HotelID,String RoomType);
}
