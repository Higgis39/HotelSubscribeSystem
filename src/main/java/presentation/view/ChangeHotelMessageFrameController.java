package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChangeHotelMessageFrameController {
	@FXML
	private TextField enteraddress;
	@FXML
	private TextField entercity;
	@FXML
	private TextArea enterintroduction;
	@FXML
	private TextField enterservice;
	@FXML
	private TextField enterstar;
	
	private ChangeHotelMessageFrame changehotelmessageframe;
	
	@FXML
	/**
	 * +号按钮的监听
	 */
	private void plusAction(){
		int star = Integer.valueOf(enterstar.getText());
		if(star<5){
			star++;
		}
		enterstar.setText(Integer.toString(star));
	}
	
	@FXML
	/**
	 * -号按钮的监听
	 */
	private void minusAction(){
		int star = Integer.valueOf(enterstar.getText());
		if(star>1){
			star--;
		}
		enterstar.setText(Integer.toString(star));
	}
	
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
		changehotelmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setChangeHotelMessageFrame(ChangeHotelMessageFrame changehotelmessageframe) {
		this.changehotelmessageframe = changehotelmessageframe;
	}

}