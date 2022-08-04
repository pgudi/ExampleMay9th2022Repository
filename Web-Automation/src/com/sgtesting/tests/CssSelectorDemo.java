package com.sgtesting.tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CssSelectorDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	absolutePath();
	//	relativeCSSTagNameAlone();
	//	relativeCSSTagNameWithIDAttributeValue();
	//	relativeCSSWithIDAttributeValue();
	//	relativeCSSTagNameWithClassAttributeValue();
	//	relativeCSSWithClassAttributeValue();
	//	relativeCSSWithTagNameAndAttributeNameValueCombination();
	//	relativeCSSWithTagNameAndMultipleAttributeNameValueCombination();
	//	relativeCSSWithAttributeNameValueCombination();
	//	relativeCSSWithTagNameAndPartialMatchingAttributeNameValue();
	//	relativeCSSWithTagNameAndAttributeName();
	//	relativeCSSWithTagNameAndAttributeName_1();
	//	relativeCSSWithTagNameAndAttributeName_2();
	//	relativeCSSWithTagNameAndAttributeName_3();
	//	relativeCSSWithParentAndChild();
	//	relativeCSSWithNthChildConcept();
		relativeCSSWithSiblingApproach();
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
	
	private static void absolutePath()
	{
		oBrowser.findElement(By.cssSelector("html body div form input")).sendKeys("DemoUser1");
		
	}
	
	/**
	 * Case 1: Identify the Element based on tagName alone
	 * Syntax: <tagName>
	 */
	private static void relativeCSSTagNameAlone()
	{
		oBrowser.findElement(By.cssSelector("input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 2: Identify the Element based on tagName with id attribute value
	 * Syntax: <tagName>#<id attribute value>
	 */
	private static void relativeCSSTagNameWithIDAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input#pwd1pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 3: Identify the Element based id attribute value
	 * Syntax: #<id attribute value>
	 */
	private static void relativeCSSWithIDAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("#pwd1pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 4: Identify the Element based on tagName with class attribute value
	 * Syntax: <tagName>.<class attribute value>
	 */
	private static void relativeCSSTagNameWithClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input.pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 5: Identify the Element based on class attribute value
	 * Syntax: .<class attribute value>
	 */
	private static void relativeCSSWithClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector(".pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 6: Identify the Element based on tagName with attribute name and value combination
	 * Syntax: <tagName>[attributename='attributevalue']
	 */
	private static void relativeCSSWithTagNameAndAttributeNameValueCombination()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit']")).click();
	}
	
	/**
	 * Case 7: Identify the Element based on tagName with Multiple attribute name and value combination
	 * Syntax: <tagName>[attributename='attributevalue'][attributename='attributevalue']
	 */
	private static void relativeCSSWithTagNameAndMultipleAttributeNameValueCombination()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit'][type='button']")).click();
	}
	
	/**
	 * Case 8: Identify the Element based on attribute name and value combination
	 * Syntax: *[attributename='attributevalue']
	 */
	private static void relativeCSSWithAttributeNameValueCombination()
	{
		oBrowser.findElement(By.cssSelector("*[value='Submit']")).click();
	}
	
	/**
	 * Case 9: Identify the Element based on tagName with partial matching of Attribute value
	 * Syntax: 
	 * starts-with
	 * <tagName>[attributename ^= 'attributevalue']  
	 * ends-with
	 * <tagName>[attributename $= 'attributevalue'] 
	 * contains
	 * <tagName>[attributename *= 'attributevalue']
	 * 
	 */
	private static void relativeCSSWithTagNameAndPartialMatchingAttributeNameValue()
	{
	//	oBrowser.findElement(By.cssSelector("input[id ^= 'btn1']")).click();
		oBrowser.findElement(By.cssSelector("input[name *= 'mit1']")).click();
	}
	
	/**
	 * Case 9: Identify the Element based on tagName with attribute name combination
	 * Syntax: <tagName>[attributename]
	 */
	private static void relativeCSSWithTagNameAndAttributeName()
	{
		// findout number of links in a Web Page
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		System.out.println("# of Links :"+olinks.size());
	}
	
	private static void relativeCSSWithTagNameAndAttributeName_1()
	{
		// Display link names in a Web Page
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			System.out.println(link.getText());
		}
	}
	
	private static void relativeCSSWithTagNameAndAttributeName_2()
	{
		// Identify the link based on partial Text content : ends-with
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			if(link.getText().endsWith("Testing"))
			{
				link.click();
				break;
			}
		}
	}
	
	private static void relativeCSSWithTagNameAndAttributeName_3()
	{
		//  org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// element is not attached to the page document
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			if(link.getText().endsWith("Testing"))
			{
				link.click();
				
			}
		}
	}

	/**
	 * Case 10: Identify the Element based on Parent and Child Element approach
	 * Syntax: parentElement > childElement
	 */
	private static void relativeCSSWithParentAndChild()
	{
		oBrowser.findElement(By.cssSelector("form#frm2 > input")).click();
	}
	
	/**
	 * Case 11: Identify the Element based on nth-child approach
	 * Syntax: parentElement > :nth-child(number)
	 */
	private static void relativeCSSWithNthChildConcept()
	{
	//	oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(4)")).sendKeys("DemoUSer4");
		oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(1)")).sendKeys("DemoUSer4");
	}
	
	
	/**
	 * Case 12: Identify the Element based on Sibling approach
	 * Syntax: parentElement > childElement + childElement + childElement
	 */
	private static void relativeCSSWithSiblingApproach()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 > input + input + input")).sendKeys("DemoUser1");
	}
	
}
