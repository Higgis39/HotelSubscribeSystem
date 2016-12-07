package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import presentation.controller.ViewController;


/**
 * 
 * @author 费慧通
 *
 *DealOrderFrame的监听
 */
public class DealOrderFrameController {
	@FXML
	private ComboBox<String> enterordertype;
	@FXML
	private Label id;
	@FXML
	private Label hotelname;

	private DealOrderFrame dealorderframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 管理房间的监听
	 */
	private void roomAction(){
		//打开酒店主界面
		viewcontrol.openHotelMainFrame();
		dealorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 促销策略的监听
	 */
	private void promotionAction(){
		//打开酒店促销策略界面
		viewcontrol.openHotelPromotionFrame();
		dealorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 酒店信息的监听
	 */
	private void hotelmessageAction(){
		//打开酒店信息界面
		viewcontrol.openHotelMessageFrame();
		dealorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 查看按钮的监听
	 */
	private void viewAction(){
		String ordertype = enterordertype.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		dealorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterordertype.getItems().addAll("未执行的房间预订的订单","已执行的订单","异常订单","已撤销订单");
	}
	
	public void setDealOrderFrame(DealOrderFrame dealorderframe){
		this.dealorderframe = dealorderframe;
	}
}
