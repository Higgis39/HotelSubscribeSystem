package presentation.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import businessLogic.orderbl.WebsiteViewOrderController;
import businessLogic.userbl.ManageUserController;
import businessLogic.userbl.MessageController;
import businessLogicService.orderBLService.WebsiteViewOrderService;
import businessLogicService.userBLService.MessageBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.FrameController;
import vo.IdVO;
import vo.OrderVO;
import vo.UserVO;


/**
 * 
 * @author 费慧通
 *
 *MarketerMainFrame的监听
 */
public class MarketerMainFrameController {
	@FXML
	private Label id;
	@FXML
	private Label name;
	@FXML
	private TableView<OrderVO> tableview;
	@FXML
	private TableColumn<OrderVO,String> orderid;
	@FXML
	private TableColumn<OrderVO,String> hotelname;
	@FXML
	private TableColumn<OrderVO,String> userid;
	@FXML
	private TableColumn<OrderVO,String> time;

	private MarketerMainFrame marketermainframe;
	
	FrameController viewcontrol = new FrameController();
	
	ManageUserController manageruser = new ManageUserController();
	
	@FXML
	/**
	 * 促销策略的监听
	 */
	private void promotionAction(){
		//打开网站营销人员促销策略界面
		viewcontrol.openMarketerPromotionFrame();
		marketermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 处理订单申诉的监听
	 */
	private void orderappealAction(){
		//打开处理订单申诉界面
		viewcontrol.openOrderAppealFrame();
	}
	
	@FXML
	/**
	 * 充值信用的监听
	 */
	private void rechargecreditAction(){
		//打开充值信用界面
		viewcontrol.openRechargeCreditFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		marketermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize() throws SQLException{
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(IdVO.getid());
		id.setId(uservo.getid());
		name.setText(uservo.getname());
		
		WebsiteViewOrderService s = new WebsiteViewOrderController();
		List<OrderVO> list = s.ViewException(LocalDate.now().toString());
		ObservableList<OrderVO> data = FXCollections.observableList(list);
		tableview.setItems(data);
		orderid.setCellValueFactory(cellData->cellData.getValue().getorderIdProperty());
		hotelname.setCellValueFactory(cellData->cellData.getValue().getHotelIdProperty());
		userid.setCellValueFactory(cellData->cellData.getValue().getUserIdProperty());
		time.setCellValueFactory(cellData->cellData.getValue().getEntryTimeProperty());
	}
	
	public void setMarketerMainFrame(MarketerMainFrame marketermainframe){
		this.marketermainframe = marketermainframe;
	}
}
