package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeBirOrComFrameController {
	@FXML
	private Label bircom;
	@FXML
	private TextField enterbircom;
	@FXML
	private Button confirm;
	@FXML
	private Button cancel;
	
	private ChangeBirOrComFrame changebirorcomframe;
	
	@FXML
	private void confirmAction(){
		String bircom = enterbircom.getText();
		//保存新输入的生日/公司信息
	}
	
	@FXML
	/**
	 * 取消的监听
	 */
	private void cancelAction(){
		changebirorcomframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setChangeBirOrComFrame(ChangeBirOrComFrame changebirorcomframe){
		this.changebirorcomframe = changebirorcomframe;
	}
}
