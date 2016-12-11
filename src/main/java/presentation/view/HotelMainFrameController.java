package presentation.view;

import java.util.ArrayList;

import businessLogic.hotelbl.AddRoomController;
import businessLogic.hotelbl.ViewController;
import businessLogicService.hotelBLService.AddRoomService;
import businessLogicService.hotelBLService.ViewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelVO;
import vo.IdVO;
import vo.RoomVO;
import vo.StageVO;

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
	private TableColumn<RoomVO,Number> peoplenum;
	@FXML
	private TableColumn<RoomVO,Number> roomnum;
	@FXML
	private TableColumn<RoomVO,Number> roomprice;
	
	private HotelMainFrame hotelmainframe;
	
	FrameController viewcontrol = new FrameController();
	
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
		StageVO.setStage(hotelmainframe.getPrimaryStage());
		HotelNameVO.sethotelname(hotelname.getText());
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
		ViewService s = new ViewController();
		HotelVO hotelvo = s.ViewByid(IdVO.getid());
		id.setText(hotelvo.getId());
		hotelname.setText(hotelvo.getName());
		
		AddRoomService service = new AddRoomController();
		ArrayList<RoomVO> roomlist = service.getRoom(hotelname.getText());
		ObservableList<RoomVO> roomdata = FXCollections.observableArrayList(roomlist);
		tableview.setItems(roomdata);
		roomtype.setCellValueFactory(cellData->cellData.getValue().roomtypeProperty());
		peoplenum.setCellValueFactory(cellData->cellData.getValue().peoplenumProperty());
		roomnum.setCellValueFactory(cellData->cellData.getValue().roomnumProperty());
		roomprice.setCellValueFactory(cellData->cellData.getValue().roompriceProperty());
	}

	public void setHotelMainFrame(HotelMainFrame hotelmainframe) {
		this.hotelmainframe = hotelmainframe;
	}
}
