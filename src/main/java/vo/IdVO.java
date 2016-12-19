package vo;

/**
 * 
 * @author Administrator
 *跳转界面时界面之间传输的id
 */
public class IdVO {
	static String id;
	
	public static void setid(String id){
		IdVO.id = id;
	}
	
	public static String getid(){
		return id;
	}
}
