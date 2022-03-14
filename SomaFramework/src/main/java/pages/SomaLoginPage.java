package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pages.TestBase;

public class SomaLoginPage extends TestBase {
	WebDriver driver;
	Properties properties;

//	ConfigFileReader configFileReader;
	public SomaLoginPage(WebDriver driver) {
		TestBase.driver = driver;
	}

	@SuppressWarnings("deprecation")
	public void launchApp() throws IOException, InterruptedException

	{

//		configFileReader = new ConfigFileReader();
//		properties = new Properties();

		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		WebElement usernameElement = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));

		Point location = usernameElement.getLocation();
		System.out.println(location);

		usernameElement.click();
		String userName = properties.getProperty("getUserName");
		Actions a = new Actions(driver);
		a.sendKeys(userName);
		a.build().perform();
		// above code is to click on username and enter username as
		// "mahesh@xyzgmail.com"
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		WebElement passwordElement = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
		passwordElement.click();
		String userPassword = properties.getProperty("getUserPassword");
		Actions a1 = new Actions(driver);
		a1.sendKeys(userPassword);
		a1.build().perform();
		// above code is to click on password and enter password as "Password@2"
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		// WebElement loginbutton = driver.findElement(By.xpath(
		// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button"));
		WebElement loginbutton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log In\"]"));
		Thread.sleep(5000);
		loginbutton.click();
		// above code is to click on login button

	}
}