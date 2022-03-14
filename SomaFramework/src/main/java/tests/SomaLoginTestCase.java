package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pages.SomaLoginPage;
import pages.TestBase;

public class SomaLoginTestCase extends TestBase {
	public static WebDriver driver;

//	ConfigFileReader configFileReader;

	@Test(priority = 0, enabled = false)
	public void launch() throws InterruptedException, IOException {
		TestBase SomaLoginPage1 = PageFactory.initElements(driver, TestBase.class);
		SomaLoginPage1.initiate();

	}

	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {
		SomaLoginPage SomaLoginPage2 = PageFactory.initElements(driver, SomaLoginPage.class);
		SomaLoginPage2.launchApp();

	}
}
