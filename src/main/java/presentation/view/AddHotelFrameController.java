package presentation.view;

import java.sql.SQLException;

import businessLogic.userbl.AddHotelController;
import businessLogicService.userBLService.AddHotelBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.controller.ViewController;
import vo.HotelVO;
import vo.OtherIdVO;

/**
 * 
 * @author 费慧通
 *
 *AddHotelFrame的监听
 */
public class AddHotelFrameController {
	@FXML
	private Label samepassword;
	@FXML
	private TextField entername;
	@FXML
	private TextField enterphonenumber;
	@FXML
	private TextField enteraddress;
	@FXML
	private TextField enterbusinessarea;
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
	
	ViewController viewcontrol = new ViewController();
	
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
	private void coinfirmAction() throws SQLException{
		String hotelname = entername.getText();
		String phonenumber = enteraddress.getText();
		String address = enteraddress.getText();
		String businessarea = enterbusinessarea.getText();
		int star = Integer.valueOf(enterstar.getText());
		String introduction = enterintroduction.getText();
		String service = enterservice.getText();
		String password1 = enterpassword1.getText();
		String password2 = enterpassword2.getText();
		AddHotelBLService addhotelblservice = new AddHotelController();
		if(!password1.equals(password2)){
			samepassword.setText("两次密码不同");
		}else{
			samepassword.setText(null);
			HotelVO hotelvo = new HotelVO(null,password1,hotelname,phonenumber,address,businessarea,introduction,service,star,0.0);
			String result = addhotelblservice.AddHotel(hotelvo);
			OtherIdVO.setid(result);
			viewcontrol.openSuccessAddFrame();
			addhotelframe.getPrimaryStage().close();
		}
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
