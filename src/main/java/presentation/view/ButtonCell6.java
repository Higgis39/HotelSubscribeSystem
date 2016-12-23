package presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.WorkerVO;

public class ButtonCell6 extends TableCell<WorkerVO,Boolean> {
	FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("修改");
	
	ButtonCell6(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				WorkerVO vo = getTableView().getItems().get(getIndex());
				FrameToFrameVO.setworkervo(vo);
				viewcontrol.openChangeWorkerMessageFrame();
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
