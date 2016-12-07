package vo;

public class OtherIdVO {
	//添加成功时界面之间传输的id
	static String id;
		
	public static void setid(String id){
		IdVO.id = id;
	}
		
	public static String getid(){
		return id;
	}
}
