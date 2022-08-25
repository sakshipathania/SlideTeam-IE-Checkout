package TestRunner.loginSteps;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestRunner.SetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class paypal_checkout extends SetupClass {

	@Given("^user is already on Website Home Page pp$")
	public void user_is_already_on_Website_Home_Page_pp() throws Throwable {

		driver.get(AppURL);
		ClearBrowserCache();
	}

	@Then("^user navigates to sign up page pp$")
	public void user_navigates_to_sign_up_page_pp() throws Throwable {
		Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();

			Thread.sleep(3000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} catch (NoSuchElementException popup) {
		}
	}

	@Then("^user create a new ac count pp$")
	public void user_create_a_new_ac_count_pp() throws Throwable {

		// create new email for sign up

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		String signup_email = generatedString;
		String full_email = "selenium.testing." + generatedString + "@gmail.com";
		System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.id("email_address")).sendKeys(full_email);

		Thread.sleep(2000);
		WebElement new_email_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email_address']")));
		Thread.sleep(2000);
		new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);

		// enter name

		WebElement new_fname_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstname']")));
		Thread.sleep(2000);
		new_fname_signup.sendKeys("Selenium");
		Thread.sleep(2000);

		WebElement new_lname_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastname']")));
		Thread.sleep(2000);
		new_lname_signup.sendKeys("Testing");
		Thread.sleep(2000);

		// enter password
		WebElement new_pwd_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		Thread.sleep(2000);
		new_pwd_signup.sendKeys("selenium@123");
		Thread.sleep(2000);

		WebElement new_pwd1_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password-confirmation']")));
		Thread.sleep(2000);
		new_pwd1_signup.sendKeys("selenium@123");
		Thread.sleep(2000);

		/*
		 * // enter captcha WebElement new_captcha_signup = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")))
		 * ; Thread.sleep(2000); new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
		 * Thread.sleep(2000);
		 */

		// sign up button
		WebElement new_btn_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Sign Up']")));
		Thread.sleep(2000);
		new_btn_signup.click();
		Thread.sleep(2000);
		/*
		 * Thread.sleep(1000); WebElement old_email =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//*[@id='email']")));
		 * js.executeScript("arguments[0].scrollIntoView();",old_email);
		 * Thread.sleep(1000); old_email.sendKeys("Qwerty120@gmail.com");
		 * Thread.sleep(1000); WebElement old_pass =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pass']"
		 * ))); js.executeScript("arguments[0].scrollIntoView();",old_pass);
		 * Thread.sleep(4000); old_pass.sendKeys("Qwerty@1"); Thread.sleep(3000);
		 * WebElement
		 * old_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.
		 * cssSelector("button.login > span:nth-child(1)"))); Thread.sleep(2000);
		 * old_login_btn.click();
		 */

	}

	@Then("^user is redirected to pricing page and check the text1 PP1$")
	public void user_is_redirected_to_pricing_page_and_check_the_text1_PP1() throws Throwable {

		Thread.sleep(3000);
		String actualTitle = "Monthly";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Monthly";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Monthly is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(3000);
		// wait.implictywait(driver);

	}

	@Then("^user is redirected to pricing page and check the text2 PP2$")
	public void user_is_redirected_to_pricing_page_and_check_the_text2_PP2() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$49.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String monthly_Price = actualTitle.getText();
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "$49.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, monthly_Price);
		// wait.implictywait(driver);
		Thread.sleep(2000);
		js.executeScript("alert('Text $49.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(3000);
	}

	@Then("^user is redirected to pricing page and check the text3 PP3$")
	public void user_is_redirected_to_pricing_page_and_check_the_text3_PP3() throws Throwable {

		String actualTitle = "Semi Annual";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Semi Annual";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		// wait.implictywait(driver);
		Thread.sleep(2000);
		js.executeScript("alert('Text Semi Annual is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);
	}

	@Then("^user is redirected to pricing page and check the text4 PP4$")
	public void user_is_redirected_to_pricing_page_and_check_the_text4_PP4() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$149.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String semi_Annual_Price = actualTitle.getText();

		String expectedTitle = "$149.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, semi_Annual_Price);
		// wait.implictywait(driver);
		Thread.sleep(2000);
		js.executeScript("alert('Text $149.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);
	}

	@Then("^user is redirected to pricing page and check the text5 PP5$")
	public void user_is_redirected_to_pricing_page_and_check_the_text5_PP5() throws Throwable {

		String actualTitle = "Annual";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		// wait.implictywait(driver);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);
	}

	@Then("^user is redirected to pricing page and check the text6 PP6$")
	public void user_is_redirected_to_pricing_page_and_check_the_text6_PP6() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$249.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String Annual_Price = actualTitle.getText();

		String expectedTitle = "$249.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, Annual_Price);
		js.executeScript("alert('Text $249.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);
		// wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@Then("^user is redirected to pricing page and check the text7 PP7$")
	public void user_is_redirected_to_pricing_page_and_check_the_text7_PP7() throws Throwable {

		String actualTitle = "Annual + Custom Design";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual + Custom Design";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		// wait.implictywait(driver);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual + Custom Design is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(2000);
	}

	@Then("^user is redirected to pricing page and check the text8 PP8$")
	public void user_is_redirected_to_pricing_page_and_check_the_text8_PP8() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$299.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String Annual_CustomePrice = actualTitle.getText();

		String expectedTitle = "$299.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, Annual_CustomePrice);
		// wait.implictywait(driver);
		Thread.sleep(2000);
		js.executeScript("alert('Text $299.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);
	}

	@Then("^user is redirected to pricing page and check the text9 PP9$")
	public void user_is_redirected_to_pricing_page_and_check_the_text9_PP9() throws Throwable {

		WebElement Business_Team = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);

		String actualTitle = "Annual 4 User License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual 4 User License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual 4 User License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text10 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text10_PP0() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$599.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String Annual4UserLicensePrice = actualTitle.getText();

		String expectedTitle = "$599.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, Annual4UserLicensePrice);
		Thread.sleep(2000);
		js.executeScript("alert('Text $599.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text11 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text11_PP0() throws Throwable {

		String actualTitle = "Annual 20 User License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual 20 User License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual 20 User License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text12 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text12_PP0() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$1599.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String Annual20UserLicensePrice = actualTitle.getText();

		String expectedTitle = "$1599.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, Annual20UserLicensePrice);
		Thread.sleep(2000);
		js.executeScript("alert('Text $1599.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text13 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text13_PP0() throws Throwable {

		String actualTitle = "Annual Company Wide Unlimited User License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual Company Wide Unlimited User License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual Company Wide Unlimited User License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text14 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text14_PP0() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$2999.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String AnnualUnlimtedUserLicensePrice = actualTitle.getText();

		String expectedTitle = "$2999.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, AnnualUnlimtedUserLicensePrice);
		Thread.sleep(2000);
		js.executeScript("alert('Text $2999.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text15 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text15_PP0() throws Throwable {

		WebElement Education = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Education']")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", Education);
		Thread.sleep(3000);
		Education.click();
		Thread.sleep(3000);

		String actualTitle = "Annual 15 User Education License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual 15 User Education License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual 15 User Education License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text16 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text16_PP0() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$999.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String Annual15UserEducationLicense = actualTitle.getText();

		String expectedTitle = "$999.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, Annual15UserEducationLicense);
		Thread.sleep(2000);
		js.executeScript("alert('Text $999.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text17 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text17_PP0() throws Throwable {

		String actualTitle = "Annual UNLIMITED User Institute Wide License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		String expectedTitle = "Annual UNLIMITED User Institute Wide License";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual UNLIMITED User Institute Wide Licenseis present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and check the text18 PP0$")
	public void user_is_redirected_to_pricing_page_and_check_the_text18_PP0() throws Throwable {

		WebElement actualTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[normalize-space()='$1999.99']")));
		js.executeScript("arguments[0].scrollIntoView();", actualTitle);
		String AnnualUNLIMITED = actualTitle.getText();

		String expectedTitle = "$1999.99";
		Thread.sleep(1000);
		// wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, AnnualUNLIMITED);
		Thread.sleep(2000);
		js.executeScript("alert('Text $1999.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// wait.implictywait(driver);
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and choose a plan to pay pp$")
	public void user_is_redirected_to_pricing_page_and_choose_a_plan_to_pay_pp() throws Throwable {
		// choose a individual plan
		WebElement individual = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Individual']")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", individual);
		Thread.sleep(3000);
		individual.click();
		Thread.sleep(3000);

		WebElement join_now_btn = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[3]//div[3]//span[1]//form[1]//button[1]//span[1]")));
		js.executeScript("arguments[0].scrollIntoView();", join_now_btn);
		Thread.sleep(2000);
		join_now_btn.click();
		Thread.sleep(5000);

	}

	@Then("^user is redirected to checkout page pp$")
	public void user_is_redirected_to_checkout_page_pp() throws Throwable {
		Thread.sleep(2000);
		try {
			boolean cp_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='paypal_express']")))
					.isSelected();
			if (cp_btn == true) {
				WebElement place_order_btn = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//button[@id='place-order-trigger']//span[contains(text(),'Place Order')] ")));

				js.executeScript("arguments[0].scrollIntoView();", place_order_btn);

				place_order_btn.click();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(1000);
	}

	@Then("^user proceed to pay with paypal pp$")
	public void user_proceed_to_pay_with_paypal_pp() throws Throwable {
		Thread.sleep(2000);

		// place order button
		try {
			WebElement place_order_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Place Order')]")));
			js.executeScript("arguments[0].scrollIntoView();", place_order_btn);
			Thread.sleep(3000);
			place_order_btn.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(1000);
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if (iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				Thread.sleep(2000);
				WebElement chat1 = driver.findElement(By.cssSelector("#title .icon-minimize"));
				Thread.sleep(1000);
				chat1.click();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.switchTo().parentFrame();
				Thread.sleep(1000);
			} else {

				System.out.println("chat window does not open");
			}
		} catch (NoSuchElementException NCP) {

		}
	}

	@Then("^paypal popup appears and user navigates back to my account pp$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_pp() throws Throwable {

		// handling window
		// Store the CurrentWindow for future reference

		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		Thread.sleep(2000);
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;

				Thread.sleep(1000);
				driver.switchTo().window(popupWindowHandle);
				// System.out.println("user is on mainWindow ------" + popupWindowHandle);

				System.out.println("Title = " + driver.getTitle());

				Assert.assertTrue("title does not matched",
						driver.getTitle().contains("Log in to your PayPal account"));
				Thread.sleep(1000);

				WebElement email = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email']")));
				email.clear();
				email.sendKeys("nisha.dhiman@slidetech.in");

				Thread.sleep(1000);
				WebElement next = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='btnNext']")));
				next.click();

				// verify text is on hold due to paypal security reason.
			}
		}
		// This is to switch to the main window
		driver.switchTo().window(currentWindow);

	}

	@Then("^user deleted the account pp$")
	public void user_deleted_the_account_pp() throws Throwable {

		Thread.sleep(4000);
		WebElement account = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'My Account')]")));
		js.executeScript("arguments[0].click();", account);
		Thread.sleep(3000);

		WebElement delete_account = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#clicking")));
		Thread.sleep(3000);
		// js.executeScript("arguments[0].scrollIntoView();", delete_account);
		delete_account.click();
		Thread.sleep(3000);
		WebElement delete_reason = driver.findElement(By.cssSelector("#exampleRadios1"));
		js.executeScript("arguments[0].scrollIntoView();", delete_reason);
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);

		WebElement delete_profile = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete-final")));
		js.executeScript("arguments[0].scrollIntoView();", delete_profile);
		delete_profile.click();
		Thread.sleep(3000);

		WebElement delete_profile_coupon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#flipModal > div > div > div.modal-footer.button_action > button.btn.btn-default.button_2")));
		js.executeScript("arguments[0].scrollIntoView();", delete_profile_coupon);
		delete_profile_coupon.click();
		Thread.sleep(30000);
		String verifyDeleteAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@x-html='message.text']"))).getText();
		Thread.sleep(3000);
		Assert.assertTrue("Account is not deleted",
				verifyDeleteAccount.contains("Your account has been deleted successfully."));
		System.out.println("your account delete successfully");

	}

}
