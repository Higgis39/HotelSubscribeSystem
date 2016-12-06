package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *ChangeUserMessageFrame的界面
 */
public class ChangeUserMessageFrameController {
	@FXML
	private TextField entername;
	@FXML
	private TextField enterphonenumber;
	@FXML
	private TextField entercreditvalue;
	@FXML
	private TextField entercompany;
	@FXML
	private DatePicker enterbirthday;
	@FXML
	private Label birthdaylabel;
	@FXML
	private Label companylabel;

	private ChangeUserMessageFrame changeusermessageframe;
	
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
		changeusermessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setChangeUserMessageFrame(ChangeUserMessageFrame changeusermessageframe){
		this.changeusermessageframe = changeusermessageframe;
	}
}
