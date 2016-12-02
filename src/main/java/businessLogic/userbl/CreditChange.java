package businessLogic.userbl;
import java.util.ArrayList;

/**
 * 
 * @author 费慧通
 *
 */
public class CreditChange {
	public ArrayList<String> creditchange = new ArrayList<String>();
	
	public CreditChange(ArrayList<String> creditchange){
		this.creditchange = creditchange;
	}
	
	//添加新的信用变化
	public void addcreditchange(String change){
		creditchange.add(change);
	}
}
