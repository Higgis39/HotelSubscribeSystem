package presentation.view;

import java.util.ArrayList;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import vo.IdVO;


/**
 * 
 * @author 费慧通
 *
 *ViewCreditChange的界面
 */
public class ViewCreditChangeFrameController {
	@FXML
	private ListView<String> list;
	
	private ViewCreditChangeFrame viewcreditchangeframe;
	
	@FXML
	private void confirmAction(){
		viewcreditchangeframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		MessageBLService service = new MessageController();
		ArrayList<String> a = service.GetCreditChange(IdVO.getid());
		ObservableList<String> items = FXCollections.observableArrayList (a);
		list.setItems(items);
	}

	public void setUserPersonalFrame(ViewCreditChangeFrame viewcreditchangeframe) {
		this.viewcreditchangeframe = viewcreditchangeframe;
	}

}
