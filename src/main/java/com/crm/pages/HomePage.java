package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		}
		//Page Factory - OR:
			@FindBy(name="username")
			WebElement title;//
			
			@FindBy(xpath="//td[contains(text(),'User: Pras Men')]")
			WebElement loggedUser;
			
			@FindBy(xpath="//a[contains(text(),'Contacts')]")
			WebElement contacts;
			
			@FindBy(xpath="//a[contains(text(),'Home')]")
			WebElement homeLink;
			
			
			
			public String getTitle() {
				return driver.getTitle();
			}
			
			public String getloggedUser() {
				System.out.println(loggedUser.getText());
				return loggedUser.getText();
			}
			
			public boolean getHomeLink() {
				return homeLink.isDisplayed();
			}

}
