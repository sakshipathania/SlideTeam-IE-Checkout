package TestRunner.loginSteps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import TestRunner.SetupClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;


	public class TakeImageStep extends SetupClass {
		String filePath = "C:\\SCREENSHOTS";
		@After
		public void tearDown(Scenario scenario) {
			System.out.println("***** Error "+result.getName()+" test has failed *****");
    	        String methodName=result.getName().toString().trim();
               ITestContext context = result.getTestContext();
               WebDriver driver = (WebDriver)context.getAttribute("driver");
    	       takeScreenShot(methodName, driver);
		    if (scenario.isFailed()) {	    	
		      log.info("Scenario failed, now taking screenshot");
		      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
			    
		      //scenario.embed(screenshot, "image/png");
		    }
		}
	}
