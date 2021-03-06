package presentation.view;

import java.sql.SQLException;
import java.util.List;

import businessLogic.promotionbl.WebPromotionController;
import businessLogic.userbl.MessageController;
import businessLogicService.promotionBLService.WebPromotionBLService;
import businessLogicService.userBLService.MessageBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
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
	
	FrameController viewcontrol = new FrameController();
	
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
		FrameToFrameVO.setStage(marketerpromotionframe.getPrimaryStage());
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
	private void initialize() throws SQLException{
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
		id.setId(uservo.getid());
		name.setText(uservo.getname());
		
		WebPromotionBLService s = new WebPromotionController();
		List<WebPromotionVO> promotion = s.webPromotionFind();
		
		if(promotion!=null){
			ObservableList<WebPromotionVO> data = FXCollections.observableList(promotion);
			tableview.setItems(data);
			promotiontype.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			begintime.setCellValueFactory(cellData->cellData.getValue().getBegintimeProperty());
			endtime.setCellValueFactory(cellData->cellData.getValue().getEndtimeProperty());
			businessarea.setCellValueFactory(cellData->cellData.getValue().getSpecificbusinessareaProperty());
			VIPgrade.setCellValueFactory(cellData->cellData.getValue().getVIPgradeProperty());
			discount.setCellValueFactory(cellData->cellData.getValue().getDiscountProperty());
		}
	}
	
	public void setMarketerPromotionFrame(MarketerPromotionFrame marketerpromotionframe){
		this.marketerpromotionframe = marketerpromotionframe;
	}
}
