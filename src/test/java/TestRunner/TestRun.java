package TestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "." }, //tags = ("@paypal_checkout"),
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json",
				"usage:target/usage.jsonx", "junit:target/cucumber.xml" }, monochrome = true)

public class TestRun {
	@BeforeClass
	public static void beforeClass() throws Exception {
		SetupClass.before_Class();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		SetupClass.after_Class();
	}
}
