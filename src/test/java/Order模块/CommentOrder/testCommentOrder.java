package Order模块.CommentOrder;
import static org.junit.Assert.*;
import org.junit.Test;
import Order模块.CommentOrder.*;

public class testCommentOrder {
	MockCommentOrder co=new MockCommentOrder();
	OrderPO po = new OrderPO("0000","2016.11.11","2016.11.12","IKEA",256.00);
	@Test
    public void testComment(){
		co.Comment(po.getOrderID(), "�ܲ���");
		assertEquals("�ܲ���",po.getComment());
	}
}
