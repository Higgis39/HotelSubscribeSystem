package presentation.view;

import java.sql.SQLException;

import businessLogic.userbl.RegisterClientController;
import businessLogicService.userBLService.RegisterClientBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.IdVO;
import vo.StageVO;
import vo.UserVO;

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
	private Label usernameword;
	@FXML
	private Label password1word;
	@FXML
	private Label password2word;
	
	private RegisterClientFrame registerclientframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 注册按钮的监听
	 */
	private void confirmAction() throws SQLException{
		String username = enterusername.getText();
		String password1 = enterpassword1.getText();
		String password2 = enterpassword2.getText();
		
		//处理用户没有输入用户名和密码便点击注册的情况
		if(username.equals("")){
			usernameword.setText("请输入用户名");
		}else{
			usernameword.setText(null);
		}
		if(password1.equals("")){
			password1word.setText("请输入密码");
		}else{
			password1word.setText(null);
		}
		if(password2.equals("")){
			password2word.setText("请输入密码");
		}else{
			password2word.setText(null);
		}
		
		if(!username.equals("")&&!password1.equals("")&&!password2.equals("")){
			RegisterClientBLService registerclient = new RegisterClientController();
			if(!password1.equals(password2)){
				password2word.setText("两个密码不同");
			}else{
				//跳转到注册成功界面
				String result = registerclient.RegisterClient(new UserVO(username,null,password1,null,null,0,null,0,null,null));
				IdVO.setid(result);
				viewcontrol.openSuccessRegisterFrame();
				registerclientframe.getPrimaryStage().close();
			}
		}
		
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		viewcontrol.openDoCancelPopup();
		StageVO.setStage(registerclientframe.getPrimaryStage());
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
