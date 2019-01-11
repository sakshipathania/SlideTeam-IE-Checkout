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

public class GooglePlus_signin_paid_user_stepDefinitio extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^Open home page of the application\\.$")
	public void navigates_to_website_url() throws InterruptedException {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		Thread.sleep(8000);
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

	@And("^Select style as complete ppt\\.$")
	public void click_most_download() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(1000);
		try {
			WebElement recommended=driver.findElement(By.cssSelector(".scd-assistant-cards-close>i"));
			wait.implictywait(driver);
			recommended.click();
	Thread.sleep(1000);
	} catch (NoSuchElementException recommended) {

	}
	}

	@And("^Select any project slider\\.$")
	public void select_product() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Select_item);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@And("^Click on downloadbtn test5 link\\.$")
	public void click_on_Download_this_presentation_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(2000);
	}

	@And("^Click on googlePlus link\\.$")
	public void fb_link() throws InterruptedException {
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		webelement = driver.findElement(FbandGP_Object.GooglePlusLink);
		webelement.click();
		Thread.sleep(2000);
	}

	@Then("^Enter user google email addess\\.$")
	public void enter_user_mail() throws InterruptedException  {
		webelement = driver.findElement(FbandGP_Object.GPEmail);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("selenium_testing@slidetech.in");
		wait.implictywait(driver);
		Thread.sleep(2000);
		
			
		
	}

	@Then("^go to password page\\.$")
	public void enter_user_password() throws InterruptedException  {
	
		webelement = driver.findElement(FbandGP_Object.Next_cta);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(5000);

	
	}

	 @Then("^Enter user google pass\\.$")
	public void google_pass() throws InterruptedException {
		 	 webelement = driver.findElement(FbandGP_Object.GPpass);
				webelement.click();
				wait.implictywait(driver);
				webelement.clear();
				wait.implictywait(driver);
				webelement.sendKeys("slideteam");
				wait.implictywait(driver);
				Thread.sleep(2000);
			

			
		}
	
	@Then("^Click on next CTA\\.$")
	public void click_on_Login_button() throws Throwable {

		webelement = driver.findElement(FbandGP_Object.Next_button);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(4000);

		try {
			WebElement close = driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
			wait.implictywait(driver);
			close.click();
			Thread.sleep(500);
		} catch (NoSuchElementException nonpoptest) {

		}

	}

	@Then("^The Page is redirect to download presenetion link\\.$")
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
