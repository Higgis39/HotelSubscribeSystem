package vo;

/**
 * 
 * @author Administrator
 *
 *添加成功时界面之间传输的id
 */
public class OtherIdVO {
	static String id;
		
	public static void setid(String id){
		OtherIdVO.id = id;
	}
		
	public static String getid(){
		return id;
	}
}
