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

public class Facebook_create_sigin_unpaid_stepDefin extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl

	@Given("^Launching the application URL\\.$")
	public void launching_the_application_URL() throws InterruptedException {
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

	@And("^Select product list as Complete ppts\\.$")
	public void select_product_list_as_Complete_ppts() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(1000);
	}

	@And("^On the Scoping Powerpoint product\\.$")
	public void on_the_Scoping_Powerpoint_product() throws InterruptedException {
	
		webelement = driver.findElement(SignupObject.Select_item);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@And("^Open the download presentation link\\.$")
	public void open_the_download_presentation_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(1000);
	}

	@And("^Click on create as account link\\.$")
	public void click_on_create_as_account_link() throws InterruptedException {
		webelement = driver.findElement(SignupObject.create);
		webelement.click();
		Thread.sleep(1500);
	}

	@And("^Click on faceblink\\.$")
	public void click_on_faceblink() throws InterruptedException {
		webelement = driver.findElement(FbandGP_Object.fbLink);
		webelement.click();
		Thread.sleep(1000);
	}

	@Then("^Fb user enter a valid email\\.$")
	public void fb_user_enter_a_valid_email() throws InterruptedException {
		webelement = driver.findElement(FbandGP_Object.Femai);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("amw.vrushali@gmail.com");
		wait.implictywait(driver);

	}

	@Then("^Fb user enter valid password\\.$")
	public void fb_user_enter_valid_password() throws Throwable {
		webelement = driver.findElement(FbandGP_Object.Fpassword);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("vrushali@786");
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@Then("^click on login cta on fb page\\.$")
	public void click_on_login_cta_on_fb_page() throws InterruptedException {
		webelement = driver.findElement(FbandGP_Object.FbLogin);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(10000);
		try {
			webelement = driver.findElement(FbandGP_Object.continue_as_QA);
			webelement.click();
			Thread.sleep(1000);
		} catch (NoSuchElementException qalink) {

		}
	}

	@Then("^The user is redirected to price page\\.$")
	public void the_user_is_redirected_to_price_page() throws Throwable {
		Thread.sleep(1000);
		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "Pricing";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		Thread.sleep(2000);
		
	}
	@Then("^the randamly the subscription product\\.$")
	public void the_randamly_the_subscription_product() throws Throwable {
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(1000);
	
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),' Join now ')]"));
		int randomValue = rad.nextInt(list.size()); // Getting a random value that is between 0 and (list's size)-1
		Thread.sleep(1000);
		list.get(randomValue).click();
		Thread.sleep(2000);
		
	}

	@Then("^Verify the payement section on the app\\.$")
	public void verify_the_payement_section_on_the_app() throws Throwable {
		String payment_text = driver.findElement(SignupObject.payment).getText();
		String ExpectTitle = "PAYMENT INFORMATION";
		System.out.println(payment_text);
		Assert.assertEquals(ExpectTitle, payment_text);
		Thread.sleep(1000);
	}

	@Then("^By default payment option as paypal is selected\\.$")
	public void by_default_payment_option_as_paypal_is_selected() throws Throwable {
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

	@Then("^Enter the the offer code is off is showing\\.$")
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

	@Then("^Apply the code\\.$")
	public void apply_the_cuopon_code() throws Throwable {
		webelement = driver.findElement(SignupObject.Apply_Coupon);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

	}

	@Then("^Verify the apply offer code is appeared\\.$")
	public void verify_the_applied_coupon_code_offer() throws Throwable {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		String applied_code = driver.findElement(SignupObject.verify_apply_code).getText();
		System.out.println(applied_code);
		String ExpectTitle = "Discount (5OFF)";
		Assert.assertEquals(ExpectTitle, applied_code);
		Thread.sleep(1000);
	}

	@Then("^Place order the product\\.$")
	public void click_on_place_order_CTA() throws Throwable {
		webelement = driver.findElement(SignupObject.place_cta);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(5000);
	}

	@Then("^Verify the payment page\\.$")
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
		 catch (NoSuchElementException checkPaypalget){
	
		 }
	}
	@Then("^Select the payment option as CARD is given\\.$")
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

	@Then("^Verify the payment option as on card page\\.$")
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
