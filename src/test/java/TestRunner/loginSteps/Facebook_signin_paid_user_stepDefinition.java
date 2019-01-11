package TestRunner.loginSteps;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import ObjectRepository.FbandGP_Object;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Facebook_signin_paid_user_stepDefinition extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^Open given the application URL$")
	public void navigates_to_website_url() throws InterruptedException  {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		Thread.sleep(2000);
		try {
			webelement = driver.findElement(SignupObject.close_add);
			webelement.click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} catch (NoSuchElementException popup) {
		}

		try {
			WebElement logout = driver.findElement(By.cssSelector(".signin-link[title='Sign Out']"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	}

	@And("^go to Complete ppts$")
	public void click_most_download() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	
	}

	@And("^product as Project Scoping Powerpoint$")
	public void select_product() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Select_item);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@And("^Click on download this presentation$")
	public void click_on_Download_thist_presentation_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(1000);
	}

	@And("^Click on test fblink$")
	public void fb_link() throws InterruptedException {
		webelement = driver.findElement(FbandGP_Object.fbLink);
		webelement.click();
		Thread.sleep(1000);
	}

	@Then("^user email as$")
	public void enter_user_mail() throws InterruptedException {
		
		try {
		webelement = driver.findElement(FbandGP_Object.Femai);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("sumit.kumar@slidetech.in");
		wait.implictywait(driver);

		} catch (NoSuchElementException nonemaillink) {

		}}

	@Then("^user password as$")
	public void enter_user_password() throws Throwable {
		try {
		webelement = driver.findElement(FbandGP_Object.Fpassword);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("redhat2090");
		wait.implictywait(driver);

	
} catch (NoSuchElementException password) {

}}

	@Then("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		try {
		webelement = driver.findElement(FbandGP_Object.FbLogin);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
		} catch (NoSuchElementException logincta) {
			
		}
		try {
			webelement = driver.findElement(FbandGP_Object.continue_as_QA);
			webelement.click();
			Thread.sleep(1000);
		} catch (NoSuchElementException qalink) {

		}
		try {
			WebElement close = driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
			wait.implictywait(driver);
			close.click();
			Thread.sleep(500);
		} catch (NoSuchElementException nonpoptest) {

		}
		

	}
	@Then("^See the this link as download this presenetion link is appeared$")
	public void verify_uesr_validation_message_for_Email_Address() throws Throwable {

		try {
			String Email_test = driver.findElement(SignupObject.Downloaded).getText();
			wait.implictywait(driver);
			String Expected_Cta = "Download this presentation";
			Assert.assertEquals(Expected_Cta, Email_test);
			wait.implictywait(driver);
			Thread.sleep(1000);
		} catch (NoSuchElementException er1) {

		}
	}

}

