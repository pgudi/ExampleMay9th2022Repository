package com.sgtesting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxProfilesDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();

	}
	
	private static void launchBrowser()
	{
		try
		{
			
			System.setProperty("webdriver.gecko.driver", ".\\Library\\drivers\\geckodriver.exe");
		/*	ProfilesIni profilesini=new ProfilesIni();
			FirefoxProfile ffprofile=profilesini.getProfile("sgtesting");
			FirefoxOptions options=new FirefoxOptions();
			options.setProfile(ffprofile);
			oBrowser=new FirefoxDriver(options);
		*/
			FirefoxProfile ffprofile=new FirefoxProfile();
			ffprofile.setPreference("browser.startup.homepage", "http://www.sgtestinginstitute.com");
			FirefoxOptions options=new FirefoxOptions();
			options.setProfile(ffprofile);
			oBrowser=new FirefoxDriver(options);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
