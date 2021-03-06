package presentation.view;

import java.sql.SQLException;
import java.util.List;

import businessLogic.promotionbl.HotelPromotionController;
import businessLogic.userbl.MessageController;
import businessLogicService.promotionBLService.HotelPromotionBLService;
import businessLogicService.userBLService.MessageBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.HotelPromotionVO;
import vo.UserVO;

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
	private TableColumn<HotelPromotionVO,String> begindate;
	@FXML
	private TableColumn<HotelPromotionVO,String> enddate;
	@FXML
	private TableColumn<HotelPromotionVO,String> companyVIP;
	@FXML
	private TableColumn<HotelPromotionVO,Number> discount;
	
	private HotelPromotionFrame hotelpromotionframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 管理房间的监听
	 */
	private void roomAction(){
		//打开酒店主界面
		viewcontrol.openHotelMainFrame();
		hotelpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 处理订单的监听
	 */
	private void dealorderAction(){
		//打开处理订单界面
		viewcontrol.openDealOrderFrame();
		hotelpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 酒店信息的监听
	 */
	private void hotelmessageAction(){
		//打开酒店信息界面
		viewcontrol.openHotelMessageFrame();
		hotelpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 制定促销策略的监听
	 */
	private void linkAction(){
		//打开制定促销策略界面
		FrameToFrameVO.setStage(hotelpromotionframe.getPrimaryStage());
		FrameToFrameVO.sethotelname(hotelname.getText());
		viewcontrol.openMakeHotelPromotionFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		hotelpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize() throws SQLException{
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
		id.setText(uservo.getid());
		hotelname.setText(uservo.getname());
		
		HotelPromotionBLService s = new HotelPromotionController();
		List<HotelPromotionVO> promotion = s.hotelPromotionFind(hotelname.getText());
		
		if(promotion != null){
			ObservableList<HotelPromotionVO> data = FXCollections.observableList(promotion);
			tableview.setItems(data);
			promotiontype.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			birthday.setCellValueFactory(cellData->cellData.getValue().getisbirthdayProperty());
			roomnum.setCellValueFactory(cellData->cellData.getValue().getNumberofroomProperty());
			begindate.setCellValueFactory(cellData->cellData.getValue().getBegintimeProperty());
			enddate.setCellValueFactory(cellData->cellData.getValue().getEndtimeProperty());
			companyVIP.setCellValueFactory(cellData->cellData.getValue().getisIspartnerProperty());
			discount.setCellValueFactory(cellData->cellData.getValue().getDiscountProperty());
		}
	}

	public void setHotelPromotionFrame(HotelPromotionFrame hotelpromotionframe) {
		this.hotelpromotionframe = hotelpromotionframe;
	}

}
