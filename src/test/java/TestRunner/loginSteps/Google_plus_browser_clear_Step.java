package TestRunner.loginSteps;

import TestRunner.SetupClass;
import cucumber.api.java.en.Given;

public class Google_plus_browser_clear_Step extends SetupClass {
	@Given("^open the google plus page\\.$")
	public void navigates_to_website_url() throws InterruptedException {
		
		driver.get("https://mail.google.com");
		Thread.sleep(5000);
driver.manage().deleteAllCookies();
Thread.sleep(8000);
	
	}

	
	
}
