package TestRunner.loginSteps;import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;
public class SignUp_Step extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static String Email_Address;
	Random rad = new Random();
	String name = "" + rad.nextInt(100000) + "@gmail.com";

	// Open web site URl
	@Given("^Navigates to website url\\.$")
	public void navigates_to_website_url() throws InterruptedException {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		Thread.sleep(2000);
		try {
			webelement = driver.findElement(SignupObject.close_add);
			webelement.click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} catch (NoSuchElementException Exc) {
		}

		try {
			WebElement User_Signin = driver.findElement(By.cssSelector(".signin-link[title='Sign Out']"));
			if (User_Signin.isEnabled()) {
				User_Signin.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Exb) {

		}
	}

	@Then("^Click on Most Downloaded link\\.$")
	public void click_most_download() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Then("^Select a product items\\.$")
	public void select_product() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Select_item);
		wait.implictywait(driver);
		webelement.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Then("^Click on Download this presentation link\\.$")
	public void click_on_Download_this_presentation_link() throws InterruptedException {

		webelement = driver.findElement(SignupObject.Downloaded);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(1000);
	}

	@Then("^Click on Create an Account CTA\\.$")
	public void reate_an_Account_CTA() throws InterruptedException {
		webelement = driver.findElement(SignupObject.create);
		webelement.click();
		Thread.sleep(1500);
	}

	@Then("^Enter Email Address as \"([^\"]*)\"\\.$")
	public void enter_Email_Address_as(String email) throws Throwable {
		webelement = driver.findElement(SignupObject.Email);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(email);
		wait.implictywait(driver);
		log.info("It's entering the user email Address");
	}

	@Then("^Enter First Name as \"([^\"]*)\"\\.$")
	public void enter_First_Name_as(String Fname) throws Throwable {
		webelement = driver.findElement(SignupObject.FName);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(Fname);
		wait.implictywait(driver);
		log.info("It's entering the user First Name");
	}

	@Then("^Enter Last Name as \"([^\"]*)\"\\.$")
	public void enter_Last_Name_as(String LName) throws Throwable {
		webelement = driver.findElement(SignupObject.lastname);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(LName);
		wait.implictywait(driver);
		log.info("It's entering the user Last Name");
	}

	@Then("^Enter Password as \"([^\"]*)\"\\.$")
	public void enter_password(String pwd) throws InterruptedException {
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		webelement = driver.findElement(SignupObject.password);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(pwd);
		wait.implictywait(driver);
		log.info("It's entering the user password");
	}

	@Then("^Enter Confirm password as \"([^\"]*)\"\\.$")
	public void enter_Confirm_password_as(String Cpswd) throws Throwable {
		webelement = driver.findElement(SignupObject.Cpassword);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(Cpswd);
		wait.implictywait(driver);
		log.info("It's entering the user password");
	}

	@Then("^Enter the captcha\\.$")
	public void enter_the_captcha() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Captcha);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("23102018");
		Thread.sleep(1000);
		wait.implictywait(driver);
		log.info("It's entering the user password");
	}

	@Then("^click on Signup button\\.$")
	public void click_on_Signup_button() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SignupObject.Signup));
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(2000);

		} catch (TimeoutException e) {
		}
	}

	@Then("^Verify \"([^\"]*)\" validation message for Email Address\\.$")
	public void verify_validation_message_for_Email_Address(String Email) throws InterruptedException {

		try {

			String Email_val = driver.findElement(SignupObject.Email_AddressVal).getText();
			wait.implictywait(driver);
			Assert.assertEquals(Email, Email_val);
			wait.implictywait(driver);
			Thread.sleep(1000);
			
		} catch (NoSuchElementException nc) {
		  Object s = js.executeScript("return document.getElementById('email_address').validationMessage");
		  wait.implictywait(driver);
	        System.out.println(s);
	        wait.implictywait(driver);
	         log.info("It's getting HTML5 validation message using JS executor");
				wait.implictywait(driver);
		}


}

	@Then("^Verify \"([^\"]*)\" validation message for First Name\\.$")
	public void verify_validation_message_for_First_Name(String Fn) {
		try {
			String Fname = driver.findElement(SignupObject.FNVal).getText();
			wait.implictywait(driver);
			Assert.assertEquals(Fname, Fn);
			wait.implictywait(driver);
		} catch (NoSuchElementException FnameElment) {

		}
	}

	@Then("^Verify \"([^\"]*)\" validation message forLast Name\\.$")
	public void verify_validation_message_forLast_Name(String LastName) {
		try {
			String LName_vali = driver.findElement(SignupObject.LNVal).getText();
			wait.implictywait(driver);
			Assert.assertEquals(LName_vali, LastName);
			wait.implictywait(driver);

		} catch (NoSuchElementException LastNameElement) {

		}
	}

	@Then("^Verify \"([^\"]*)\" validation message for Password\\.$")
	public void verify_validation_message_for_password(String pwd) {
		// Write code here that turns the phrase above into concrete actions
		try {
			String password_validation = driver.findElement(SignupObject.password_errormessage).getText();
			wait.implictywait(driver);
			Assert.assertEquals(password_validation, pwd);
			wait.implictywait(driver);
		} catch (NoSuchElementException PassElement) {

		}
	}

	@Then("^Verify \"([^\"]*)\" validation message for Confirm_password\\.$")
	public void verify_validation_message_for_Confirm_password(String Cpass) {
		try {
			String CNP_validation = driver.findElement(SignupObject.repeat_errormessage).getText();
			wait.implictywait(driver);
			Assert.assertEquals(CNP_validation, Cpass);
			wait.implictywait(driver);
		} catch (NoSuchElementException ConfirmElement) {

		}
	}

	@Then("^Verify \"([^\"]*)\" message for all invalid credentials\\.$")
	public void message_for_all_invalid_credentials(String Error) {
		try {
			String Email_Reg = driver.findElement(SignupObject.Signup_errormessage).getText();
			wait.implictywait(driver);
			Assert.assertEquals(Email_Reg, Error);
			wait.implictywait(driver);
		} catch (NoSuchElementException EmailElement) {
			System.out.println("element not found");
		}
	}

	@Then("^Enter Email \"([^\"]*)\"\\.$")
	public void Enter_Email_credentials(String Newuser) {
		webelement = driver.findElement(SignupObject.Email);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		Email_Address = Newuser + name;
		webelement.sendKeys(Email_Address);
		wait.implictywait(driver);

	}

	@Given("^After signup see the price page\\.$")
	public void verify_the_price_page() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "Pricing";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		Thread.sleep(1000);
	}

	@Then("^Select price subscription\\.$")
	public void select_price_subscription() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(1000);
		List<WebElement> listings = driver.findElements(By.xpath("//*[contains(text(),' Join now ')]"));
		int randomValue = rad.nextInt(listings.size()); // Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click();
		Thread.sleep(2000);

	}

	@Then("^Verify the payment option\\.$")
	public void payement_option() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String payment_text = driver.findElement(SignupObject.payment).getText();
		String ExpectTitle = "PAYMENT INFORMATION";
		Assert.assertEquals(ExpectTitle, payment_text);
		wait.implictywait(driver);
		Thread.sleep(4000);
	}

	@Then("^Enter the coupon code\\.$")
	public void Enter_the_coupon_code() throws Throwable {

		webelement = driver.findElement(SignupObject.Enter_Coupon);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", webelement);
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("5OFF");
		wait.implictywait(driver);

	}

	@Then("^Apply the coupon code as given\\.$")
	public void apply_the_coupon_code() throws Throwable {
		webelement = driver.findElement(SignupObject.Apply_Coupon);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
	}

	@Then("^Verify the applied coupon code\\.$")
	public void applied_coupon_code() throws InterruptedException {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		String applied_code = driver.findElement(SignupObject.verify_apply_code).getText();
		System.out.println(applied_code);
		String ExpectTitle = "Discount (5OFF)";
		Assert.assertEquals(ExpectTitle, applied_code);
		Thread.sleep(1000);
	}

	@Then("^Verify the default payment option as paypal\\.$")
	public void select_the_default_payment_option_as_paypal() throws Throwable {
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

	@Then("^click on place order button\\.$")
	public void click_on_place_order_cta() throws InterruptedException {
		webelement = driver.findElement(SignupObject.place_cta);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(5000);
	}

	@Then("^Verify the paypal payement process\\.$")
	public void paypal_payement_place_process_Step() throws InterruptedException {
		Thread.sleep(4000);
		try {
			String actualTitle1 = driver.getTitle();
			wait.implictywait(driver);
			System.out.println(actualTitle1);
			String expectedTitle1 = "Billing Information - PayPal";
			wait.implictywait(driver);
			String expectedTitle2 = "PayPal Checkout";
			wait.implictywait(driver);

			if (actualTitle1.equals(expectedTitle1)) {
				Assert.assertEquals(expectedTitle1, actualTitle1);
				wait.implictywait(driver);
				Thread.sleep(3000);
				System.out.println("title does not matched");
			} else {
				Assert.assertEquals(expectedTitle2, actualTitle1);
				wait.implictywait(driver);
				System.out.println(actualTitle1);
				Thread.sleep(2000);
				Thread.sleep(3000);
				System.out.println("title matched");
			}
		} catch (NoSuchElementException PayPal) {

		}
	}

	@Then("^Select the payment option as card\\.$")
	public void card_payment() throws InterruptedException {
	
		webelement = driver.findElement(SignupObject.card_radio_button);
		webelement.click();
		Thread.sleep(1000);
		String card_text = driver.findElement(SignupObject.verify_2checkout).getText();
		System.out.println(card_text);
		String ExpectTitle = "2Checkout (Visa, Amex, Discover, JCB, Diners Club, Debit Card, PayPal)";

		Assert.assertEquals(ExpectTitle, card_text);
		Thread.sleep(1000);
	}

	@Then("^Verify the card payement page\\.$")
	public void card_page() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "2Checkout";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		System.out.println(actualTitle);
		Thread.sleep(7000);
	}

	@Then("^Navigates to website url home page\\.$")
	public void website_url_home_page() throws InterruptedException {
		driver.get("https://www.slideteam.net");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Then("^logout the application\\.$")
	public void logout_app() throws InterruptedException {
		webelement = driver.findElement(By.cssSelector(".signin-link[title='Sign Out']"));
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(1000);

	}

	@Then("^Click on My account link\\.$")
	public void my_account_link() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webelement = driver.findElement(SignupObject.MyAccount);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(3000);

	}

	@Then("^Click on delete account link\\.$")
	public void delete_account_link() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webelement = driver.findElement(SignupObject.Delete);
		wait.implictywait(driver);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);

	}

	@Then("^Click on Yes button\\.$")
	public void confirm_yes_() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webelement = driver.findElement(SignupObject.Delete_Yes);
		wait.implictywait(driver);
		webelement.click();
		Thread.sleep(5000);

	}

	@Then("^Verify the delete account confirmation message\\.$")
	public void delete_confirmation_message() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String Account_delete = driver.findElement(SignupObject.Conf_delete).getText();
		wait.implictywait(driver);
		String expecte_delete = "Your account has been deleted successfully.";
		Assert.assertEquals(expecte_delete, Account_delete);
		wait.implictywait(driver);
		Thread.sleep(2000);

	}

}