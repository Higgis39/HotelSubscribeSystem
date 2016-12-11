package presentation.view;

import businessLogic.orderbl.CustomerViewOrderController;
import businessLogic.orderbl.WebsiteViewOrderController;
import businessLogicService.orderBLService.CustomerViewOrderService;
import businessLogicService.orderBLService.WebsiteViewOrderService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vo.OrderVO;

/**
 * 
 * @author 费慧通
 *
 *OrderAppealFrame的监听
 */
public class OrderAppealFrameController {
	@FXML
	private TextField orderid;
	@FXML
	private ComboBox<String> reveal;
	
	private OrderAppealFrame orderappealframe;
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		WebsiteViewOrderService service = new WebsiteViewOrderController();
		CustomerViewOrderService s = new CustomerViewOrderController();
		String id = orderid.getText();
		OrderVO vo = s.ShowOrderMessage(id);
		String p = reveal.getSelectionModel().getSelectedItem();
		service.RecoverCredit(vo);
		
		orderappealframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		orderappealframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		reveal.getItems().addAll("全部","一半");
	}

	public void setOrderAppealFrame(OrderAppealFrame orderappealframe) {
		this.orderappealframe = orderappealframe;
	}

}
