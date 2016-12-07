package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * 
 * @author 费慧通
 *
 *AssessOrderFrame的控制器
 */
public class AssessOrderFrameController {
	@FXML
	private TextArea judge;
	
	private AssessOrderFrame assessorderframe;
	
	@FXML
	/**
	 * 确认按钮的监听
	 */
	private void confirmAction(){
		String judgement = judge.getText();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		//返回之前的界面
		assessorderframe.getPrimaryStage().close();
	}

	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setAssessOrderFrame(AssessOrderFrame assessorderframe) {
		this.assessorderframe = assessorderframe;
	}

}
