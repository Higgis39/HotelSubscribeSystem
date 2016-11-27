package dataService;

import po.UserPO;

public interface UserDataService {
	/**
	 * 根据id进行查找单一持久化对象
	 * @param id String
	 * @return 返回与id对应的UserPO
	 */
	public UserPO find(String id);
	
	/**
	 * 插入单一持久化对象
	 * @param userpo UserPO
	 */
	public void insert(UserPO userpo);
	
	/**
	 * 更新单一持久化对象
	 * @param userpo UserPO
	 */
	public void update(UserPO userpo);
	
	/**
	 * 给新注册的客户分配id
	 * @return 返回id
	 */
	public String distributeid();
}
