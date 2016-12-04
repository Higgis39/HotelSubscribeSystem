package presentation.view;

import javafx.fxml.FXML;

/**
 * 
 * @author 费慧通
 *
 *usertypenullpopup的控制器
 */
public class FailLoginPopupController {
	private FailLoginPopup popup;
	
	@FXML
	/**
	 * 用户点击确定时，关闭弹框
	 */
	private void confirmAction(){
		popup.getPrimaryStage().close();
	}
	
	@FXML
	private void initialize(){
		
	}
	
	public void setusertypenullpopup(FailLoginPopup popup){
		this.popup = popup;
	}
}
