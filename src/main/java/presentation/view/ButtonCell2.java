package presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.OrderIdVO;
import vo.OrderVO;

public class ButtonCell2 extends TableCell<OrderVO,Boolean> {
	FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("评价");
	
	ButtonCell2(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
				OrderIdVO.setorderid(ordervo.getorderId());
                viewcontrol.openAssessOrderFrame();
            }
        });
    }
    
	@Override
    protected void updateItem(Boolean t, boolean empty) {
		super.updateItem(t, empty);
        if(!empty){
        	setGraphic(cellButton);
        }
    }
}
