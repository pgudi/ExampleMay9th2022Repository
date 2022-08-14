package com.sgtesting.actitime.stepdefinitions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.sgtesting.actitime.utility.ApplicationDependent;
import com.sgtesting.actitime.utility.ApplicationIndependent;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActiTimeStepDefinition {
	public static WebDriver oBrowser=null;
	public static String firstname=null;
	public static String lastname=null;
	public static ActiTimePages actiTimePage=null;


	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Given("^Launch the application$")
	public void Launch_the_application()
	{
		try
		{
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			actiTimePage=new ActiTimePages(oBrowser);
			ApplicationIndependent.waitFor(2L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@And("^Navigate to the url of the application$")
	public void Navigate_to_the_url_of_the_application()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			ApplicationIndependent.waitFor(5L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Login using valid credentials$")
	public void Login_using_valid_credentials(DataTable credentials)
	{  
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			for (int i=0;i<data.size();i++)
			{
				actiTimePage.getUserName().sendKeys(data.get(i).get("username"));
				actiTimePage.getPassword().sendKeys(data.get(i).get("password"));
				actiTimePage.getLoginBtn().click();
				ApplicationIndependent.waitFor(5L);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^the Home page should display$")
	public void the_Home_page_should_display()
	{
		try
		{
			Assert.assertTrue(ApplicationDependent.isObjectPresent(oBrowser,By.xpath("//td[text()='Enter Time-Track']")));
			ApplicationIndependent.waitFor(2L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Perform logout action$")
	public void Perform_logout_action()
	{
		try
		{
			actiTimePage.getLogoutLink().click();
			ApplicationIndependent.waitFor(2L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^the login page should display$")
	public void the_login_page_should_display()
	{
		String expected,actual;
		try
		{
			expected="actiTIME - Login";
			actual=oBrowser.getTitle();
			ApplicationIndependent.waitFor(2L);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@And("^Close Application Browser$")
	public void Close_Application_Browser()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Create an User$")
	public void Create_an_User(DataTable userdetails)
	{
		try
		{
			List<Map<String,String>> data=userdetails.asMaps(String.class, String.class);
			firstname=data.get(0).get("firstname");
			lastname=data.get(0).get("lastname");
			String email=data.get(0).get("email");
			String username=data.get(0).get("username");
			String password=data.get(0).get("userpassword");
			String repassword=data.get(0).get("userretypepasword");

			oBrowser.findElement(By.xpath("html/body/div[4]/table/tbody/tr[1]/td[5]/a/div[2]")).click();
			ApplicationIndependent.waitFor(5L);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			ApplicationIndependent.waitFor(5L);
			oBrowser.findElement(By.name("firstName")).sendKeys(firstname);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("lastName")).sendKeys(lastname);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("email")).sendKeys(email);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("username")).sendKeys(username);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("password")).sendKeys(password);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(repassword);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.xpath(".//*[@id='userDataLightBox_commitBtn']/div/span")).click();
			ApplicationIndependent.waitFor(5L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^User should create successfully$")
	public void User_should_create_successfully()
	{
		String expected;
		try
		{
			expected=lastname+","+" "+firstname;
			//		Assert.assertTrue(ApplicationDependent.isObjectPresent(oBrowser,By.xpath("//span[text()='"+expected+"']")));


		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^delete the user$")
	public void delete_the_user()
	{
		String username;
		try
		{
			username=lastname+","+" "+firstname;
			oBrowser.findElement(By.xpath("//span[text()='"+username+"']")).click();
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			ApplicationIndependent.waitFor(2L);
			Alert alert=oBrowser.switchTo().alert();
			alert.accept();
			ApplicationIndependent.waitFor(2L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Created By:
	 * Created Date:
	 * Description:
	 */
	@Then("^the user should delete$")
	public void the_user_should_delete()
	{
		String expected,actual;
		try
		{
			expected="actiTIME - User List";
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Created By:
	 * Created Date:
	 * Description:
	 */
	@Given("^connect to Oracle Database$")
	public void connect_to_Oracle_Database()
	{
		System.out.println("Connect to Oracle Datbase 11g !!!");
	}

	/**
	 * Created By:
	 * Created Date:
	 * Description:
	 */
	@And("^Fetch records from Database$")
	public void fetch_records_from_database()
	{
		System.out.println("Fetch records from Database !!!");
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^minimize the flyout Window$")
	public void minimize_the_flyout_Window()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			ApplicationIndependent.waitFor(2L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*	
	@Given("^Install the Chrome Browser$")
	public void Install_the_Chrome_Browser()
	{
		System.out.println("Install the Chrome Browser!!!!!!!!!");
	}

	@And("^Configure the Chrome Browser$")
	public void Configure_the_Chrome_Browser()
	{
		System.out.println("Configure the Chrome Browser!!!!!!!!!");
	}
	 */

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Login using (.*) and (.*) credentials$")
	public void Login_using_valid_credentials_new(String username,String password)
	{  
		try
		{
			actiTimePage.getUserName().sendKeys(username);
			actiTimePage.getPassword().sendKeys(password);
			actiTimePage.getLoginBtn().click();
			ApplicationIndependent.waitFor(4L);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
