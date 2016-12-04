package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *ChangePersonalMessageFrame的监听
 */
public class ChangePersonalMessageFrameController {
	@FXML
	private TextField entername;
	@FXML
	private TextField enterphonenumber;
	
	private ChangePersonalMessageFrame changepersonalmessageframe;
	
	@FXML
	/**
	 * 保存的监听
	 */
	private void confirmAction(){
		String name = entername.getText();
		String phonenumber = enterphonenumber.getText();
		//进行保存操作
	}
	
	@FXML
	/**
	 * 取消的监听
	 */
	private void cancelAction(){
		changepersonalmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setChangePersonalMessageFrame(ChangePersonalMessageFrame changepersonalmessageframe){
		this.changepersonalmessageframe = changepersonalmessageframe;
	}
}
