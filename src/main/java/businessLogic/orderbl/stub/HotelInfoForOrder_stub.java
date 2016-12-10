package businessLogic.orderbl.stub;

public class HotelInfoForOrder_stub implements HotelInfoForOrder{

	@Override
	public int getHotelRoomPrice(String HotelID, String RoomType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CheckEnoughRoom(String HotelID, String RoomType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CheckMaxInRoom(String HotelID, String RoomType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateRoom(String HotelID, String RoomType, int RoomNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePoint(String HotelID, int point) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
