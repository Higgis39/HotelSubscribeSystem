package businessLogic.hotelbl;

import businessLogic.orderbl.HotelInfoForOrder;

public class HotelToolForOrder implements HotelInfoForOrder{
	@Override
	public int CheckEnoughRoom(String HotelID, String RoomType) {
		return 0;
	}

	@Override
	public String[] getHotelRoomPrice(String Hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRoom(String HotelID, String RoomType) {
		// TODO Auto-generated method stub
		return false;
	}

}
