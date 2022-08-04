package com.sgtesting.tests;
interface University
{
	void showUniversityName(String name);
}

interface EnggCollge
{
	void displayEnggCollgeName(String name);
}

class SLNCollege implements University,EnggCollge
{

	@Override
	public void displayEnggCollgeName(String name) {
		System.out.println("Engineering College Name :"+name);
		
	}

	@Override
	public void showUniversityName(String name) {
		System.out.println("University Name :"+name);
		
	}
	
}
public class InterfaceDemo {
	public static void main(String[] args) {
		University obj1=new SLNCollege();
		obj1.showUniversityName("VTU Belguam");
		
		EnggCollge obj2=(EnggCollge) obj1;
		obj2.displayEnggCollgeName("SLN Engineering College");

	}

}
