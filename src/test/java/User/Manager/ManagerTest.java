package User.Manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import User.ManageMessage.CreditChange;
import User.ManageMessage.PersonalMessage;

public class ManagerTest {
	ArrayList<String> credit = new ArrayList<String>();
	CreditChange crechan = new CreditChange(credit);
	
	@Test
	//Test1 ������Ա�鿴�û���Ϣ
	public void testViewClient(){
		PersonalMessage m1 = new PersonalMessage("��Զ","15052346789",100);
		PersonalMessage m2 = new PersonalMessage("���?","13256743690",50);
		MockUserPO mock1 = new MockUserPO("1001","��Զ","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("1002","���?","",0,50,"13256743690",crechan);
		assertEquals(m1.name,mock1.ViewClient(true,"1001").name);
		assertEquals(m1.phonenumber,mock1.ViewClient(true,"1001").phonenumber);
		assertEquals(m1.creditvalue,mock1.ViewClient(true,"1001").creditvalue);
		assertEquals(m2.name,mock2.ViewClient(true,"1002").name);
		assertEquals(m2.phonenumber,mock2.ViewClient(true,"1002").phonenumber);
		assertEquals(m2.creditvalue,mock2.ViewClient(true,"1002").creditvalue);
	}
	
	@Test
	//Test2 ������Ա�޸��û���Ϣ
	public void testChangeCliet(){
		PersonalMessage m3 = new PersonalMessage("��Զ","15055446789",100);
		PersonalMessage m4 = new PersonalMessage("������","13256743632",50);
		MockUserPO mock1 = new MockUserPO("1001","��Զ","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("1002","���?","",0,50,"13256743690",crechan);
		assertEquals(m3.name,mock1.ChangeClient(true,"1001","��Զ","15055446789").name);
		assertEquals(m3.phonenumber,mock1.ChangeClient(true,"1001","��Զ","15055446789").phonenumber);
		assertEquals(m3.creditvalue,mock1.ChangeClient(true,"1001","��Զ","15055446789").creditvalue);
		assertEquals(m4.name,mock2.ChangeClient(true,"1002","������","13256743632").name);
		assertEquals(m4.phonenumber,mock2.ChangeClient(true,"1002","������","13256743632").phonenumber);
		assertEquals(m4.creditvalue,mock2.ChangeClient(true,"1002","������","13256743632").creditvalue);
	}
	
	@Test
	//Test3 ������Ա��ӾƵ�?
	public void testAddHotel(){
		ArrayList<String> Hotelname = new ArrayList<String>();
		ArrayList<String> Hoteladdress = new ArrayList<String>();
		ArrayList<String> Hotelphone = new ArrayList<String>();
		MockHotelList mock = new MockHotelList(Hotelname,Hoteladdress,Hotelphone);
		assertEquals(true,mock.AddHotel(true, "��ҾƵ�?","�Ͼ�����·20��","87654890"));
		assertEquals(true,mock.AddHotel(true, "��ͥ�Ƶ�","�Ͼ��½ֿ�32��","87690987"));
		assertEquals(false,mock.AddHotel(false, "��ͥ�Ƶ�","�Ͼ��½ֿ�32��","87690987"));
	}
	
	@Test
	//Test4 ������Ա��ӾƵ깤�����?
	public void testAddHotelWorker(){
		ArrayList<String> Hotelname = new ArrayList<String>();
		ArrayList<String> Hoteladdress = new ArrayList<String>();
		ArrayList<String> Hotelphone = new ArrayList<String>();
		MockHotelList mock = new MockHotelList(Hotelname,Hoteladdress,Hotelphone);
		assertEquals(true,mock.AddHotelWorker(true,"����","��ҾƵ�?"));
		assertEquals(true,mock.AddHotelWorker(true,"����","��ͥ�Ƶ�"));
		assertEquals(false,mock.AddHotelWorker(false,"����","��ͥ�Ƶ�"));
	}
}
