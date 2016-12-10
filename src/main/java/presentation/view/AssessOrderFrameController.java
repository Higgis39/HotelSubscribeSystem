package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
	@FXML
	private ComboBox<Integer> combobox;
	
	private AssessOrderFrame assessorderframe;
	
	@FXML
	/**
	 * 确认按钮的监听
	 */
	private void confirmAction(){
		String judgement = judge.getText();
		int grade = combobox.getSelectionModel().getSelectedIndex();
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
		combobox.getItems().addAll(1,2,3,4,5);
	}
	
	public void setAssessOrderFrame(AssessOrderFrame assessorderframe) {
		this.assessorderframe = assessorderframe;
	}

}
