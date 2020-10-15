package TestRunner.loginSteps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import TestRunner.SetupClass;


	public class TakeImageStep extends SetupClass {
		String filePath = "C:\\SCREENSHOTS";
		
		@After
		
		public void tearDown(Scenario scenario) {
			
		    if (scenario.isFailed()) {	    	
		      log.info("Scenario failed, now taking screenshot");
		      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filePath+".png"));
			System.out.println("***Placed screen shot in "+filePath+" ***");
	
			}
		    }
		}
	
