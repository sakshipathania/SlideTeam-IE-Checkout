package TestRunner.loginSteps;

import java.util.List;
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

public class Google_plus_create_unpaid_defination extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^launch application\\.$")
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

	@And("^the product list as Complete ppts\\.$")
	public void click_most_download() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(1000);
	}

	@And("^Project list as Scoping Powerpoint product\\.$")
	public void select_product() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Select_item);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@And("^go to download link\\.$")
	public void click_on_Download_this_presentation_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(2000);
	}

	@And("^Click on Create account cta\\.")
	public void create_accuont() throws InterruptedException {
		webelement = driver.findElement(SignupObject.create);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(2000);
	}

	@And("^then click on Google plus link button\\.$")
	public void fb_link() throws InterruptedException {
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(500);
		webelement = driver.findElement(FbandGP_Object.GooglePlusLink);
		webelement.click();
		Thread.sleep(3000);
	}

	@Then("^enter a email\\.$")
	public void enter_user_mail() throws InterruptedException {
		try {
			WebElement useaccount=driver.findElement(By.xpath("//*[text()='Use another account']"));
			wait.implictywait(driver);
			useaccount.click();
			Thread.sleep(2000);
		}catch(NoSuchElementException usenewaccount) {	
	}
	
	try {
		webelement = driver.findElement(FbandGP_Object.GPEmail);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("selenium.testing9977@gmail.com");
		wait.implictywait(driver);
		Thread.sleep(2000);
	}catch(NoSuchElementException usenewa) {	
	}
	}
	@Then("^Go to next page\\.$")
	public void password_page() throws InterruptedException {

		webelement = driver.findElement(FbandGP_Object.Next_cta);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(3000);

	}

	@Then("^enter password\\.$")
	public void enter_user_password() throws Throwable {
		webelement = driver.findElement(FbandGP_Object.GPpass);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("Test@1234");
		wait.implictywait(driver);
		Thread.sleep(3000);
	}

	@Then("^Click on next button\\.$")
	public void click_on_Login_button() throws Throwable {
		webelement = driver.findElement(FbandGP_Object.Next_button);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(10000);

	}

	@Then("^Redirected to price page\\.$")
	public void after_signup_redirect_to_price_page() throws Throwable {

		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "Pricing";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);

	}

	@Then("^Subscribe randomly the product\\.$")
	public void select_any_of_price_subscription() throws Throwable {
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),' Join now ')]"));
		int randomValue = rad.nextInt(list.size()); // Getting a random value that is between 0 and (list's size)-1
		Thread.sleep(1000);
		list.get(randomValue).click();
		Thread.sleep(2000);
	}

	@Then("^the payment information is verify\\.$")
	public void verify_the_payment_option_field() throws Throwable {
		String payment_text = driver.findElement(SignupObject.payment).getText();
		String ExpectTitle = "PAYMENT INFORMATION";
		System.out.println(payment_text);
		Assert.assertEquals(ExpectTitle, payment_text);
		Thread.sleep(1000);
	}

	@Then("^then default payment option is paypal\\.$")
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

	@Then("^insert coupon as display in screen\\.$")
	public void enter_coupon() {
		webelement = driver.findElement(SignupObject.Enter_Coupon);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("5OFF");
		wait.implictywait(driver);
	}

	@Then("^apply coupon cta\\.$")
	public void apply_the_cuopon_code() throws Throwable {
		webelement = driver.findElement(SignupObject.Apply_Coupon);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

	}

	@Then("^Verify the apply coupon code text is appeared\\.$")
	public void verify_the_applied_coupon_code_offer() throws Throwable {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		String applied_code = driver.findElement(SignupObject.verify_apply_code).getText();
		System.out.println(applied_code);
		String ExpectTitle = "Discount (5OFF)";
		Assert.assertEquals(ExpectTitle, applied_code);
		Thread.sleep(1000);
	}

	@Then("^Go to checkout payement process page\\.$")
	public void click_on_place_order_CTA() throws Throwable {
		webelement = driver.findElement(SignupObject.place_cta);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(5000);
	}

	@Then("^Verify the payment screen is paypal is dispalyed\\.$")
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
				System.out.println(actualTitle1);
				Thread.sleep(3000);
				System.out.println("title does not matched");
	}
		 else{
				Assert.assertEquals(expectedTitle2, actualTitle1);
				wait.implictywait(driver);
				Thread.sleep(3000);
				System.out.println("title matched");
		    }
		 }
		 catch (NoSuchElementException checkPaypalpayement){
	
		 }
	}

	@Then("^Click on card radio button\\.$")
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

	@Then("^Verify the payment page is secure card 2checkout title\\.$")
	public void card_page() throws InterruptedException {
		Thread.sleep(4000);
		String actualTitle = driver.getTitle();
		Thread.sleep(1000);
		wait.implictywait(driver);
		String expectedTitle = "2Checkout";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		System.out.println(actualTitle);
		Thread.sleep(2000);
	}

}
