package dataService;

import po.HotelPO;

public interface HotelDataService {
	/**
	 * 根据id进行查找单一持久化对象
	 * @param hotelid String
	 * @return 返回与id对应的UserPO
	 */
	public HotelPO find(String hotelid);
	
	/**
	 * 插入单一持久化对象
	 * @param hotelpo HotelPO
	 */
	public void insert(HotelPO hotelpo);
	
	/**
	 * 更新单一持久化对象
	 * @param hotelpo HotelPO
	 */
	public void update(HotelPO hotelpo);
	
	/**
	 * 为新添加的酒店分配账号
	 * @return 返回id
	 */
	public String distributeid();
}
