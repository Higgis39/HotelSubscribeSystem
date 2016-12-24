package presentation.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.hotelbl.AddRoomController;
import businessLogic.hotelbl.ViewController;
import businessLogic.orderbl.CustomerViewOrderController;
import businessLogicService.hotelBLService.AddRoomService;
import businessLogicService.hotelBLService.ViewService;
import businessLogicService.orderBLService.CustomerViewOrderService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
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
		AddRoomService service1 = new AddRoomController();
		ArrayList<RoomVO> roomlist = service1.getRoom(FrameToFrameVO.getHotelname());
		if(roomlist != null){
			ObservableList<RoomVO> roomdata = FXCollections.observableArrayList(roomlist);
			tableview.setItems(roomdata);
			roomtype.setCellValueFactory(cellData->cellData.getValue().roomtypeProperty());
			peoplenum.setCellValueFactory(cellData->cellData.getValue().peoplenumProperty());
			price.setCellValueFactory(cellData->cellData.getValue().roompriceProperty());
		}
		
		ViewService service2 = new ViewController();
		String hotelid = service2.View(FrameToFrameVO.getHotelname()).getId();
		CustomerViewOrderService service3 = new CustomerViewOrderController();
		List<OrderVO> list = service3.getOrderByUserAndHotel(hotelid,FrameToFrameVO.getid());
		if(list!=null){
			ObservableList<OrderVO> data = FXCollections.observableArrayList(list);
			order.setItems(data);
			orderid.setCellValueFactory(cellData->cellData.getValue().getorderIdProperty());
			status.setCellValueFactory(cellData->cellData.getValue().getStatusProperty());
			begindate.setCellValueFactory(cellData->cellData.getValue().getEntryTimeProperty());
			enddate.setCellValueFactory(cellData->cellData.getValue().getLastTimeProperty());
			orderprice.setCellValueFactory(cellData->cellData.getValue().getPriceProperty());
			
			again.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
	                return new SimpleBooleanProperty(p.getValue()!=null);
	            }
	        });

	        again.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
	            @Override
	            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
	                return new ButtonCell4();
	            }
	        });
		}
	}
	
	public void setUserViewRoomFrame(UserViewRoomFrame userviewroomframe){
		this.userviewroomframe = userviewroomframe;
	}
}
