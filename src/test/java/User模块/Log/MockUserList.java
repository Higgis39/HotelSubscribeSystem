package Log;

import java.util.ArrayList;

import ManageMessage.CreditChange;
import ManageMessage.MockUserPO;

public class MockUserList {
	
	ArrayList<String> idList = new ArrayList<String>();
	ArrayList<String> passwordList = new ArrayList<String>();
	ArrayList<Integer> user_typeList = new ArrayList<Integer>();
	
	public MockUserList(ArrayList<String> idList, ArrayList<String> passwordList, ArrayList<Integer> user_typeList) {
		this.idList = idList;
		this.passwordList = passwordList;
		this.user_typeList = user_typeList;
	}

	public boolean Login(String id, String password, int user_type) {
		if(getpassword(id,user_type).equals("")){
			return false;
		}
		else if(getpassword(id,user_type).equals(password)){
			return true;
		}
		return false;
	}

	public String RegisterClient(String name, String password1, String password2) {
		if(!password1.equals(password2)){
			return "The two passwords is different.";
		}else{
			int lastid = Integer.valueOf(idList.get(idList.size()-1));
			String newid = Integer.toString(lastid+1);
			idList.add(newid);
			passwordList.add(password1);
			user_typeList.add(0);
			ArrayList<String> c = new ArrayList<String>();
			CreditChange credit = new CreditChange(c);
			MockUserPO u = new MockUserPO(newid,name,password1,0,0,"",credit);
			return "Register successfully! Your id is "+newid;
		}
	}
	
	public String getpassword(String id,int user_type){
		if(getaddress(id,user_type)==-1){
			return "";
		}else{
			return passwordList.get(getaddress(id,user_type));
		}
	}
	
	public int getaddress(String id,int user_type){
		for(int i=0;i<idList.size();i++){
			if(idList.get(i).equals(id)&&user_typeList.get(i)==user_type){
				return i;
			}
		}
		return -1;
	}
	
}
