package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyTitleTest() {
		String title = homePage.getTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test
	public void verifyLoggedInUserTest() {
		String user = homePage.getloggedUser();
		System.out.println(user.substring(6)+" : "+user);
		Assert.assertEquals(user.substring(6), "Pras Men");
	}
	
	@Test
	public void verifyHomeLinkPresentTest() {
		boolean homeLink = homePage.getHomeLink();
		Assert.assertTrue(homeLink);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
