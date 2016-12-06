package presentation.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.ViewController;
import vo.HotelPromotionVO;

/**
 * 
 * @author 费慧通
 *
 *HotelPromotionFrame的监听
 */
public class HotelPromotionFrameController {
	@FXML
	private Label id;
	@FXML
	private Label hotelname;
	@FXML
	private TableView<HotelPromotionVO> tableview;
	@FXML
	private TableColumn<HotelPromotionVO,String> promotiontype;
	@FXML
	private TableColumn<HotelPromotionVO,String> birthday;
	@FXML
	private TableColumn<HotelPromotionVO,Number> roomnum;
	@FXML
	private TableColumn<HotelPromotionVO,LocalDate> date;
	@FXML
	private TableColumn<HotelPromotionVO,String> companyVIP;
	@FXML
	private TableColumn<HotelPromotionVO,Number> discount;
	
	private HotelPromotionFrame hotelpromptionframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 管理房间的监听
	 */
	private void roomAction(){
		//打开酒店主界面
		viewcontrol.openHotelMainFrame();
		hotelpromptionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 处理订单的监听
	 */
	private void dealorderAction(){
		//打开处理订单界面
		viewcontrol.openDealOrderFrame();
		hotelpromptionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 酒店信息的监听
	 */
	private void hotelmessageAction(){
		//打开酒店信息界面
		viewcontrol.openHotelMessageFrame();
		hotelpromptionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 制定促销策略的监听
	 */
	private void linkAction(){
		//打开制定促销策略界面
		viewcontrol.openMakeHotelPromotionFrame();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setHotelPromotionFrame(HotelPromotionFrame hotelpromptionframe) {
		this.hotelpromptionframe = hotelpromptionframe;
	}

}
