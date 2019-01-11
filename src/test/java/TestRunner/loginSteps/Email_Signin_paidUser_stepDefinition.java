package TestRunner.loginSteps;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.LoginObject;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Email_Signin_paidUser_stepDefinition extends SetupClass {

	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^Open application URL$")
	public void navigates_to_website_url() throws InterruptedException {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		Thread.sleep(5000);
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

	@Then("^Click on Complete ppts$")
	public void click_most_download() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignupObject.Most));
		webelement = driver.findElement(SignupObject.Most);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webelement.click();
		Thread.sleep(1000);
		try {
			WebElement recommended=driver.findElement(By.cssSelector(".scd-assistant-cards-close>i"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			recommended.click();
	Thread.sleep(2000);
	} catch (NoSuchElementException recomm) {

	}
	}
	

	@Then("^Select a product as Project Scoping Powerpoint$")
	public void select_product() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignupObject.Select_item));
		WebElement et = driver.findElement(SignupObject.Select_item);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		et.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	@Then("^Click on download this presentation link$")
	public void click_on_Download_this_presentation_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(8000);
	}
	@Then ("^chat window option\\.$")
	public void close_chat_window() throws InterruptedException {
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}
			}	

	@Then("^Enter a user email$")
	public void enter_user_email_address_as() {

		webelement = driver.findElement(LoginObject.UserId);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("sumit@slideteam.net");
		wait.implictywait(driver);

	}

	@Then("^Enter the user password$")
	public void enter_user_password_as() throws Throwable {
		webelement = driver.findElement(LoginObject.userpass);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("sumittest@21234");
		wait.implictywait(driver);

	}

	@Then("^click on Login cta$")
	public void click_on_Login_button() throws Throwable {
		webelement = driver.findElement(LoginObject.login);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);

		try {
			WebElement close = driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
			wait.implictywait(driver);
			close.click();
			Thread.sleep(500);
		} catch (NoSuchElementException nonpop) {

		}
	}

	@Then("^the download this presenetion link is appeared$")
	public void verify_uesr_validation_message_for_Email_Address() throws Throwable {

		try {
			String Email_test = driver.findElement(SignupObject.Downloaded).getText();
			wait.implictywait(driver);
			String Expected_Cta = "Download this presentation";
			Assert.assertEquals(Expected_Cta, Email_test);
			wait.implictywait(driver);
			Thread.sleep(1000);
		} catch (NoSuchElementException er) {

		}
	}

}

