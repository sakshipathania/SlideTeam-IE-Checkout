package TestRunner;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupClass {
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static Logger log;
	public static WebElement webelement;
	public static String local_IE11browser;
	public static String local_IE11;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;

	@BeforeClass
	public static void before_Class() throws Exception {

		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("Config//config.properties"));
		AppURL = property.getProperty("App_url");
		local_IE11 = property.getProperty("local_IE11");

		// getting app URL
		AppURL = property.getProperty("App_url");
		System.out.println("Bname=====" + AppURL);

		if (property.getProperty("edge").equals("yes")) {

			WebDriverManager.edgedriver().setup();
			/*
			 * EdgeOptions options = new EdgeOptions(); options.
			 * setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"
			 * );
			 */

			//driver = new EdgeDriver(options);
			driver = new EdgeDriver();
			//driver.get("google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		}

		else {

			System.out.println("platform does not provide");
		}

	}

	@AfterClass
	public static void after_Class() {
		try {
			//driver.quit();
			Thread.sleep(2000);
		} catch (Exception closeBrowser) {

		}
	}
}
