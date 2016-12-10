package presentation.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 
 * @author 费慧通
 *
 *用户没有选择用户类型变点击登录，提示用户选择用户类型
 */
public class FailLoginFrame extends Application{
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage){
		this.primaryStage = primaryStage;

	    try{
	    	 FXMLLoader loader = new FXMLLoader();
		     loader.setLocation(getClass().getResource("FailLogin.fxml"));
		     AnchorPane frame = (AnchorPane) loader.load();
		        
		     Scene scene = new Scene(frame);
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     FailLoginFrameController controller = loader.getController();
		     controller.setusertypenullpopup(this);
	    }catch(Exception e){
	       	e.printStackTrace();
	    }
	}

	/**
     * Return the main stage.
    */
    public Stage getPrimaryStage() {
	    return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
