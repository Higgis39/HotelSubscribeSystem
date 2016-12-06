package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddMarketerFrameController {
	@FXML
	private TextField entername;
	@FXML
	private PasswordField enterpassword1;
	@FXML
	private PasswordField enterpassword2;

	private AddMarketerFrame addmarketerframe;
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		
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
