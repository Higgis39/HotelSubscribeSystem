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
 *普通客户注册的界面
 */
public class RegisterClientFrame extends Application{
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("注册账号");

	    try{
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("RegisterClient.fxml"));
	        AnchorPane frame = (AnchorPane) loader.load();
	        
	        Scene scene = new Scene(frame);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        RegisterClientFrameController controller = loader.getController();
	        controller.setRegisterClientFrame(this);
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