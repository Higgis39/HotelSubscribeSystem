package User模块.ManageMessage;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ManageMessageTest{
	ArrayList<String> credit = new ArrayList<String>();
	CreditChange crechan = new CreditChange(credit);
	
	@Test
	//Test1 �鿴������Ϣ
	public void testGetMessage(){
		PersonalMessage m1 = new PersonalMessage("��Զ","15052346789",100);
		PersonalMessage m2 = new PersonalMessage("���","13256743690",50);
		MockUserPO mock1 = new MockUserPO("","��Զ","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("","���","",0,50,"13256743690",crechan);
		assertEquals(m1.creditvalue,mock1.getMessage().creditvalue);
		assertEquals(m1.name,mock1.getMessage().name);
		assertEquals(m1.phonenumber,mock1.getMessage().phonenumber);
		assertEquals(m2.creditvalue,mock2.getMessage().creditvalue);
		assertEquals(m2.name,mock2.getMessage().name);
		assertEquals(m2.phonenumber,mock2.getMessage().phonenumber);
	}
	
	@Test
	//Test2�鿴���ñ仯
	public void testGetCreditChange(){
		String change1 = "����100";
		String change2 = "����100";
		String change3 = "����50";
		String change4 = "����500";
		ArrayList<String> credit = new ArrayList<String>();
		credit.add(change1);
		credit.add(change2);
		credit.add(change3);
		credit.add(change4);
		CreditChange crechan = new CreditChange(credit);
		MockUserPO m = new MockUserPO("","��Զ","",0,100,"15052346789",crechan);
		assertEquals(crechan.creditchange,m.getCreditChange().creditchange);
	}
	
	@Test
	//Test3�޸ĸ�����Ϣ
	public void testChangeMessage(){
		MockUserPO mock1 = new MockUserPO("","��Զ","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("","���","",0,50,"13256743690",crechan);
		
		PersonalMessage m3 = new PersonalMessage("��Զ","15159762139",100);
		PersonalMessage m4 = new PersonalMessage("��С��","13767895467",50);
		
		assertEquals(m3.creditvalue,mock1.ChangeMessage("��Զ","15159762139").creditvalue);
		assertEquals(m3.name,mock1.ChangeMessage("��Զ","15159762139").name);
		assertEquals(m3.phonenumber,mock1.ChangeMessage("��Զ","15159762139").phonenumber);
		assertEquals(m4.creditvalue,mock2.ChangeMessage("��С��","13767895467").creditvalue);
		assertEquals(m4.name,mock2.ChangeMessage("��С��","13767895467").name);
		assertEquals(m4.phonenumber,mock2.ChangeMessage("��С��","13767895467").phonenumber);
	}
	
	@Test
	//Test4��ֵ����ֵ
	public void testRechargeCredit(){
		MockUserPO mock1 = new MockUserPO("","��Զ","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("","���","",0,50,"13256743690",crechan);
		
		assertEquals(300,mock1.RechargeCredit(200));
		assertEquals(450,mock2.RechargeCredit(400));
	}
	
	@Test
	//Test5 ע���Ա
	public void testRegisterVIP(){
		MockUserPO mock = new MockUserPO("","��Զ","",0,100,"15052346789",crechan);
		assertEquals(true,mock.RegisterVIP(0,"1980.11.11"));
	}
}
