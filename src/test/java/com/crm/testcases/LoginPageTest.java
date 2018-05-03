package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	 LoginPage loginPage;
	 HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 2)
	public void titleTest() {
		String title = loginPage.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
	}
	
	@Test(priority = 1)
	public void verifyFreeCRMLogoTest() {
		boolean logo = loginPage.verifyLogo();
		Assert.assertTrue(logo);
	}
	

	@Test(priority = 3)
	public void verifyLoginTest() {
		try {
		 homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(homePage.getTitle(), "CRMPRO");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
