package presentation.view;

import businessLogic.promotionbl.WebPromotionController;
import businessLogicService.promotionBLService.WebPromotionBLService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.WebPromotionVO;

/**
 * 
 * @author 费慧通
 *
 *MakeMarketerPromotionFrame的监听
 */
public class MakeMarketerPromotionFrameController {
	@FXML
	private CheckBox checkbox;
	@FXML
	private Label name;
	@FXML
	private Label promotiontype;
	@FXML
	private TextField entername;
	@FXML
	private TextField entercity;
	@FXML
	private TextField enterdiscount;
	@FXML
	private ComboBox<String> enterpromotiontype;
	@FXML
	private ComboBox<String> enterVIPgrade;
	@FXML
	private DatePicker begindate;
	@FXML
	private DatePicker enddate;

	private MakeMarketerPromotionFrame makemarketerpromotionframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 选择框的监听
	 */
	private void checkboxAction(){
		if(checkbox.isSelected()){
			name.setDisable(false);
			entername.setDisable(false);
			promotiontype.setDisable(true);
			enterpromotiontype.setDisable(true);
		}else{
			name.setDisable(true);
			entername.setDisable(true);
			promotiontype.setDisable(false);
			enterpromotiontype.setDisable(false);
		}
	}
	
	@FXML
	/**
	 * 开始日期的监听
	 */
	private void begindateAction(){
		enddate.setValue(begindate.getValue());
	}
	
	@FXML
	/**
	 * 结束日期的监听
	 */
	private void enddateAction(){
		if(enddate.getValue().isBefore(begindate.getValue())){
			enddate.setValue(begindate.getValue());
		}
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		//保存新制定的策略
		WebPromotionBLService service = new WebPromotionController();
		
		double discount = (double)(Integer.valueOf(enterdiscount.getText()))/100;
		int VIPgrade = 0;
		if(!enterVIPgrade.getSelectionModel().getSelectedItem().equals("不要求")){
			VIPgrade = Integer.valueOf(enterVIPgrade.getSelectionModel().getSelectedItem());
		}
		String bdate,edate;
		if(begindate.getValue()!=null){
			bdate = begindate.getValue().toString();
		}else{
			bdate = null;
		}
		if(enddate.getValue()!=null){
			edate = enddate.getValue().toString();
		}else{
			edate = null;
		}
		if(checkbox.isSelected()){
			WebPromotionVO vo = new WebPromotionVO(entername.getText(),bdate,edate,entercity.getText(),VIPgrade,discount);
			service.webPromotionCreate(vo);
		}else{
			WebPromotionVO vo = new WebPromotionVO(enterpromotiontype.getSelectionModel().getSelectedItem(),bdate,edate,entercity.getText(),VIPgrade,discount);
			service.webPromotionCreate(vo);
		}
		
		makemarketerpromotionframe.getPrimaryStage().close();
		FrameToFrameVO.getSatge().close();
		viewcontrol.openMarketerPromotionFrame();
		FrameToFrameVO.setword("保存成功");
		viewcontrol.openSuccessSaveFrame();
	}
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		makemarketerpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterpromotiontype.getItems().addAll("特定期间活动折扣","特定商圈专属折扣","会员特定等级专属折扣");
		enterVIPgrade.getItems().addAll("不要求","1","2","3","4","5");
	}
	
	public void setMakeMarketerPromotionFrame(MakeMarketerPromotionFrame makemarketerpromotionframe){
		this.makemarketerpromotionframe = makemarketerpromotionframe;
	}
}
