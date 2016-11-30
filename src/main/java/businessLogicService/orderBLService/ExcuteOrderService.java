package businessLogicService.orderBLService;

import vo.OrderVO;

public interface ExcuteOrderService {
    public boolean addMember(String ID,String password);
	
	public boolean Excute(String OrderID);
	
	public boolean CheckIn(OrderVO vo);
}
