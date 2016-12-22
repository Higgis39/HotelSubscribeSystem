package presentation.view;

import java.sql.SQLException;
import java.util.List;

import businessLogic.orderbl.HotelViewOrderController;
import businessLogicService.orderBLService.HotelViewOrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.OrderVO;


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
	@FXML
	private TableView<OrderVO> tableview;
	@FXML
	private TableColumn<OrderVO,String> orderid;
	@FXML
	private TableColumn<OrderVO,String> userid;
	@FXML
	private TableColumn<OrderVO,String> intime;
	@FXML
	private TableColumn<OrderVO,String> outtime;
	@FXML
	private TableColumn<OrderVO,Number> price;

	private DealOrderFrame dealorderframe;
	
	FrameController viewcontrol = new FrameController();
	
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
	private void viewAction() throws SQLException{
		String ordertype = enterordertype.getSelectionModel().getSelectedItem();
		HotelViewOrderService service = new HotelViewOrderController();
		List<OrderVO> list = service.GetSpecificOrders(FrameToFrameVO.getid(), ordertype);
		if(list != null){
			ObservableList<OrderVO> data = FXCollections.observableList(list);
			tableview.setItems(data);
			orderid.setCellValueFactory(cellData->cellData.getValue().getorderIdProperty());
			userid.setCellValueFactory(cellData->cellData.getValue().getUserIdProperty());
			intime.setCellValueFactory(cellData->cellData.getValue().getEntryTimeProperty());
			outtime.setCellValueFactory(cellData->cellData.getValue().getLastTimeProperty());
			price.setCellValueFactory(cellData->cellData.getValue().getPriceProperty());
		}
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
		enterordertype.getItems().addAll("未执行","已执行","异常","已撤销");
	}
	
	public void setDealOrderFrame(DealOrderFrame dealorderframe){
		this.dealorderframe = dealorderframe;
	}
}
