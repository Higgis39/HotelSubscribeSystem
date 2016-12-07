package presentation.view;

import java.sql.SQLException;

import businessLogic.userbl.ManageUserController;
import businessLogicService.userBLService.ManageUserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.controller.ViewController;
import vo.OtherIdVO;

public class AddMarketerFrameController {
	@FXML
	private Label samepassword;
	@FXML
	private TextField entername;
	@FXML
	private PasswordField enterpassword1;
	@FXML
	private PasswordField enterpassword2;

	private AddMarketerFrame addmarketerframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction() throws NumberFormatException, SQLException{
		String name = entername.getText();
		String password1 = enterpassword1.getText();
		String password2 = enterpassword2.getText();
		ManageUserBLService service = new ManageUserController();
		String result = service.AddMarketer(true, name, password1, password2);
		if(result.equals("The two passwords are different.")){
			samepassword.setText("两次密码不同");
		}else{
			samepassword.setText(null);
			OtherIdVO.setid(result);
			viewcontrol.openSuccessAddFrame();
			addmarketerframe.getPrimaryStage().close();
		}
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		addmarketerframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setAddMarketerFrame(AddMarketerFrame addmarketerframe){
		this.addmarketerframe = addmarketerframe;
	}
}
