package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	Actions action;
	WebDriverWait wait;
	//Page Factory - OR:
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
		WebElement forgotPassword;
		
		@FindBy(xpath="//img[@class='img-responsive' and @alt = 'free crm logo']")
		WebElement freeCRMLogo;
		
		//Constructor
		public LoginPage() {
			PageFactory.initElements(driver, this);
			action = new Actions(driver);
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(username));
			
		}
		
		public String verifyTitle() {
			return driver.getTitle();
			
		}
		
		public HomePage login(String un, String pw) {
//			action = new Actions(driver);
			wait.until(ExpectedConditions.elementToBeClickable(username));
//			wait.until(ExpectedConditions.stalenessOf(username));
//			wait.until(ExpectedConditions.presenceOfElementLocated(username)).click();
			action.moveToElement(username).click().sendKeys(un).build().perform();
			action.moveToElement(password).click().sendKeys(pw).build().perform();
			action.moveToElement(loginBtn).click().build().perform();
//			username.sendKeys(un);
//			password.sendKeys(pw);
//			loginBtn.click();
			return new HomePage();
			
		}
		
		public boolean verifyForgotPassword() {
			return forgotPassword.isDisplayed();
		}
		
		public boolean verifyLogo() {
			return freeCRMLogo.isDisplayed();
		}

}
