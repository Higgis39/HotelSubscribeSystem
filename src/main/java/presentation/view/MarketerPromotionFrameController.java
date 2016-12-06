package presentation.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import presentation.controller.ViewController;
import vo.WebPromotionVO;

/**
 * 
 * @author 费慧通
 *
 *MarketerPromotionFrame的监听
 */
public class MarketerPromotionFrameController {
	@FXML
	private Label id;
	@FXML
	private Label name;
	@FXML
	private TreeTableView<WebPromotionVO> treetableview;
	@FXML
	private TreeTableColumn<WebPromotionVO,String> promotiontype;
	@FXML
	private TreeTableColumn<WebPromotionVO,LocalDate> promotiontime;
	@FXML
	private TreeTableColumn<WebPromotionVO,String> city;
	@FXML
	private TreeTableColumn<WebPromotionVO,Number> VIPgrade;
	@FXML
	private TreeTableColumn<WebPromotionVO,Number> discount;
	
	private MarketerPromotionFrame marketerpromotionframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 订单浏览的监听
	 */
	private void orderviewAction(){
		//打开营销人员主界面
		viewcontrol.openMarketerMainFrame();
		marketerpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 去制定营销策略的监听
	 */
	private void linkAction(){
		//打开制定营销策略的监听
		viewcontrol.openMakeMarketerPromotionFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		marketerpromotionframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setMarketerPromotionFrame(MarketerPromotionFrame marketerpromotionframe){
		this.marketerpromotionframe = marketerpromotionframe;
	}
}
