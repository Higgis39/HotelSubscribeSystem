package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	private Button confirm;
	@FXML
	private Button cancel;
	
	private AssessOrderFrame assessorderframe;
	
	@FXML
	private void judgeAction(){
		//用户点击时默认文字消失
//		String text = judge.getText();
//		System.out.println(text);
//		if(text.equals("请在此填写入住期间的感受，欢迎再次光临！")){
//			System.out.println("abcd");
//			judge.setText("");
//		}
	}
	
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
