package presentation.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import businessLogic.hotelbl.SearchController;
import businessLogic.userbl.MessageController;
import businessLogicService.hotelBLService.SearchService;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.ArrayListVO;
import vo.HotelVO;
import vo.IdVO;
import vo.StageVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *UserMainFrame的监听
 */
public class UserMainFrameController {
	@FXML
	private Label username;
	@FXML
	private Label id;
	@FXML
	private TextField entercity;
	@FXML
	private TextField enterbusinesscircle;
	@FXML
	private TextField enterhotelname;
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField enterstar;
	@FXML
	private ComboBox<String> enterroomtype;
	@FXML
	private ComboBox<String> enterprice;
	@FXML
	private ComboBox<String> entergrade;
	@FXML
	private DatePicker enterindate;
	@FXML
	private DatePicker enteroutdate;
	@FXML
	private CheckBox checkbox;
	@FXML
	private Label indateword;
	@FXML
	private Label outdateword;
	
	private UserMainFrame usermainframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * “历史订单”的监听
	 */
	private void orderAction(){
		//打开历史订单界面
		viewcontrol.openHistoricalOrderFrame();
		usermainframe.getPrimaryStage().close();
	}
	
	@FXML
	private void personalAction(){
		//打开个人信息界面
		viewcontrol.openUserPersonalFrame();
		usermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * “房间数量”右侧+号的监听
	 */
	private void numplusAction(){
		if(enterroomnum.getText().equals("")){
			enterroomnum.setText("1");
		}else{
			int num = Integer.valueOf(enterroomnum.getText());
			num++;
			enterroomnum.setText(Integer.toString(num));
		}
	}
	
	@FXML
	/**
	 * “房间数量”右侧-号的监听
	 */
	private void numminusAction(){
		if(enterroomnum.getText().equals("")){
			enterroomnum.setText("1");
		}else{
			int num = Integer.valueOf(enterroomnum.getText());
			if(num>1){
				num--;
			}
			enterroomnum.setText(Integer.toString(num));
		}
	}
	
	@FXML
	/**
	 * “星级”右侧的+号的监听
	 */
	private void starplusAction(){
		if(enterstar.getText().equals("")){
			enterstar.setText("1");
		}else{
			int star = Integer.valueOf(enterstar.getText());
			if(star<5){
				star++;
			}
			enterstar.setText(Integer.toString(star));
		}
	}
	
	@FXML
	/**
	 * “星级”右侧的-号的监听
	 */
	private void starminusAction(){
		if(enterstar.getText().equals("")){
			enterstar.setText("1");
		}else{
			int star = Integer.valueOf(enterstar.getText());
			if(star>1){
				star--;
			}
			enterstar.setText(Integer.toString(star));
		}
	}
	
	@FXML
	/**
	 * enterindate的监听
	 */
	private void indateAction(){
		LocalDate now = LocalDate.now();
		if(enterindate.getValue().isBefore(now)){
			enterindate.setValue(now);
			indateword.setText("入住日期不能小于当前日期");
		}else{
			indateword.setText(null);
		}
		if(enterindate.getValue()!=null){
			enteroutdate.setValue(enterindate.getValue().plusDays(1));
		}
	}
	
	@FXML
	private void outdateAction(){
		if(enteroutdate.getValue().isEqual(enterindate.getValue())||enteroutdate.getValue().isBefore(enterindate.getValue())){
			enteroutdate.setValue(enterindate.getValue().plusDays(1));
			outdateword.setText("退房日期必须晚于入住日期");
		}else{
			outdateword.setText(null);
		}
	}
	
	@FXML
	/**
	 * 搜索按钮的监听
	 */
	private void searchAction() throws SQLException{
		String city = entercity.getText();
		String businesscircle = enterbusinesscircle.getText();
		String hotelname = enterhotelname.getText();
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		String price = enterprice.getSelectionModel().getSelectedItem();
		int roomnum = 0;
		if(!enterroomnum.getText().equals("")){
			roomnum = Integer.valueOf(enterroomnum.getText());
		}
		String indate = null,outdate = null;
		if(enterindate.getValue()!=null){
			indate = enterindate.getValue().toString();
		}
		if(enteroutdate.getValue()!=null){
			outdate = enteroutdate.getValue().toString();
		}
		int star = 0;
		if(!enterstar.getText().equals("")){
			star = Integer.valueOf(enterstar.getText());
		}
		String grade = entergrade.getSelectionModel().getSelectedItem();
		Boolean only = checkbox.isSelected();
		//调用hotel模块的搜索酒店方法
		SearchService s = new SearchController();
		ArrayList<HotelVO> list = s.Search(city, businesscircle, roomtype,price, indate, outdate, star, grade, only);
		ArrayListVO.setArrayList(list);
		System.out.println(ArrayListVO.getArrayList());
		
		StageVO.setStage(usermainframe.getPrimaryStage());
		usermainframe.getPrimaryStage().hide();
		viewcontrol.openSearchResultFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		usermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
//		MessageBLService service = new MessageController();
//		UserVO uservo = service.GetMessage(IdVO.getid());
//		id.setText(uservo.getid());
//		username.setText(uservo.getname());
		
		enterroomtype.getItems().addAll("单人间","标准间","家庭套房");
		enterprice.getItems().addAll("150以下","150~300","300~500","500~700","700~1000","1000以上");
		entergrade.getItems().addAll("1分以下","1~2分","2~3分","3~4分","4~5分");
	}

	public void setUserMainFrame(UserMainFrame usermainframe) {
		this.usermainframe = usermainframe;
	}

}
