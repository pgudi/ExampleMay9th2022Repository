package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	enterSalaryForSachinTendulkar();
	//	enterSalaryForPersonWhoIsNextToSachinTendulkar();
	//	EnabletheStatusforDesignationIndianFreedomFighter();
	//	FromRahulDravidPreviousRecordSelectStatusasActive();
	//	BasedOnSachinTendulkarSalaryEditFieldFetchTheTableidAttributeValue();
		FromTableReferenceits5thRecordEnterSalary();
	}
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	private static void navigate()
	{
		try
		{
			oBrowser.navigate().to("file:///E:/HTML/WebTableHTML.html");
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	/**
	 *  following-sibling
	 *  Case 1: Enter the Salary for Person Name Sachin Tendulkar
	 */
	private static void enterSalaryForSachinTendulkar()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/input")).sendKeys("25000");
	}
	
	/**
	 *  following
	 *  Case 2: Enter the Salary for Person Who is next to Sachin Tendulkar
	 */
	private static void enterSalaryForPersonWhoIsNextToSachinTendulkar()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following::tr[1]/td[6]/input")).sendKeys("15000");
	}

	/**
	 *  preceding-sibling
	 *  Case 3: Enable the status for Designation Indian Freedom Fighter
	 */
	private static void EnabletheStatusforDesignationIndianFreedomFighter()
	{
		oBrowser.findElement(By.xpath("//td[text()='Indian Freedom Fighter']/preceding-sibling::td[1]/preceding-sibling::td[1]/input")).click();
	}
	
	/**
	 *  preceding
	 *  Case 4: From Rahul Dravid Previous Record select Status as Active
	 */
	private static void FromRahulDravidPreviousRecordSelectStatusasActive()
	{
		oBrowser.findElement(By.xpath("//td[text()='Rahul Dravid']/preceding::tr[1]/td[1]/input")).click();
	}
	
	/**
	 *  ancestor
	 *  Case 5: Based on Sachin Tendulkar Salary Edit Field Fetch the Table id Attribute Value
	 */
	private static void BasedOnSachinTendulkarSalaryEditFieldFetchTheTableidAttributeValue()
	{
		WebElement oEle=oBrowser.findElement(By.xpath("//input[@id='edit4']/ancestor::td/ancestor::tr/ancestor::table"));
		String content=oEle.getAttribute("id");
		System.out.println(content);
	}
	
	/**
	 *  descendant
	 *  Case 6: From Table Reference its 5th Record Enter Salary
	 */
	private static void FromTableReferenceits5thRecordEnterSalary()
	{
		WebElement oEle=oBrowser.findElement(By.xpath("//table[@id='tbl1']/descendant::tr[5]/td[6]/input"));
		oEle.sendKeys("24000");
	}
}
