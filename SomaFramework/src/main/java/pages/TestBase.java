package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import dataProvider.ConfigFileReader;

import org.openqa.selenium.support.PageFactory;

public class TestBase {

	public static WebDriver driver = null;
//	Properties properties;
	ConfigFileReader configFileReader;

	@BeforeMethod
	@SuppressWarnings("deprecation")
	public void initiate() throws IOException {
		configFileReader = new ConfigFileReader();

		// properties = new Properties();
		String device = configFileReader.getDeviceName();
		System.out.println(device);
		String platform = configFileReader.getPlatformName();
		System.out.println(platform);
		String Version = configFileReader.getVersion();
		System.out.println(Version);
		String appPackageName = configFileReader.getAppPackageName();
		System.out.println(appPackageName);
		String appActivityName = configFileReader.getAppActivityName();
		System.out.println(appActivityName);
//		String device=prop.getDeviceName();
//		String platform=props.getDeviceName();
//		String version=props.getDeviceName();
//		String appPackageName=props.getDeviceName();
//		String appActivityName=props.getDeviceName();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", device);
		cap.setCapability("platformName", platform);
		cap.setCapability("platformVersion", Version);
		cap.setCapability("appPackage", appPackageName);
		cap.setCapability("appActivity", appActivityName);

		cap.setCapability("disableAndroidWatchers", true);
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("unicodeKeyboard", false);
		cap.setCapability("resetKeyboard", false);

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

}
