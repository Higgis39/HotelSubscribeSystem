package vo;

import javafx.stage.Stage;

public class StageVO {
	//当前界面跳转前的界面
	private static Stage stage;
	
	private static Stage stage2;
	
	public static Stage getSatge(){
		return stage;
	}
	
	public static void setStage(Stage s){
		stage = s;
	}
	
	public static Stage getSatge2(){
		return stage2;
	}
	
	public static void setStage2(Stage s){
		stage2 = s;
	}
}
