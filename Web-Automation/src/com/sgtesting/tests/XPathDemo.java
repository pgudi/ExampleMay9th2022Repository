package com.sgtesting.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	absoluteXPathDemo();
	//	relativeXPathUsingTagNameAlone();
	//	relativeXPathUsingTagNameWithIndex();
	//	relativeXPathUsingTagNameWithAttributeNameValue();
	//	relativeXPathUsingAttributeNameValue();
	//	relativeXPathUsingAttributeValue();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameValue();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameValueUsingAndOperator();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameValueUsingOROperator();
	//	relativeXPathUsingPartialAttributeValue();
	//	relativeXPathUsingTagNameWithAttributeName();
	//	relativeXPathUsingTagNameWithAttributeName_1();
	//	relativeXPathUsingTagNameWithAttributeName_2();
	//	relativeXPathUsingTagNameWithAttributeName_3();
	//	relativeXPathUsingTagNameWithTextContent();
		relativeXPathUsingTagNameWithPartialTextContent();
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
			oBrowser.navigate().to("file:///E:/HTML/Sample.html");
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
		
	}
	
	private static void absoluteXPathDemo()
	{
		oBrowser.findElement(By.xpath("html/body/div/form/input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 1: Identify the Elemenet based on TagName Alone
	 * Syntax: //<tagName>
	 */
	private static void relativeXPathUsingTagNameAlone()
	{
		oBrowser.findElement(By.xpath("//input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 2: Identify the Element based on TagName with Index
	 * Syntax: //<tagName>[index]
	 */
	private static void relativeXPathUsingTagNameWithIndex()
	{
		oBrowser.findElement(By.xpath("//input[2]")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 3: Identify the Element based on TagName with 
	 *         attributename and value combination
	 * Syntax: //<tagName>[@attributename='attributevalue']
	 */
	private static void relativeXPathUsingTagNameWithAttributeNameValue()
	{
		oBrowser.findElement(By.xpath("//input[@name='pass1word1']")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 4: Identify the Element based on  
	 *         attributename and value combination
	 * Syntax: //*[@attributename='attributevalue']
	 */
	private static void relativeXPathUsingAttributeNameValue()
	{
		oBrowser.findElement(By.xpath("//*[@value='Submit']")).click();
	}

	/**
	 * Case 5: Identify the Element based on  
	 *         attributename value alone
	 * Syntax: //*[@*='attributevalue']
	 */
	private static void relativeXPathUsingAttributeValue()
	{
		oBrowser.findElement(By.xpath("//*[@*='Submit']")).click();
	}
	
	/**
	 * Case 6: Identify the Element based on TagName with 
	 *         Multiple attributename and value combination
	 * Syntax: //<tagName>[@attributename='attributevalue'][@attributename='attributevalue']
	 */
	private static void relativeXPathUsingTagNameWithMultipleAttributeNameValue()
	{
		oBrowser.findElement(By.xpath("//input[@type='button'][@name='submit1btn1']")).click();
	}
	
	/**
	 * Case 7: Identify the Element based on TagName with 
	 *         Multiple attributename and value combination using and operator
	 * Syntax: //<tagName>[@attributename='attributevalue' and @attributename='attributevalue']
	 */
	private static void relativeXPathUsingTagNameWithMultipleAttributeNameValueUsingAndOperator()
	{
		oBrowser.findElement(By.xpath("//input[@type='button' and @name='submit1btn1']")).click();
	}
	
	/**
	 * Case 8: Identify the Element based on TagName with 
	 *         Multiple attributename and value combination using or operator
	 * Syntax: //<tagName>[@attributename='attributevalue' or @attributename='attributevalue']
	 */
	private static void relativeXPathUsingTagNameWithMultipleAttributeNameValueUsingOROperator()
	{
		oBrowser.findElement(By.xpath("//input[@type='button' or @name='submit1btn1']")).click();
	}
	
	/**
	 * Case 9: Identify the Element based on TagName with 
	 *         attributename and partial attribute value combination
	 * Syntax: 
	 *  	starts-with(@attributename,'partialattributevalue')
	 *  	ends-with(@attributename,'partialattributevalue')
	 *      contains(@attributename,'partialattributevalue')
	 * //<tagName>[starts-with(@attributename,'partialattributevalue')]
	 * //<tagName>[ends-with(@attributename,'partialattributevalue')]
	 * //<tagName>[contains(@attributename,'partialattributevalue')]
	 */
	private static void relativeXPathUsingPartialAttributeValue()
	{
	//	oBrowser.findElement(By.xpath("//input[starts-with(@id,'btn1')]")).click();
		oBrowser.findElement(By.xpath("//input[contains(@id,'submit1')]")).click();
	}
	
	/**
	 * Case 10: Identify the Element based on TagName with attributename 
	 *          
	 * Syntax: //<tagName>[@attributename']
	 */
	private static void relativeXPathUsingTagNameWithAttributeName()
	{
		// find out number of links in a web page
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("# of Links are :"+olinks.size());
	}
	
	private static void relativeXPathUsingTagNameWithAttributeName_1()
	{
		// display all available link names
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			System.out.println(link.getText());
		}
	}
	
	private static void relativeXPathUsingTagNameWithAttributeName_2()
	{
		// Identify the link based on link text ends with
		try
		{
			List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
			for(int i=0;i<olinks.size();i++)
			{
				WebElement link=olinks.get(i);
				if(link.getText().endsWith("Testing"))
				{
					link.click();
					Thread.sleep(4000);
					break;
				}
			}
			oBrowser.navigate().back();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void relativeXPathUsingTagNameWithAttributeName_3()
	{
		// org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// element is not attached to the page document
		try
		{
			List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
			for(int i=0;i<olinks.size();i++)
			{
				WebElement link=olinks.get(i);
				if(link.getText().endsWith("Testing"))
				{
					link.click();
					Thread.sleep(4000);
				}
			}
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Case 11: Identify the Element based on TagName with 
	 *          Text Content
	 * Syntax: //<tagName>[text()='Text Content']
	 */
	private static void relativeXPathUsingTagNameWithTextContent()
	{
		oBrowser.findElement(By.xpath("//a[text()='POI Apache']")).click();
	}
	
	/**
	 * Case 12: Identify the Element based on TagName with 
	 *          Partial Text Content
	 * Syntax: 
	 * starts-with(text(),'partial Text Content')
	 * ends-with(text(),'partial Text Content')
	 * contains(text(),'partial Text Content')
	 * //<tagName>[starts-with(text(),'partial Text Content')]
	 * //<tagName>[ends-with(text(),'partial Text Content')]
	 * //<tagName>[contains(text(),'partial Text Content')]
	 */
	private static void relativeXPathUsingTagNameWithPartialTextContent()
	{
	//	oBrowser.findElement(By.xpath("//a[starts-with(text(),'S G')]")).click();
		oBrowser.findElement(By.xpath("//a[contains(text(),'ware')]")).click();
	}
}
