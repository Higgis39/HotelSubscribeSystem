package Manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ManageMessage.CreditChange;
import ManageMessage.PersonalMessage;

public class ManagerTest {
	ArrayList<String> credit = new ArrayList<String>();
	CreditChange crechan = new CreditChange(credit);
	
	@Test
	//Test1 管理人员查看用户信息
	public void testViewClient(){
		PersonalMessage m1 = new PersonalMessage("王远","15052346789",100);
		PersonalMessage m2 = new PersonalMessage("李刚","13256743690",50);
		MockUserPO mock1 = new MockUserPO("1001","王远","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("1002","李刚","",0,50,"13256743690",crechan);
		assertEquals(m1.name,mock1.ViewClient(true,"1001").name);
		assertEquals(m1.phonenumber,mock1.ViewClient(true,"1001").phonenumber);
		assertEquals(m1.creditvalue,mock1.ViewClient(true,"1001").creditvalue);
		assertEquals(m2.name,mock2.ViewClient(true,"1002").name);
		assertEquals(m2.phonenumber,mock2.ViewClient(true,"1002").phonenumber);
		assertEquals(m2.creditvalue,mock2.ViewClient(true,"1002").creditvalue);
	}
	
	@Test
	//Test2 管理人员修改用户信息
	public void testChangeCliet(){
		PersonalMessage m3 = new PersonalMessage("王远","15055446789",100);
		PersonalMessage m4 = new PersonalMessage("李晓刚","13256743632",50);
		MockUserPO mock1 = new MockUserPO("1001","王远","",0,100,"15052346789",crechan);
		MockUserPO mock2 = new MockUserPO("1002","李刚","",0,50,"13256743690",crechan);
		assertEquals(m3.name,mock1.ChangeClient(true,"1001","王远","15055446789").name);
		assertEquals(m3.phonenumber,mock1.ChangeClient(true,"1001","王远","15055446789").phonenumber);
		assertEquals(m3.creditvalue,mock1.ChangeClient(true,"1001","王远","15055446789").creditvalue);
		assertEquals(m4.name,mock2.ChangeClient(true,"1002","李晓刚","13256743632").name);
		assertEquals(m4.phonenumber,mock2.ChangeClient(true,"1002","李晓刚","13256743632").phonenumber);
		assertEquals(m4.creditvalue,mock2.ChangeClient(true,"1002","李晓刚","13256743632").creditvalue);
	}
	
	@Test
	//Test3 管理人员添加酒店
	public void testAddHotel(){
		ArrayList<String> Hotelname = new ArrayList<String>();
		ArrayList<String> Hoteladdress = new ArrayList<String>();
		ArrayList<String> Hotelphone = new ArrayList<String>();
		MockHotelList mock = new MockHotelList(Hotelname,Hoteladdress,Hotelphone);
		assertEquals(true,mock.AddHotel(true, "如家酒店","南京经天路20号","87654890"));
		assertEquals(true,mock.AddHotel(true, "汉庭酒店","南京新街口32号","87690987"));
		assertEquals(false,mock.AddHotel(false, "汉庭酒店","南京新街口32号","87690987"));
	}
	
	@Test
	//Test4 管理人员添加酒店工作人员
	public void testAddHotelWorker(){
		ArrayList<String> Hotelname = new ArrayList<String>();
		ArrayList<String> Hoteladdress = new ArrayList<String>();
		ArrayList<String> Hotelphone = new ArrayList<String>();
		MockHotelList mock = new MockHotelList(Hotelname,Hoteladdress,Hotelphone);
		assertEquals(true,mock.AddHotelWorker(true,"许永","如家酒店"));
		assertEquals(true,mock.AddHotelWorker(true,"刘永","汉庭酒店"));
		assertEquals(false,mock.AddHotelWorker(false,"刘永","汉庭酒店"));
	}
}
