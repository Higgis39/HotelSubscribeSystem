package presentation.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.ViewController;
import vo.RoomVO;

/**
 * 
 * @author 费慧通
 *
 *HotelMainFrame的监听
 */
public class HotelMainFrameController {
	@FXML
	private Label id;
	@FXML
	private Label hotelname;
	@FXML
	private TableView<RoomVO> tableview;
	@FXML
	private TableColumn<RoomVO,String> roomtype;
	@FXML
	private TableColumn<RoomVO,Number> roomnum;
	@FXML
	private TableColumn<RoomVO,Number> roomprice;
	
	private HotelMainFrame hotelmainframe;
	
	private ObservableList<RoomVO> roomdata = FXCollections.observableArrayList();
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 处理订单的监听
	 */
	private void dealorderAction(){
		//打开处理订单界面
		viewcontrol.openDealOrderFrame();
		hotelmainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 促销策略的监听
	 */
	private void promotionAction(){
		//打开促销策略界面
		viewcontrol.openHotelPromotionFrame();
		hotelmainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 酒店信息的监听
	 */
	private void hotelmessageAction(){
		//打开酒店信息界面
		viewcontrol.openHotelMessageFrame();
		hotelmainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 录入可用客房的监听
	 */
	private void enteruserfulroomAction(){
		//打开录入可用客房的界面
		viewcontrol.openEnterUserfulRoomFrame();
	}
	
	@FXML
	/**
	 * 更新入住信息的监听
	 */
	private void checkinAction(){
		//打开更新入住信息的界面
		viewcontrol.openCheckInFrame();
	}
	
	@FXML
	/**
	 * 更新退房信息的监听
	 */
	private void checkoutAction(){
		//打开更新退房信息的界面
		viewcontrol.openCheckOutFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		hotelmainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
//		roomdata.add(new RoomVO("单人间",10,100));
//		roomdata.add(new RoomVO("双人间",10,180));
//		roomdata.add(new RoomVO("三人间",10,250));
		tableview.setItems(roomdata);
		roomtype.setCellValueFactory(cellData->cellData.getValue().roomtypeProperty());
		roomnum.setCellValueFactory(cellData->cellData.getValue().roomnumProperty());
		roomprice.setCellValueFactory(cellData->cellData.getValue().roompriceProperty());
	}

	public void setHotelMainFrame(HotelMainFrame hotelmainframe) {
		this.hotelmainframe = hotelmainframe;
	}
}
