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
import vo.HotelPromotionVO;
import vo.IdVO;
import vo.StageVO;
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
	
	ViewController viewcontrol = new ViewController();
	
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
		StageVO.setStage(hotelpromotionframe.getPrimaryStage());
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
	private void initialize(){
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(IdVO.getid());
		id.setId(uservo.getid());
		hotelname.setText(uservo.getname());
		
		ArrayList<HotelPromotionVO> promotion = new ArrayList<HotelPromotionVO>();
		promotion.add(new HotelPromotionVO("","生日优惠",true,0,false,"","",0.8));
		promotion.add(new HotelPromotionVO("","三间及以上优惠",false,3,false,"10-01","10-07",0.90));
		ObservableList<HotelPromotionVO> data = FXCollections.observableArrayList(promotion);
		tableview.setItems(data);
		promotiontype.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
		birthday.setCellValueFactory(cellData->cellData.getValue().getisbirthdayProperty());
		roomnum.setCellValueFactory(cellData->cellData.getValue().getNumberofroomProperty());
		begindate.setCellValueFactory(cellData->cellData.getValue().getBegintimeProperty());
		enddate.setCellValueFactory(cellData->cellData.getValue().getEndtimeProperty());
		companyVIP.setCellValueFactory(cellData->cellData.getValue().getisIspartnerProperty());
		discount.setCellValueFactory(cellData->cellData.getValue().getDiscountProperty());
	}

	public void setHotelPromotionFrame(HotelPromotionFrame hotelpromotionframe) {
		this.hotelpromotionframe = hotelpromotionframe;
	}

}
