package p1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility1 {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		/*
		boolean val=isFramePresent(By.xpath("//iframe"));
		System.out.println(val);
		
		boolean val=isElementExists(By.xpath("//textarea"));
		System.out.println(val);
		*/
		oBrowser.switchTo().frame(0);
		int count=getElementsCount(By.xpath("//a"));
		System.out.println("# of Elements :"+count);
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
			oBrowser.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	private static boolean isFramePresent(By by)
	{
		boolean isFrame=false;
		try
		{
			WebElement oEle=oBrowser.findElement(by);
			isFrame=oEle.isDisplayed();
		}catch(Exception e)
		{
			isFrame=false;
		}
		return isFrame;
	}
	
	private static boolean isElementExists(By by)
	{
		boolean isElement=false;
		try
		{
			WebElement oEle=oBrowser.findElement(by);
			isElement=oEle.isDisplayed();
		}catch(Exception e)
		{
			isElement=false;
		}
		return isElement;
	}
	
	private static int getElementsCount(By by)
	{
		int count=0;
		try
		{
			List<WebElement> olist=oBrowser.findElements(by);
			count=olist.size();
		}catch (Exception e) 
		{
			
		}
		return count;
	}

}
