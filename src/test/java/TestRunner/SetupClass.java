package TestRunner;

import java.io.FileReader;

import java.util.Properties;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetupClass {
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static Logger log;
	public static WebElement webelement;
	public static String local_IE11browser;
	public static String local_IE11;

	@BeforeClass
	public static void before_Class() throws Exception {

		log = Logger.getLogger(BeforeClass.class.getName());

		property.load(new FileReader(
				"C:\\Users\\Administrator\\eclipse-workspace\\AutoSlideTeam_IE11Browser\\src\\main\\resources\\configure.properties"));
		AppURL = property.getProperty("App_url");
		local_IE11 = property.getProperty("local_IE11");

		// getting app URL
		AppURL = property.getProperty("App_url");
		System.out.println("Bname=====" + AppURL);

		// if (browser.equalsIgnoreCase("IE11"))
		if ((local_IE11.equals("yes"))) {
			/*** To run desktop project on local */
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents",false);
			driver = new InternetExplorerDriver(caps);
		} else {
			System.out.println("IE11 browser does not open");
		}

	}

	@AfterClass
	public static void after_Class() {
		try {
			driver.quit();
			Thread.sleep(2000);
		} catch (Exception closeBrowser) {

		}
	}
}
