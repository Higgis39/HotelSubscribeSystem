package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *AddHotelFrame的监听
 */
public class AddHotelFrameController {
	@FXML
	private TextField entername;
	@FXML
	private TextField enterphonenumber;
	@FXML
	private TextField enteraddress;
	@FXML
	private TextField enterbussinessarea;
	@FXML
	private TextField enterstar;
	@FXML
	private TextField enterservice;
	@FXML
	private TextArea enterintroduction;
	@FXML
	private PasswordField enterpassword1;
	@FXML
	private PasswordField enterpassword2;
	
	private AddHotelFrame addhotelframe;
	
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
	private void coinfirmAction(){
		
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		addhotelframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setAddHotelFrame(AddHotelFrame addhotelframe){
		this.addhotelframe = addhotelframe;
	}

}
