package presentation.view;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogic.hotelbl.AddRoomController;
import businessLogicService.hotelBLService.AddRoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.FrameToFrameVO;
import vo.OrderVO;
import vo.RoomVO;

public class UserViewRoomFrameController {
	@FXML
	private TableView<RoomVO> tableview;
	@FXML
	private TableView<OrderVO> order;
	@FXML
	private TableColumn<RoomVO,String> roomtype;
	@FXML
	private TableColumn<RoomVO,Number> peoplenum;
	@FXML
	private TableColumn<RoomVO,Number> price;
	@FXML
	private TableColumn<OrderVO,String> orderid;
	@FXML
	private TableColumn<OrderVO,String> status;
	@FXML
	private TableColumn<OrderVO,String> begindate;
	@FXML
	private TableColumn<OrderVO,String> enddate;
	@FXML
	private TableColumn<OrderVO,Number> orderprice;
	@FXML
	private TableColumn<OrderVO,Boolean> again;
	
	private UserViewRoomFrame userviewroomframe;
	
	@FXML
	/**
	 * ”返回“按钮的监听
	 */
	private void returnAction(){
		userviewroomframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize() throws SQLException{
		AddRoomService service = new AddRoomController();
		ArrayList<RoomVO> roomlist = service.getRoom(FrameToFrameVO.getHotelname());
		if(roomlist != null){
			ObservableList<RoomVO> roomdata = FXCollections.observableArrayList(roomlist);
			tableview.setItems(roomdata);
			roomtype.setCellValueFactory(cellData->cellData.getValue().roomtypeProperty());
			peoplenum.setCellValueFactory(cellData->cellData.getValue().peoplenumProperty());
			price.setCellValueFactory(cellData->cellData.getValue().roompriceProperty());
		}
	}
	
	public void setUserViewRoomFrame(UserViewRoomFrame userviewroomframe){
		this.userviewroomframe = userviewroomframe;
	}
}
