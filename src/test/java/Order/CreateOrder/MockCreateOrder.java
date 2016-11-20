package Order.CreateOrder;

import Order.CommentOrder.MockPromotionPO;

public class MockCreateOrder {
	public OrderPO NewOrder;
    public boolean checkCredit(String userID){
    	return true;
    }
    
    public void addOrderInfo(OrderPO order){
    	NewOrder=order;
    }
    
    public MockPromotionPO findBestPromotion(OrderPO order){
    	return new MockPromotionPO();
    }
    
    public int getTotal(OrderPO order){
    	return 100;
    }
    
    public void addNewOrder(OrderPO order){
    	
    }
}
