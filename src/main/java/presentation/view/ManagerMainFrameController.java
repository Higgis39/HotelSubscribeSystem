package presentation.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.hotelbl.ViewController;
import businessLogic.userbl.MessageController;
import businessLogicService.hotelBLService.ViewService;
import businessLogicService.userBLService.MessageBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.WorkerVO;
import vo.IdVO;
import vo.OtherIdVO;
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
	private TableColumn<UserVO,Number> VIPgrade;
	@FXML
	private TableColumn<UserVO,String> birthdayorcompany;
	@FXML
	private TableColumn<WorkerVO,String> workername;
	@FXML
	private TableColumn<WorkerVO,Number> age;
	@FXML
	private TableColumn<WorkerVO,String> begindate;
	@FXML
	private TableColumn<WorkerVO,String> sex;
	@FXML
	private Hyperlink link;

	private ManagerMainFrame managermainframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 查询用户信息的监听
	 */
	private void lookuserAction(){
		//查询用户信息
		MessageBLService service = new MessageController();
		UserVO vo = service.GetMessage(enterid.getText());
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(vo);
		ObservableList<UserVO> data = FXCollections.observableList(list);
		user.setItems(data);
		username.setCellValueFactory(cellData->cellData.getValue().getnameProperty());
		usertype.setCellValueFactory(cellData->cellData.getValue().getusertypeProperty());
		address.setCellValueFactory(cellData->cellData.getValue().getphonenumberProperty());
		VIPtype.setCellValueFactory(cellData->cellData.getValue().getVIPtypeProperty());
		creditvalue.setCellValueFactory(cellData->cellData.getValue().getcreditvalueProperty());
		VIPgrade.setCellValueFactory(cellData->cellData.getValue().getVIPgradeProperty());
		if(vo.getbirthday()==null){
			birthdayorcompany.setText("企业");
			birthdayorcompany.setCellValueFactory(cellData->cellData.getValue().getcompanyProperty());
		}else{
			birthdayorcompany.setText("生日");
			birthdayorcompany.setCellValueFactory(cellData->cellData.getValue().getbirthdayProperty());
		}
		
		if(!enterid.getText().equals("")){
			link.setVisible(true);
			user.setVisible(true);
		}else{
			link.setVisible(false);
			user.setVisible(false);
		}
	}
	
	@FXML
	private void lookworkerAction() throws SQLException{
		//查询酒店工作人员信息
		ViewService service = new ViewController();
		List<WorkerVO> vo = service.findworker(enterhotelid.getText());
		ObservableList<WorkerVO> data = FXCollections.observableList(vo);
		worker.setItems(data);
		workername.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
		age.setCellValueFactory(cellData->cellData.getValue().getAgeProperty());
		begindate.setCellValueFactory(cellData->cellData.getValue().getBeginTimeProperty());
		sex.setCellValueFactory(cellData->cellData.getValue().getSexProperty());
		
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
		OtherIdVO.setid(enterid.getText());
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
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		managermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(IdVO.getid());
		id.setId(uservo.getid());
		name.setText(uservo.getname());
	}
	
	public void setManagerMainFrame(ManagerMainFrame managermainframe){
		this.managermainframe = managermainframe;
	}
}
