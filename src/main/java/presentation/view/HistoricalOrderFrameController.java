package presentation.view;

import java.sql.SQLException;
import java.util.List;

import businessLogic.orderbl.CustomerViewOrderController;
import businessLogic.userbl.MessageController;
import businessLogicService.orderBLService.CustomerViewOrderService;
import businessLogicService.userBLService.MessageBLService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.OrderVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *HistoricalOrderFrame的监听
 */
public class HistoricalOrderFrameController {
	@FXML
	private Label username;
	@FXML
	private Label id;
	@FXML
	private ComboBox<String> enterordertype;
	@FXML
	private TableView<OrderVO> tableview;
	@FXML
	private TableColumn<OrderVO,String> orderid;
	@FXML
	private TableColumn<OrderVO,String> hotelname;
	@FXML
	private TableColumn<OrderVO,String> intime;
	@FXML
	private TableColumn<OrderVO,String> outtime;
	@FXML
	private TableColumn<OrderVO,Number> price;
	@FXML
	private TableColumn<OrderVO,Boolean> again;
	@FXML
	private TableColumn<OrderVO,Boolean> link;
	
	private HistoricalOrderFrame historicalorderframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * “酒店查询”的监听
	 */
	private void searchhotelAction(){
		//打开用户主界面（普通客户）
		viewcontrol.openUserMainFrame();
		historicalorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * “个人中心”的监听
	 */
	private void personalAction(){
		//打开个人信息界面
		viewcontrol.openUserPersonalFrame();
		historicalorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 查看的监听
	 * @throws SQLException
	 */
	private void viewAction() throws SQLException{
		FrameToFrameVO.setStage2(historicalorderframe.getPrimaryStage());
		
		String ordertype = enterordertype.getSelectionModel().getSelectedItem();
		//根据得到的订单类型进行搜索
		
		CustomerViewOrderService service = new CustomerViewOrderController();
		
		List<OrderVO> list = service.getSpecificOrders(id.getText(),ordertype);
		
		if(list!=null){
			ObservableList<OrderVO> data = FXCollections.observableList(list);
			tableview.setItems(data);
			orderid.setCellValueFactory(cellData->cellData.getValue().getorderIdProperty());
			hotelname.setCellValueFactory(cellData->cellData.getValue().getHotelIdProperty());
			intime.setCellValueFactory(cellData->cellData.getValue().getEntryTimeProperty());
			outtime.setCellValueFactory(cellData->cellData.getValue().getLastTimeProperty());
			price.setCellValueFactory(cellData->cellData.getValue().getPriceProperty());
			
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
			
			if(ordertype.equals("已执行")){
				link.setVisible(true);
				tableview.setPrefWidth(625);
				intime.setText("入住时间");
				outtime.setText("离开时间");
				link.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
		            @Override
		            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
		                return new SimpleBooleanProperty(p.getValue()!=null);
		            }
		        });

		        link.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
		            @Override
		            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
		                return new ButtonCell2();
		            }
		        });
			}else if(ordertype.equals("未执行")){
				intime.setText("预计入住时间");
				outtime.setText("预计退房时间");
				link.setText("撤销");
				link.setVisible(true);
				tableview.setPrefWidth(625);
				
				link.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
		            @Override
		            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
		                return new SimpleBooleanProperty(p.getValue()!=null);
		            }
		        });

		        link.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
		            @Override
		            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
		                return new ButtonCell3();
		            }
		        });
			}else{
				link.setVisible(false);
				tableview.setPrefWidth(550);
				intime.setText("入住时间");
				outtime.setText("离开时间");
			}
		}
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		historicalorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterordertype.getItems().addAll("未执行","已执行","异常","已撤销");
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
		id.setText(uservo.getid());
		username.setText(uservo.getname());
	}
	
	public void setHistoricalOrderFrame(HistoricalOrderFrame historicalorderframe){
		this.historicalorderframe = historicalorderframe;
	}
}
