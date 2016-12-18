package presentation.view;

import java.sql.SQLException;
import java.time.LocalDate;

import businessLogic.orderbl.CreateOrderController;
import businessLogicService.orderBLService.CreateOrderService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.IdVO;
import vo.OrderVO;
import vo.StageVO;

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
	private Label indateword;
	@FXML
	private Label outdateword;
	@FXML
	private Label roomtypeword;
	@FXML
	private Label haschildword;
	
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
			indateword.setText("入住日期不能晚于当前日期");
		}else{
			enteroutdate.setValue(enterindate.getValue().plusDays(1));
			indateword.setText(null);
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
			outdateword.setText("退房日期不能晚于入住日期");
		}else{
			outdateword.setText(null);
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
//		int peoplenum = Integer.valueOf(enterpeoplenum.getText());
		String haschild = enterhaschild.getSelectionModel().getSelectedItem();
		if(roomtype==null){
			roomtypeword.setText("您必须选择房间类型");
		}else{
			roomtypeword.setText(null);
		}
		if(haschild==null){
			haschildword.setText("您必须填写有无儿童");
		}else{
			haschildword.setText(null);
		}
		
		OrderVO ordervo = new OrderVO(null,hotelname.getText(),IdVO.getid(),"未执行",indate,outdate,0,null,roomtype,roomnum);
		double p = service.getTotal(ordervo);
		ordervo.setprice(p);
		service.addNewOrder(ordervo);
		fillorderframe.getPrimaryStage().close();
		viewcontrol.openSuccessOrderFrame();
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
		OrderVO ordervo = new OrderVO(null,hotelname.getText(),IdVO.getid(),"未执行",indate,outdate,0,null,roomtype,roomnum);
		double p = service.getTotal(ordervo);
		price.setText(Double.toString(p));
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		hotelname.setText(HotelNameVO.getHotelname());
		enterroomtype.getItems().addAll("单人间","标准间","家庭套房");
		enterindate.setValue(LocalDate.now());
		enteroutdate.setValue(LocalDate.now().plusDays(1));
		enterhaschild.getItems().addAll("有","没有");
	}

	public void setFillOrderFrame(FillOrderFrame fillorderframe) {
		this.fillorderframe = fillorderframe;
	}
}
