package businessLogicService.orderBLService;

import java.util.*;

import vo.OrderVO;


public interface ExcuteOrderService {
    public List<OrderVO> FindOrderByHotelID(String ID);
	
	public boolean CheckIn(OrderVO vo);
}
