package User.Log;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LogTest {
	ArrayList<String> idList = new ArrayList<String>();
	ArrayList<String> passwordList = new ArrayList<String>();
	ArrayList<Integer> user_typeList = new ArrayList<Integer>();
	
	@Before
	public void Begin(){
		String id1 = "1000";
		String id2 = "1001";
		String id3 = "1002";
		String password1 = "qwert";
		String password2 = "asdfghsdvkj";
		String password3 = "uweyij498";
		int user_type1 = 0;
		int user_type2 = 2;
		int user_type3 = 1;
		idList.add(id1);
		idList.add(id2);
		idList.add(id3);
		passwordList.add(password1);
		passwordList.add(password2);
		passwordList.add(password3);
		user_typeList.add(user_type1);
		user_typeList.add(user_type2);
		user_typeList.add(user_type3);
	}
	
	@Test
	//Test1 ��¼
	public void testLogin(){
		MockUserList m = new MockUserList(idList,passwordList,user_typeList);
		assertEquals(true,m.Login("1000","qwert",0));
		assertEquals(false,m.Login("1001","jhsdfj",2));
		assertEquals(false,m.Login("1002","uweyij498",0));
	}
	
	@Test
	//Test2 ע����ͨ�û�
	public void testRegisterClient(){
		MockUserList m = new MockUserList(idList,passwordList,user_typeList);
		assertEquals("The two passwords is different.",m.RegisterClient("������","asdf","asdfe"));
		assertEquals("Register successfully! Your id is 1003",m.RegisterClient("����","asdf","asdf"));
	}
}
