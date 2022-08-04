package com.sgtesting.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimePage {

	public ActiTimePage(WebDriver oBrowser)
	{
		PageFactory.initElements(oBrowser, this);
	}

	//WebElement for Login Page UserName text field
	private WebElement username;
	public WebElement getUsername() {
		return username;
	}

	//WebElement for Login Page Password text field
	private WebElement pwd;
	public WebElement getPwd() {
		return pwd;
	}

	//WebElement for Login Page Login button field
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement oLogin;
	public WebElement getoLogin() {
		return oLogin;
	}

	//WebElement for Home Page Flyout Window 
	private WebElement gettingStartedShortcutsPanelId;
	public WebElement getGettingStartedShortcutsPanelId() {
		return gettingStartedShortcutsPanelId;
	}

	//WebElement for Home Page Logout link
	@FindBy(linkText="Logout")
	private WebElement oLogout;
	public WebElement getoLogout() {
		return oLogout;
	}
}
