package Promotion模块.MockWebPromotion;



public class MockHotel extends Hotel{
	String address;
	String businessArea;
	
	public MockHotel(String address, String businessArea) {
		this.address = address;
		this.businessArea = businessArea;
	}
	public String getAddress(){
		return address;
	}
	public String getbusinessArea(){
		return businessArea;
	}
}
