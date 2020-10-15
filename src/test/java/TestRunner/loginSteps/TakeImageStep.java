package TestRunner.loginSteps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestRunner.SetupClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;


	public class TakeImageStep extends SetupClass {
	WebDriver driver=null;
	String filePath = "C:\\SCREENSHOTS";
    @Override
    @Given("^onTestFailure")
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
       WebDriver driver = (WebDriver)context.getAttribute("driver");
    	takeScreenShot(methodName, driver);
    }
    @Then("^takeScreenShot")
    public void takeScreenShot(String methodName, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

