package presentation.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *AddHotelWorkerFrame的监听
 */
public class AddHotelWorkerFrameController {
	@FXML
	private TextField enterhotelname;
	@FXML
	private TextField enterworkername;
	@FXML
	private TextField enterage;
	@FXML
	private TextField enterdate;
	@FXML
	private ComboBox<String> entersex;

	private AddHotelWorkerFrame addhotelworkerframe;
	
	@FXML
	/**
	 * 获得当前日期的监听
	 */
	private void getnowAction(){
		String now = LocalDate.now().toString();
		enterdate.setText(now);
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
		addhotelworkerframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		entersex.getItems().addAll("男","女");
	}
	
	public void setAddHotelWorkerFrame(AddHotelWorkerFrame addhotelworkerframe){
		this.addhotelworkerframe = addhotelworkerframe;
	}
}
