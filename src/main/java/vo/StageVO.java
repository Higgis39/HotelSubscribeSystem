package vo;

import javafx.stage.Stage;

public class StageVO {
	//当前界面跳转前的界面
	private static Stage stage;
	
	public static Stage getSatge(){
		return stage;
	}
	
	public static void setStage(Stage s){
		stage = s;
	}
}
