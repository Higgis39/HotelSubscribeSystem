package presentation.view;

import java.util.ArrayList;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.ViewController;
import vo.IdVO;
import vo.UserVO;
import vo.WebPromotionVO;

/**
 * 
 * @author 费慧通
 *
 *MarketerPromotionFrame的监听
 */
public class MarketerPromotionFrameController {
	@FXML
	private Label id;
	@FXML
	private Label name;
	@FXML
	private TableView<WebPromotionVO> tableview;
	@FXML
	private TableColumn<WebPromotionVO,String> promotiontype;
	@FXML
	private TableColumn<WebPromotionVO,String> begintime;
	@FXML
	private TableColumn<WebPromotionVO,String> endtime;
	@FXML
	private TableColumn<WebPromotionVO,String> businessarea;
	@FXML
	private TableColumn<WebPromotionVO,Number> VIPgrade;
	@FXML
	private TableColumn<WebPromotionVO,Number> discount;
	
	private MarketerPromotionFrame marketerpromotionframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 订单浏览的监听
	 */
	private void orderviewAction(){
		//打开营销人员主界面
		viewcontrol.openMarketerMainFrame();
		marketerpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 去制定营销策略的监听
	 */
	private void linkAction(){
		//打开制定营销策略的监听
		viewcontrol.openMakeMarketerPromotionFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		marketerpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
//		MessageBLService service = new MessageController();
//		UserVO uservo = service.GetMessage(IdVO.getid());
//		id.setId(uservo.getid());
//		name.setText(uservo.getname());
		
		ArrayList<WebPromotionVO> promotion = new ArrayList<WebPromotionVO>();
		promotion.add(new WebPromotionVO("VIP特定商圈专属折扣","12-01","12-09","栖霞",3,0.8));
		promotion.add(new WebPromotionVO("会员特定等级专属折扣","","","无限制",1,0.9));
		ObservableList<WebPromotionVO> data = FXCollections.observableArrayList(promotion);
		tableview.setItems(data);
		promotiontype.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
		begintime.setCellValueFactory(cellData->cellData.getValue().getBegintimeProperty());
		endtime.setCellValueFactory(cellData->cellData.getValue().getEndtimeProperty());
		businessarea.setCellValueFactory(cellData->cellData.getValue().getSpecificbusinessareaProperty());
		VIPgrade.setCellValueFactory(cellData->cellData.getValue().getVIPgradeProperty());
		discount.setCellValueFactory(cellData->cellData.getValue().getDiscountProperty());
	}
	
	public void setMarketerPromotionFrame(MarketerPromotionFrame marketerpromotionframe){
		this.marketerpromotionframe = marketerpromotionframe;
	}
}
