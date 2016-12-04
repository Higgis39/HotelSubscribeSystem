package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *ChangeBirOrComFrame的监听
 */
public class ChangeBirOrComFrameController {
	@FXML
	private Label bircom;
	@FXML
	private TextField enterbircom;
	
	private ChangeBirOrComFrame changebirorcomframe;
	
	@FXML
	private void confirmAction(){
		String birorcom = enterbircom.getText();
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
