package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.controller.ViewController;

/**
 * 
 * @author 费慧通
 *
 *EnterUserfulRoomFrame的监听
 */
public class EnterUserfulRoomFrameController {
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField enterroomprice;
	@FXML
	private ComboBox<String> enterroomtype;
	
	private EnterUserfulRoomFrame enteruserfulroomframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * +号按钮的监听
	 */
	private void plusAction(){
		int num = Integer.valueOf(enterroomnum.getText());
		num++;
		enterroomnum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * -号按钮的监听
	 */
	private void minusAction(){
		int num = Integer.valueOf(enterroomnum.getText());
		if(num>1){
			num--;
		}
		enterroomnum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 继续添加按钮的监听
	 */
	private void continueAction(){
		confirmAction();
		enteruserfulroomframe.getPrimaryStage().close();
		viewcontrol.openEnterUserfulRoomFrame();
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		int roomnum = Integer.valueOf(enterroomnum.getText());
		int roomprice = Integer.valueOf(enterroomprice.getText());
		//保存客房信息
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		enteruserfulroomframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterroomtype.getItems().addAll("单人间","双人间","三人间");
	}

	public void setEnterUserfulRoomFrame(EnterUserfulRoomFrame enteruserfulroomframe) {
		this.enteruserfulroomframe = enteruserfulroomframe;
	}

}
