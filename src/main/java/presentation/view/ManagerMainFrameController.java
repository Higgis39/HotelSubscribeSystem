package presentation.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.controller.ViewController;
import vo.WorkerVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *ManagerMainFrame的监听
 */
public class ManagerMainFrameController {
	@FXML
	private Label id;
	@FXML
	private Label name;
	@FXML
	private TextField enterid;
	@FXML
	private TextField enterhotelid;
	@FXML
	private TableView<UserVO> user;
	@FXML
	private TableView<WorkerVO> worker;
	@FXML
	private TableColumn<UserVO,String> username;
	@FXML
	private TableColumn<UserVO,String> usertype;
	@FXML
	private TableColumn<UserVO,String> address;
	@FXML
	private TableColumn<UserVO,String> VIPtype;
	@FXML
	private TableColumn<UserVO,Number> creditvalue;
	@FXML
	private TableColumn<UserVO,String> VIPgrade;
	@FXML
	private TableColumn<UserVO,String> birthdayorcompany;
	@FXML
	private TableColumn<WorkerVO,String> workername;
	@FXML
	private TableColumn<WorkerVO,Number> age;
	@FXML
	private TableColumn<WorkerVO,LocalDate> begindate;
	@FXML
	private TableColumn<WorkerVO,String> sex;
	@FXML
	private Hyperlink link;

	private ManagerMainFrame managermainframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 查询用户信息的监听
	 */
	private void lookuserAction(){
		//查询用户信息
		
		if(!enterid.getText().equals("")){
			link.setVisible(true);
			user.setVisible(true);
		}else{
			link.setVisible(false);
			user.setVisible(false);
		}
	}
	
	@FXML
	private void lookworkerAction(){
		//查询酒店工作人员信息
		
		if(!enterhotelid.getText().equals("")){
			worker.setVisible(true);
		}else{
			worker.setVisible(false);
		}
	}
	
	@FXML
	/**
	 * 修改用户信息的监听
	 */
	private void linkAction(){
		//打开修改用户信息的界面
		viewcontrol.openChangeUserMessageFrame();
	}
	
	@FXML
	/**
	 * 添加网站营销人员的监听
	 */
	private void addmarketerAction(){
		//打开添加网站营销人员的界面
		viewcontrol.openAddMarketerFrame();
	}
	
	@FXML
	/**
	 * 添加酒店的监听
	 */
	private void addhotelAction(){
		//打开添加酒店界面
		viewcontrol.openAddHotelFrame();
	}
	
	@FXML
	/**
	 * 添加酒店工作人员的监听
	 */
	private void addhotelworkerAction(){
		//打开添加酒店工作人员界面
		viewcontrol.openAddHotelWorkerFrame();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setManagerMainFrame(ManagerMainFrame managermainframe){
		this.managermainframe = managermainframe;
	}
}
