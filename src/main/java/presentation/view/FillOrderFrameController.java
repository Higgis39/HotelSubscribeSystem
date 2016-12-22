package presentation.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import businessLogic.hotelbl.ViewController;
import businessLogic.orderbl.CreateOrderController;
import businessLogic.promotionbl.HotelPromotionController;
import businessLogic.promotionbl.WebPromotionController;
import businessLogicService.hotelBLService.ViewService;
import businessLogicService.orderBLService.CreateOrderService;
import businessLogicService.promotionBLService.HotelPromotionBLService;
import businessLogicService.promotionBLService.WebPromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelPromotionVO;
import vo.IdVO;
import vo.OrderVO;
import vo.StageVO;
import vo.WebPromotionVO;
import vo.WordVO;

/**
 * 
 * @author 费慧通
 *
 *FillOrderFrame的监听
 */
public class FillOrderFrameController {
	@FXML
	private Label hotelname;
	@FXML
	private Label price;
	@FXML
	private ComboBox<String> enterroomtype;
	@FXML
	private ComboBox<String> enterhaschild;
	@FXML
	private DatePicker enterindate;
	@FXML
	private DatePicker enteroutdate;
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField enterpeoplenum;
	@FXML
	private TableView<HotelPromotionVO> tableview1;
	@FXML
	private TableView<WebPromotionVO> tableview2;
	@FXML
	private TableColumn<HotelPromotionVO,String> promotionname1;
	@FXML
	private TableColumn<HotelPromotionVO,Number> discount1;
	@FXML
	private TableColumn<WebPromotionVO,String> promotionname2;
	@FXML
	private TableColumn<WebPromotionVO,Number> discount2;
	
	private FillOrderFrame fillorderframe;
	
	CreateOrderService service = new CreateOrderController();
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 入住日期的监听
	 */
	private void enterindateAction(){
		if(enterindate.getValue().isBefore(LocalDate.now())){
			enterindate.setValue(LocalDate.now());
			enteroutdate.setValue(LocalDate.now().plusDays(1));
		}else{
			enteroutdate.setValue(enterindate.getValue().plusDays(1));
		}
	}
	
	@FXML
	/**
	 * 退房日期的监听
	 */
	private void enteroutdateAction(){
		LocalDate indate = enterindate.getValue();
		if(enteroutdate.getValue().isEqual(indate)&&enteroutdate.getValue().isBefore(indate)){
			enteroutdate.setValue(indate.plusDays(1));
		}else{
		}
	}
	
	@FXML
	/**
	 * 房间数量右侧+号按钮的监听
	 */
	private void roomnumplusAction() throws SQLException{
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		int max = 1000;
		if(roomtype!=null){
			max = service.CheckRoom(hotelname.getText(), roomtype);
		}
		int num = Integer.valueOf(enterroomnum.getText());
		if(num<max){
			num++;
		}
		enterroomnum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 房间数量右侧-号按钮的监听
	 */
	private void roomnumminusAction(){
		int num = Integer.valueOf(enterroomnum.getText());
		if(num>1){
			num--;
		}
		enterroomnum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 入住人数右侧+号按钮的监听
	 */
	private void peoplenumplusAction() throws SQLException{
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		int roomnum = Integer.valueOf(enterroomnum.getText());
		int max = 5;
		if(roomtype!=null&&enterroomnum.getText()!=null){
			max = service.CheckMax(hotelname.getText(), roomtype);
		}
		int num = Integer.valueOf(enterpeoplenum.getText());
		if(num<max*roomnum){
			num++;
		}
		enterpeoplenum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 入住人数右侧-号按钮的监听
	 */
	private void peoplenumminusAction(){
		int num = Integer.valueOf(enterpeoplenum.getText());
		if(num>1){
			num--;
		}
		enterpeoplenum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 下单按钮的监听
	 */
	private void confirmAction() throws SQLException{
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		String indate = enterindate.getValue().toString()+" 18:00";
		String outdate = enteroutdate.getValue().toString();
		int roomnum = Integer.valueOf(enterroomnum.getText());
		String child = enterhaschild.getSelectionModel().getSelectedItem();
		boolean haschild;
		if(child.equals("是")){
			haschild = true;
		}else{
			haschild = false;
		}
		ViewService s = new ViewController();
		String hotelid = s.View(hotelname.getText()).getId();
		OrderVO ordervo = new OrderVO(null,hotelid,IdVO.getid(),"未执行",indate,outdate,0,null,roomtype,roomnum,haschild);
		double p = service.getTotal(ordervo);
		ordervo.setprice(p);
		service.addNewOrder(ordervo);
		fillorderframe.getPrimaryStage().close();
		viewcontrol.openUserMainFrame();
		WordVO.setword("下单成功");
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		fillorderframe.getPrimaryStage().close();
		//返回之前的界面
		StageVO.getSatge2().show();
	}
	
	@FXML
	/**
	 * 得到总价的监听
	 */
	private void getTotalAction() throws SQLException{
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		String indate = enterindate.getValue().toString();
		String outdate = enteroutdate.getValue().toString();
		int roomnum = Integer.valueOf(enterroomnum.getText());
		String child = enterhaschild.getSelectionModel().getSelectedItem();
		boolean haschild;
		if(child.equals("是")){
			haschild = true;
		}else{
			haschild = false;
		}
		
		ViewService s = new ViewController();
		String hotelid = s.View(hotelname.getText()).getId();
		OrderVO ordervo = new OrderVO(null,hotelid,IdVO.getid(),"未执行",indate,outdate,0,null,roomtype,roomnum,haschild);
		double p = service.getTotal(ordervo);
		price.setText(Double.toString(p));
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize() throws SQLException{
		hotelname.setText(HotelNameVO.getHotelname());
		enterroomtype.getItems().addAll("单人间","标准间","家庭套房");
		enterindate.setValue(LocalDate.now());
		enteroutdate.setValue(LocalDate.now().plusDays(1));
		enterhaschild.getItems().addAll("有","没有");
		
		HotelPromotionBLService service1 = new HotelPromotionController();
		WebPromotionBLService service2 = new WebPromotionController();
		List<HotelPromotionVO> list1 = service1.hotelPromotionFind(HotelNameVO.getHotelname());
		List<WebPromotionVO> list2 = service2.webPromotionFind();
		if(list1!=null){
			ObservableList<HotelPromotionVO> data = FXCollections.observableList(list1);
			tableview1.setItems(data);
			promotionname1.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			discount1.setCellValueFactory(cellData->cellData.getValue().getDiscountProperty());
		}
		if(list2!=null){
			ObservableList<WebPromotionVO> data = FXCollections.observableList(list2);
			tableview2.setItems(data);
			promotionname2.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			discount2.setCellValueFactory(cellData->cellData.getValue().getDiscountProperty());
		}
	}

	public void setFillOrderFrame(FillOrderFrame fillorderframe) {
		this.fillorderframe = fillorderframe;
	}
}
