package TestRunner.loginSteps;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import ObjectRepository.LoginObject;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Login_step_definition extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^Open the website url\\.$")
	public void navigates_to_website_url() throws InterruptedException {
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
			WebElement logout=driver.findElement(By.cssSelector(".signin-link[title='Sign Out']"));
			if(logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
			}catch(NoSuchElementException Ext) {
			
			}
		}

	@Then("^click on most downloaded link\\.$")
	public void click_most_download() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(1000);
	}

	@Then("^select a product item\\.$")
	public void select_product() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Select_item);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@Then("^click on download this presentation link\\.$")
	public void click_on_Download_this_presentation_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(1000);
	}

	@Then("^Enter user email address as \"([^\"]*)\"\\.$")
	public void enter_user_email_address_as(String email) {
	
		webelement = driver.findElement(LoginObject.UserId);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(email);
		wait.implictywait(driver);
		
	
	}

	@Then("^Insert the Password \"([^\"]*)\"\\.$")
	public void enter_user_password_as(String passwd) throws Throwable {
		webelement = driver.findElement(LoginObject.userpass);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(passwd);
		wait.implictywait(driver);
		
	}

	@Then("^Click on Login button\\.$")
	public void click_on_Login_button() throws Throwable {
		webelement = driver.findElement(LoginObject.login);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@Then("^Verify uesr \"([^\"]*)\" validation message for Email Address\\.$")
	public void verify_uesr_validation_message_for_Email_Address(String email) throws Throwable {

		try {
			String Email_test = driver.findElement(LoginObject.uesremail_val).getText();
			wait.implictywait(driver);
			Assert.assertEquals(email, Email_test);
			wait.implictywait(driver);
		} catch (NoSuchElementException NSE) {

		}
	}

	@Then("^Verify user \"([^\"]*)\" validation message for Password\\.$")
	public void verify_user_validation_message_for_Password(String pawd) throws Throwable {
		try {
			String password_val = driver.findElement(LoginObject.pass_val).getText();
			wait.implictywait(driver);
			Assert.assertEquals(pawd, password_val);
			wait.implictywait(driver);
		} catch (NoSuchElementException NSEP) {

		}
	}

	@Then("^Verify user \"([^\"]*)\" message for all invalid credentials\\.$")
	public void verify_user_message_for_all_invalid_credentials(String error) throws Throwable {
		try {
			String signin_error = driver.findElement(LoginObject.error_val).getText();
			wait.implictywait(driver);
			Assert.assertEquals(error, signin_error);
			wait.implictywait(driver);
		} catch (NoSuchElementException NF) {

		}
	}

	@Then("^Enter user a email address as\\.$")

	public void enter_email_as() {
		webelement = driver.findElement(LoginObject.UserId);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("selenium.testing1234@gmail.com");
		wait.implictywait(driver);
	}

	@Then("^Enter password as\\.$")
	public void enter_paasword_as() throws InterruptedException {
		webelement = driver.findElement(LoginObject.userpass);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("123456");
		Thread.sleep(1000);
	}

	@Given("^after login redirect to price page\\.$")
	public void after_signup_redirect_to_price_page() throws Throwable {
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "Pricing";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@Then("^Select any of price subscription\\.$")
	public void select_any_of_price_subscription() throws Throwable {
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(1000);
	
		List<WebElement> listin  = driver.findElements(By.xpath("//*[contains(text(),' Join now ')]"));
		int randomValue = rad.nextInt(listin .size()); // Getting a random value that is between 0 and (list's size)-1
		Thread.sleep(1000);
		listin .get(randomValue).click();
		Thread.sleep(2000);
	}

	@Then("^Verify the payment option field\\.$")
	public void verify_the_payment_option_field() throws Throwable {
		String payment_text = driver.findElement(SignupObject.payment).getText();
		String ExpectTitle = "PAYMENT INFORMATION";
		System.out.println(payment_text);
		Assert.assertEquals(ExpectTitle, payment_text);
         Thread.sleep(1000);
	}

	@Then("^See default payment option as paypal\\.$")
	public void see_default_payment_option_as_paypal() throws Throwable {
		webelement = driver.findElement(SignupObject.paypay_radio_button);
		if (!driver.findElement(SignupObject.paypay_radio_button).isSelected())
		// to check the check box is already selected or not
		{
			driver.findElement(SignupObject.paypay_radio_button).click();
			wait.implictywait(driver);
		}

		String paypal_text = driver.findElement(SignupObject.verify_paypal_text).getText();
		String ExpectTitle = "You will be redirected to the PayPal website when you place an order.";
		Assert.assertEquals(ExpectTitle, paypal_text);
		Thread.sleep(1000);
	}

	@Then("^Enter coupon code\\.$")
	public void enter_coupon() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Enter_Coupon);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("5OFF");
		wait.implictywait(driver);
	}

	@Then("^Apply cuopon code\\.$")
	public void apply_the_cuopon_code() throws Throwable {
		webelement = driver.findElement(SignupObject.Apply_Coupon);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

	}

	@Then("^Verify applied coupon code offer\\.$")
	public void verify_the_applied_coupon_code_offer() throws Throwable {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		String applied_code = driver.findElement(SignupObject.verify_apply_code).getText();
		System.out.println(applied_code);
		String ExpectTitle = "Discount (5OFF)";
		Assert.assertEquals(ExpectTitle, applied_code);
		Thread.sleep(2000);
	}

	@Then("^click on place order CTA\\.$")
	public void click_on_place_order_CTA() throws Throwable {
		webelement = driver.findElement(SignupObject.place_cta);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(5000);
	}

	@Then("^Verify the paypal payement page\\.$")
	public void verify_the_paypal_payement_page() throws Throwable {
		Thread.sleep(4000);
		 try {
			 String actualTitle1 = driver.getTitle();
				wait.implictywait(driver);
				System.out.println(actualTitle1);
				String expectedTitle1 = "Billing Information - PayPal";
				wait.implictywait(driver);
				String expectedTitle2="PayPal Checkout";
				wait.implictywait(driver);
				
			    if(actualTitle1.equals(expectedTitle1)){
				Assert.assertEquals(expectedTitle1, actualTitle1);
				wait.implictywait(driver);
				Thread.sleep(3000);
				System.out.println("title does not matched");
	}
		 else{
				Assert.assertEquals(expectedTitle2, actualTitle1);
				wait.implictywait(driver);
				System.out.println(actualTitle1);
				Thread.sleep(3000);
				System.out.println("title matched");
		    }
		 }
		 catch (NoSuchElementException Paypalget){
	
		 }
	}
	@Then("^Select payment option as Card\\.$")
	public void select_payment_option_as_Card() throws Throwable {
		webelement = driver.findElement(SignupObject.card_radio_button);
		webelement.click();
		Thread.sleep(1000);
		String card_text = driver.findElement(SignupObject.verify_2checkout).getText();
		System.out.println(card_text);
		String ExpectTitle = "2Checkout (Visa, Amex, Discover, JCB, Diners Club, Debit Card, PayPal)";

		Assert.assertEquals(ExpectTitle, card_text);
		Thread.sleep(1000);

	}

	@Then("^Verify card payement page\\.$")
	public void card_page() throws InterruptedException {
		Thread.sleep(4000);
		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "2Checkout";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		System.out.println(actualTitle);
		Thread.sleep(2000);
	}
	
}
