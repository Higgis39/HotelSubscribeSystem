package businessLogic.orderbl.stub;

public interface HotelInfoForOrder {
	public int CheckEnoughRoom(String HotelID, String RoomType);
	
	public int CheckMaxInRoom(String HotelID,String RoomType);
	
	public int getHotelRoomPrice(String HotelID,String RoomType);
	
	public boolean updateRoom(String HotelID,String RoomType,int RoomNum);
}
