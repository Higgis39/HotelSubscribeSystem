package presentation.view;

import businessLogic.userbl.RegisterClientController;
import businessLogicService.UserRegisterClientBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.controller.ViewController;

/**
 * 
 * @author 费慧通
 *
 *RegisterClientFrame的控制器
 */
public class RegisterClientFrameController {
	@FXML
	private TextField enterusername;
	@FXML
	private PasswordField enterpassword1;
	@FXML
	private PasswordField enterpassword2;
	@FXML
	private Button confirm;
	@FXML
	private Button cancel;
	@FXML
	private Label usernameword;
	@FXML
	private Label password1word;
	@FXML
	private Label password2word;
	
	 RegisterClientFrame registerclientframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 注册按钮的监听
	 */
	private void confirmAction(){
		String username = enterusername.getText();
		String password1 = enterpassword1.getText();
		String password2 = enterpassword2.getText();
		
		//处理用户没有输入用户名和密码便点击注册的情况
		if(username.equals("")){
			usernameword.setText("请输入用户名");
		}
		if(password1.equals("")){
			password1word.setText("请输入密码");
		}
		if(password2.equals("")){
			password2word.setText("请输入密码");
		}
		if(!username.equals("")){
			usernameword.setText(null);
		}
		if(!password1.equals("")){
			password1word.setText(null);
		}
		if(!password2.equals("")){
			password2word.setText(null);
		}
		if(!username.equals("")&&!password1.equals("")&&!password2.equals("")){
			UserRegisterClientBLService registerclient = new RegisterClientController();
			String result = registerclient.RegisterClient(username, password1, password2);
			if(!password1.equals("")&&result.equals("The two passwords is different.")){
				password2word.setText("两个密码不同");
			}else{
				//跳转到注册成功界面
			}
		}
		
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		viewcontrol.openDoCancelPopup();
//		registerclientframe.getPrimaryStage().close();
	}
	
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setRegisterClientFrame(RegisterClientFrame registerclientframe){
		this.registerclientframe = registerclientframe;
	}
}
