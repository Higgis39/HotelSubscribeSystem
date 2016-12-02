package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import presentation.controller.ViewController;

public class HistoricalOrderFrameController {
	@FXML
	private Button searchhotel;
	@FXML
	private Button personal;
	@FXML
	private Button view;
	@FXML
	private Label username;
	@FXML
	private Label id;
	@FXML
	private ComboBox<String> enterordertype;
	
	private HistoricalOrderFrame historicalorderframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * “酒店查询”的监听
	 */
	private void searchhotelAction(){
		//打开用户主界面（普通客户）
		viewcontrol.openUserMainFrame();
		historicalorderframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * “个人中心”的监听
	 */
	private void personalAction(){
		//打开个人信息界面
		viewcontrol.openUserPersonalFrame();
		historicalorderframe.getPrimaryStage().close();
	}
	
	@FXML
	private void viewAction(){
		String ordertype = enterordertype.getSelectionModel().getSelectedItem();
		//根据得到的订单类型进行搜索
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterordertype.getItems().addAll("未执行的正常订单","已执行的正常订单","异常订单","已撤销订单");
	}
	
	public void setHistoricalOrderFrame(HistoricalOrderFrame historicalorderframe){
		this.historicalorderframe = historicalorderframe;
	}
}
