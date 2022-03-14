package dataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader

{
	Properties properties;
	private final String propertyFilePath = "C:/Users/mahesh.SKYCLIFFIT/eclipse-workspace/SomaFramework/src/main/java/propertiesFile/Global.properties";

	public ConfigFileReader() throws IOException {

		{
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
		}
	}

	public String getDeviceName() {

		String device = properties.getProperty("deviceName");
		if (device != null)
			return device;
		else
			throw new RuntimeException("device not specified in the Configuration.properties file.");

//	String device = properties.getProperty("device");
//	System.out.println(device);
//	return device;
	}

	public String getPlatformName() {

		String platform = properties.getProperty("platformName");
		if (platform != null)
			return platform;
		else
			throw new RuntimeException("platform not specified in the Configuration.properties file.");
	}

	public String getVersion() {

		String Version = properties.getProperty("platformVersion");
		if (Version != null)
			return Version;
		else
			throw new RuntimeException("Version not specified in the Configuration.properties file.");
	}

	public String getAppPackageName() {
		String appPackageName = properties.getProperty("appPackage");
		if (appPackageName != null)
			return appPackageName;
		else
			throw new RuntimeException("appPackageName not specified in the Configuration.properties file.");
	}

	public String getAppActivityName() {

		String appActivityName = properties.getProperty("appActivity");
		if (appActivityName != null)
			return appActivityName;
		else
			throw new RuntimeException("appActivityName not specified in the Configuration.properties file.");
	}

	public String getUserName() {

		String user = properties.getProperty("userName");
		if (user != null)
			return user;
		else
			throw new RuntimeException("user not specified in the Configuration.properties file.");
	}

	public String getUserPassword() {

		String Password = properties.getProperty("userPassword");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file.");
	}

}
