package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import presentation.controller.ViewController;

/**
 * 
 * @author 费慧通
 *
 *UserPersonalFrame的监听
 */
public class UserPersonalFrameController {
	@FXML
	private Button searchhotel;
	@FXML
	private Button order;
	@FXML
	private Hyperlink changepersonalmessage;
	@FXML
	private Hyperlink viewcreditchange;
	@FXML
	private Hyperlink changebirth;
	@FXML
	private Hyperlink registerVIP;
	@FXML
	private Label username;
	@FXML
	private Label id;
	@FXML
	private Label name;
	@FXML
	private Label phonenumber;
	@FXML
	private Label creditvalue;
	@FXML
	private Label VIPtype;
	@FXML
	private Label VIPgrade;
	@FXML
	private Label bircom;
	@FXML
	private Label birthdaycompany;
	
	private UserPersonalFrame userpersonalframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * “酒店查询”的监听
	 */
	private void searchhotelAction(){
		//打开用户主界面（普通客户）
		viewcontrol.openUserMainFrame();
		userpersonalframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * “历史订单”的监听
	 */
	private void orderAction(){
		//打开历史订单界面
		viewcontrol.openHistoricalOrderFrame();
		userpersonalframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 修改个人信息的监听
	 */
	private void changepersonalmessageAction(){
		//打开修改个人信息页面
		viewcontrol.openChangePersonalMessageFrame();
	}
	
	@FXML
	/**
	 * 查看信用变化的监听
	 */
	private void viewcreditchangeAction(){
		//打开信用值变化页面
		viewcontrol.openViewCreditChange();
	}
	
	@FXML
	/**
	 * 注册会员的监听
	 */
	private void registerVIPAction(){
		//打开注册会员页面
		viewcontrol.openRegisterVIPFrame();
	}
	
	@FXML
	/**
	 * 修改生日/企业的监听
	 */
	private void changebirthAction(){
		//打开修改生日/企业的界面
		viewcontrol.openChangeBirOrComFrame();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setUserPersonalFrame(UserPersonalFrame userpersonalframe) {
		this.userpersonalframe = userpersonalframe;
	}
	
	
}
