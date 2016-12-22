package businessLogic.orderbl;

import java.sql.SQLException;

public interface HotelInfoForOrder {
	/**
	 * 查询该酒店的某种房间类型的数量
	 * @param HotelID
	 * @param RoomType
	 * @return 某种房间类型的数量
	 */
	public int CheckEnoughRoom(String HotelName, String RoomType)throws SQLException;
	
	/**
	 * 查询该酒店某房间类型的最大入住人数
	 * @param HotelID
	 * @param RoomType
	 * @return
	 */
	public int CheckMaxInRoom(String HotelName,String RoomType)throws SQLException;
	
	/**
	 * 查询酒店某种房间类型的价格
	 * @param HotelID
	 * @param RoomType
	 * @return
	 */
	public int getHotelRoomPrice(String HotelName,String RoomType)throws SQLException;
	/**
	 * 更新酒店房间数量
	 * @param HotelID
	 * @param RoomType
	 * @param RoomNum
	 * @return
	 */
	public boolean updateRoom(String HotelName,String RoomType,int RoomNum)throws SQLException;
	/**
	 * 更新酒店评分
	 * @param HotelID
	 * @param point
	 * @return
	 */
	public void updateGrade(String HotelName,int grade);
}
