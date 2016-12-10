package presentation.view;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import presentation.controller.ViewController;
import vo.IdVO;
import vo.StageVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *UserPersonalFrame的监听
 */
public class UserPersonalFrameController {
	@FXML
	private Hyperlink registerVIP;
	@FXML
	private Hyperlink change;
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
	private Label VIPtypelabel;
	@FXML
	private Label VIPtype;
	@FXML
	private Label VIPgradelabel;
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
		StageVO.setStage(userpersonalframe.getPrimaryStage());
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
		StageVO.setStage(userpersonalframe.getPrimaryStage());
		viewcontrol.openRegisterVIPFrame();
	}
	
	@FXML
	/**
	 * 修改生日/企业的监听
	 */
	private void changebirthAction(){
		//打开修改生日/企业的界面
		StageVO.setStage(userpersonalframe.getPrimaryStage());
		viewcontrol.openChangeBirOrComFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		userpersonalframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		String getid = IdVO.getid();
		MessageBLService user = new MessageController();
		UserVO uservo = user.GetMessage(getid);
		id.setText(uservo.getid());
		username.setText(uservo.getname());
		name.setText(uservo.getname());
		phonenumber.setText(uservo.getphonenumber());
		creditvalue.setText(Integer.toString(uservo.getcreditvalue()));
		if(uservo.getusertype()==null){
			registerVIP.setVisible(true);
			VIPtypelabel.setVisible(false);
			VIPgradelabel.setVisible(false);
			bircom.setVisible(false);
			change.setVisible(false);
		}else{
			VIPtype.setText(uservo.getVIPtype());
			VIPgrade.setText(Integer.toString(uservo.getVIPgrade()));
			if(uservo.getbirthday()==null){
				bircom.setText("企业");
				birthdaycompany.setText(uservo.getcompany());
			}else{
				birthdaycompany.setText(uservo.getbirthday());
			}
		}
	}

	public void setUserPersonalFrame(UserPersonalFrame userpersonalframe) {
		this.userpersonalframe = userpersonalframe;
	}
	
	
}
