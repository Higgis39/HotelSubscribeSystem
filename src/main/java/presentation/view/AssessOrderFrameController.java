package presentation.view;

import businessLogic.orderbl.CommentOrderController;
import businessLogic.orderbl.CustomerViewOrderController;
import businessLogicService.orderBLService.CommentOrderService;
import businessLogicService.orderBLService.CustomerViewOrderService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.OrderVO;

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
	private ComboBox<Integer> combobox;
	
	private AssessOrderFrame assessorderframe;
	
	CustomerViewOrderService service = new CustomerViewOrderController();
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 确认按钮的监听
	 */
	private void confirmAction(){
		if(judge.isEditable()){
			String judgement = judge.getText();
			int grade = combobox.getSelectionModel().getSelectedIndex();
			OrderVO vo = service.ShowOrderMessage(FrameToFrameVO.getorderid());
			vo.setcomment(judgement);
			CommentOrderService s = new CommentOrderController();
			s.addComment(vo,grade);
			assessorderframe.getPrimaryStage().close();
			FrameToFrameVO.setword("保存成功");
			viewcontrol.openSuccessSaveFrame();
		}else{
			assessorderframe.getPrimaryStage().close();
		}
		
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		assessorderframe.getPrimaryStage().close();
	}

	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		combobox.getItems().addAll(1,2,3,4,5);
		OrderVO ordervo = service.ShowOrderMessage(FrameToFrameVO.getorderid());
		if(ordervo.getComment()!=null){
			judge.setText(ordervo.getComment());
			judge.setEditable(false);
			combobox.setDisable(true);
		}
	}
	
	public void setAssessOrderFrame(AssessOrderFrame assessorderframe) {
		this.assessorderframe = assessorderframe;
	}

}
