package presentation.view;

import businessLogic.userbl.LoginController;
import businessLogicService.userBLService.LoginBLService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.controller.ViewController;
import vo.IdVO;

/**
 * 
 * @author 费慧通
 *
 *LoginFrame的控制器
 */
public class LoginFrameController {
	@FXML
	private ComboBox<String> enterusertype;
	@FXML
	private TextField enterid;
	@FXML
	private PasswordField enterpassword;
	@FXML
	private Label usertypeword;
	@FXML
	private Label idword;
	@FXML
	private Label passwordword;
	
	private LoginFrame loginframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 用户点击登录按钮，做出处理
	 */
	private void confirmAction(){
		String usertype = enterusertype.getSelectionModel().getSelectedItem();
		String id = enterid.getText();
		String password = enterpassword.getText();
		
		//对不输入数据直接点击登录的情况做出处理
		if(usertype==null){
			usertypeword.setText("请选择用户类型");
		}
		if(id.equals("")){
			idword.setText("请输入账号");
		}
		if(password.equals("")){
			passwordword.setText("请输入密码");
		}
		//输入数据后，删除提示
		if(usertype!=null){
			usertypeword.setText(null);
		}
		if(!id.equals("")){
			idword.setText(null);
		}
		if(!password.equals("")){
			passwordword.setText(null);
		}
		LoginBLService login = new LoginController();
		boolean result = login.Login(id, password, usertype);
		if(result==false){
			//打开“登录失败”弹框
			viewcontrol.openFailLoginPopup();
		}else{
			//打开相应的用户类型的主界面
			IdVO.setid(enterid.getText());
			if(usertype.equals("普通客户")){
				viewcontrol.openUserMainFrame();
			}else if(usertype.equals("酒店工作人员")){
				viewcontrol.openHotelMainFrame();
			}else if(usertype.equals("网站营销人员")){
				viewcontrol.openMarketerMainFrame();
			}else{
				viewcontrol.openManagerMainFrame();
			}
		}
	}
	
	@FXML
	/**
	 * 用户点击链接时，启动账号注册界面
	 */
	private void linkAction(){
		viewcontrol.openRegisterClientFrame();
		loginframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * LoginFrame初始化
	 */
	private void initialize(){
		//在下拉框中添加选项
		enterusertype.getItems().addAll("普通客户","酒店工作人员","网站营销人员","网站管理人员");
	}
	
	public void setLoginFrame(LoginFrame loginframe) {
		this.loginframe = loginframe;
	}
}
