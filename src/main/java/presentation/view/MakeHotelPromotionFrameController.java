package presentation.view;

import businessLogic.promotionbl.HotelPromotionController;
import businessLogicService.promotionBLService.HotelPromotionBLService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelPromotionVO;
import vo.StageVO;

/**
 * 
 * @author 费慧通
 *
 *MakeHotelPromotionFrame的监听
 */
public class MakeHotelPromotionFrameController {
	@FXML
	private CheckBox checkbox;
	@FXML
	private Label promotiontype;
	@FXML
	private Label promotionname;
	@FXML
	private TextField enterpromotionname;
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField enterdiscount;
	@FXML
	private ComboBox<String> enterpromotiontype;
	@FXML
	private ComboBox<String> enterbirthday;
	@FXML
	private ComboBox<String> company;
	@FXML
	private DatePicker begindate;
	@FXML
	private DatePicker enddate;
	
	private MakeHotelPromotionFrame makehotelpromotionframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 选择框的监听
	 */
	private void checkboxAction(){
		if(checkbox.isSelected()){
			promotionname.setDisable(false);
			enterpromotionname.setDisable(false);
			promotiontype.setDisable(true);
			enterpromotiontype.setDisable(true);
		}else{
			promotionname.setDisable(true);
			enterpromotionname.setDisable(true);
			promotiontype.setDisable(false);
			enterpromotiontype.setDisable(false);
		}
	}
	
	@FXML
	/**
	 * 开始日期的监听
	 */
	private void enterbegindateAction(){
		enddate.setValue(begindate.getValue());
	}
	
	@FXML
	/**
	 * 结束日期的监听
	 */
	private void enterenddateAction(){
		if(enddate.getValue().isBefore(begindate.getValue())){
			enddate.setValue(begindate.getValue());
		}
	}
	
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
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		HotelPromotionBLService service = new HotelPromotionController();
		
		boolean isbirthday,iscompany;
		if(enterbirthday.getSelectionModel().getSelectedItem().equals("有")){
			isbirthday = true;
		}else{
			isbirthday = false;
		}
		if(company.getSelectionModel().getSelectedItem().equals("有")){
			iscompany = true;
		}else{
			iscompany = false;
		}
		double discount = Integer.valueOf(enterdiscount.getText())/100;
		if(checkbox.isSelected()){
			HotelPromotionVO vo = new HotelPromotionVO(HotelNameVO.getHotelname(),enterpromotionname.getText(),isbirthday,
					Integer.valueOf(enterroomnum.getText()),iscompany,begindate.getValue().toString(),enddate.getValue().toString(),discount);
			service.hotelPromotionCreate(vo);
		}else{
			HotelPromotionVO vo = new HotelPromotionVO(HotelNameVO.getHotelname(),enterpromotiontype.getSelectionModel().getSelectedItem(),isbirthday,
					Integer.valueOf(enterroomnum.getText()),iscompany,begindate.getValue().toString(),enddate.getValue().toString(),discount);
			service.hotelPromotionCreate(vo);
		}
		
		makehotelpromotionframe.getPrimaryStage().close();
		StageVO.getSatge().close();
		viewcontrol.openHotelPromotionFrame();
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		makehotelpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterpromotiontype.getItems().addAll("生日特惠折扣","三间及以上预订特惠","合作企业客户折扣","双11活动折扣");
		enterbirthday.getItems().addAll("是","否");
		company.getItems().addAll("有","无");
	}

	public void setMakeHotelPromotionFrame(MakeHotelPromotionFrame makehotelpromotionframe) {
		this.makehotelpromotionframe = makehotelpromotionframe;
	}

}
