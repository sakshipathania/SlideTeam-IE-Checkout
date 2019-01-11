package TestRunner.loginSteps;

import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import webApp.PerformAction;

public class Fbpaid_User_logout extends SetupClass {
	PerformAction wait = new PerformAction();

	@Given("^navigate to the facebook url\\.$")
	public void navigates_to_website_url() throws InterruptedException {
		
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
driver.manage().deleteAllCookies();
Thread.sleep(7000);
	
	}

	
	}