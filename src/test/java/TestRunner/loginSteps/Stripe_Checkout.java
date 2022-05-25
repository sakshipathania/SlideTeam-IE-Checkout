package TestRunner.loginSteps;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ObjectRepository.LoginObject;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Stripe_Checkout extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver,30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Website Home Page (\\d+)CO$")
	public void user_is_already_on_Website_Home_Page_CO(int arg1) throws Throwable {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	        Thread.sleep(2000);
	    
		//driver.manage().deleteAllCookies();
		//Thread.sleep(4000); // wait 4 seconds to clear cookies.
		//driver.navigate().refresh();
		Thread.sleep(2000);
	   try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	    Thread.sleep(1000);
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
		Thread.sleep(1000);
	    
	    
	}

	@Then("^user navigates to sign up page (\\d+)CO$")
	public void user_navigates_to_sign_up_page_CO(int arg1) throws Throwable {
		Thread.sleep(2000);
		try {
			
			
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			//driver.get("https://www.slideteam.net/customer/account/login/referer/aHR0cHM6Ly93d3cuc2xpZGV0ZWFtLm5ldC9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/");
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^user create a new ac count (\\d+)CO$")
	public void user_create_a_new_ac_count_CO(int arg1) throws Throwable {
		// create new email for sign up
		
				int leftLimit = 97; // letter 'a'
			    int rightLimit = 122; // letter 'z'
			    int targetStringLength = 10;
			    Random random = new Random();
			    StringBuilder buffer = new StringBuilder(targetStringLength);
			    for (int i = 0; i < targetStringLength; i++) {
			        int randomLimitedInt = leftLimit + (int) 
			          (random.nextFloat() * (rightLimit - leftLimit + 1));
			        buffer.append((char) randomLimitedInt);
			    }
			    String generatedString = buffer.toString();
			 
			    System.out.println(generatedString);
			    
			    String signup_email=generatedString;
			    String full_email="selenium.testing."+generatedString+"@gmail.com";
			    System.out.println(full_email);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				//driver.findElement(By.id("email_address")).sendKeys(full_email);
				

				Thread.sleep(2000);
			    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email_address']")));
				Thread.sleep(2000);
			    new_email_signup.sendKeys(full_email);
				Thread.sleep(2000);
				
				// enter name

			    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstname']")));
				Thread.sleep(2000);
			    new_fname_signup.sendKeys("Selenium");
				Thread.sleep(2000);

			    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastname']")));
				Thread.sleep(2000);
			    new_lname_signup.sendKeys("Testing");
				Thread.sleep(2000);
				
				//enter password
				 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
					Thread.sleep(2000);
				    new_pwd_signup.sendKeys("selenium@123");
					Thread.sleep(2000);

				    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password-confirmation']")));
					Thread.sleep(2000);
				    new_pwd1_signup.sendKeys("selenium@123");
					Thread.sleep(2000);
					
					// enter captcha
					WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
					Thread.sleep(2000);
				    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
					Thread.sleep(2000);
				    
				    // sign  up button
				    WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
					Thread.sleep(2000);
				    new_btn_signup.click();
					Thread.sleep(2000); 
		/*Thread.sleep(1000);
		WebElement old_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='email']")));
		js.executeScript("arguments[0].scrollIntoView();",old_email);
		Thread.sleep(1000);
	    old_email.sendKeys("Qwerty120@gmail.com");
	    Thread.sleep(1000);
	    WebElement old_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pass']")));
		js.executeScript("arguments[0].scrollIntoView();",old_pass);
	    Thread.sleep(1000);
	    old_pass.sendKeys("Qwerty@1");
	    Thread.sleep(5000);
	     WebElement old_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
		 Thread.sleep(3000);
		    old_login_btn.click();*/
	}

	
	@Then("^user is redirected to pricing page and check the text1 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text1_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "Monthly";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Monthly";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Monthly is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text2 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text2_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "$49.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$49.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $49.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text3 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text3_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "Semi Annual";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Semi Annual";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Semi Annual is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text4 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text4_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "$149.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$149.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $149.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text5 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text5_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "Annual";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text6 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text6_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "$249.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$249.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $249.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text7 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text7_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "Annual + Custom Design";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual + Custom Design";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual + Custom Design is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(2000);
	}
	
	@Then("^user is redirected to pricing page and check the text8 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text8_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		Thread.sleep(3000);
		String actualTitle = "$299.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$299.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $299.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text9 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text9_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);
		
		String actualTitle = "Annual 4 User License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual 4 User License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual 4 User License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text10 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text10_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);
	
		String actualTitle = "$599.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$599.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $599.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
		
          @Then("^user is redirected to pricing page and check the text11 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text11_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);
	
		String actualTitle = "Annual 20 User License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual 20 User License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual 20 User License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
		
	@Then("^user is redirected to pricing page and check the text12 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text12_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);
	
		String actualTitle = "$1599.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$1599.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $1599.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
            
	@Then("^user is redirected to pricing page and check the text13 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text13_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);
	
		String actualTitle = "Annual Company Wide Unlimited User License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual Company Wide Unlimited User License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual Company Wide Unlimited User License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text14 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text14_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Business Teams']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Business_Team);
		Thread.sleep(3000);
		Business_Team.click();
		Thread.sleep(3000);
	
		String actualTitle = "$2999.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$2999.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $2999.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text15 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text15_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		WebElement Education = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Education']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Education);
		Thread.sleep(3000);
		Education.click();
		Thread.sleep(3000);
	
		String actualTitle = "Annual 15 User Education License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual 15 User Education License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual 15 User Education License is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text16 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text16_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		WebElement Education = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Education']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Education);
		Thread.sleep(3000);
		Education.click();
		Thread.sleep(3000);
	
		String actualTitle = "$999.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$999.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $999.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text17 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text17_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		WebElement Education = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Education']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Education);
		Thread.sleep(3000);
		Education.click();
		Thread.sleep(3000);
	
		String actualTitle = "Annual UNLIMITED User Institute Wide License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Annual UNLIMITED User Institute Wide License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Annual UNLIMITED User Institute Wide Licenseis present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and check the text18 (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_check_the_text18_CO(int arg1) throws Throwable {
		Thread.sleep(7000);
		driver.get("https://www.slideteam.net/pricing");
		       Thread.sleep(4000);
		WebElement Education = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Education']")));
				Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Education);
		Thread.sleep(3000);
		Education.click();
		Thread.sleep(3000);
	
		String actualTitle = "$1999.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "$1999.99";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text $1999.99 is present and correct');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//wait.implictywait(driver);
		Thread.sleep(5000);
	}
	
	@Then("^user is redirected to pricing page and choose a plan to pay (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_choose_a_plan_to_pay_CO(int arg1) throws Throwable {
		// choose a plan
		Thread.sleep(4000);
		driver.get("https://www.slideteam.net/pricing");
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Individual > div > div.slide-product > div:nth-child(2) > div.col.col2.col-bg2 > span > form > button > span")));
			Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",join_now_btn);
		Thread.sleep(3300);
		    join_now_btn.click();
			Thread.sleep(6000);

	}

	@Then("^user is redirected to checkout page (\\d+)CO$")
	public void user_is_redirected_to_checkout_page_CO(int arg1) throws Throwable {
		Thread.sleep(6000);
	}

	@Then("^user proceed to pay with (\\d+)CO (\\d+)CO$")
	public void user_proceed_to_pay_with_CO_CO(int arg1, int arg2) throws InterruptedException {
	     try {
		Thread.sleep(1400);
		// select 2co option
		WebElement co_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#amasty_stripe")));
		Thread.sleep(2000);
	         co_btn.click();
		Thread.sleep(5000);
	   
		WebElement Stripe_name  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#stripe-name")));
		Thread.sleep(2000);
	         Stripe_name.sendKeys("QA");
		Thread.sleep(5000);
		
		
		WebElement Stripe_email  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#stripe-email")));
		Thread.sleep(2000);
	         Stripe_email.sendKeys("sakshi.pathania@slidetech.in");
		Thread.sleep(5000);
		
		
		WebElement Stripe_card  =  driver.findElement(By.className("InputElement is-empty Input Input--empty"));
		Thread.sleep(2000);
	         Stripe_card.sendKeys("4242424242424242");
		Thread.sleep(5000);
		   //  Stripe_card.clear();
		  } catch( NoSuchElementException popup) { 
	     }
                Thread.sleep(5000);
		// place order button 
		try {
			
		 WebElement place_order_btn  =  driver.findElement(By.cssSelector("#place-order-trigger > span"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);
			//js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
		    place_order_btn.click();
			Thread.sleep(5000);
			
			String co_page_title = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("Title of the Page is --> " + co_page_title);

		String ErrorMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@id='checkout']//div[@data-ui-id='checkout-cart-validationmessages-message-error'][normalize-space()='Please verify you card information.']")))
				.getText();
		// verify the error meaasge
		Assert.assertTrue("user is on wrong page", ErrorMessage.contains("Please verify you card information."));
		
		//verify the Title
		Assert.assertTrue("user is on wrong page", co_page_title.contentEquals("Checkout"));
								  
		} catch (NoSuchElementException popup) {
		}
		
	}


	@Then("^user deleted the account (\\d+)CO$")
	public void user_deleted_the_account_CO(int arg1) throws Throwable {
		Thread.sleep(3000);

		
		 WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
			  Thread.sleep(3000);
		js.executeScript("arguments[0].click();", account);
			//account.click();
		 Thread.sleep(3000);
		 
		

		 WebElement delete_account = driver.findElement(By.cssSelector("#clicking"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		WebElement delete_reason = driver.findElement(By.cssSelector("#exampleRadios1"));
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);
		
		 WebElement delete_profile = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete-final")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile);
		delete_profile.click();
		 Thread.sleep(3000);
		
		WebElement delete_profile_coupon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#flipModal > div > div > div.modal-footer.button_action > button.btn.btn-default.button_2")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile_coupon);
		delete_profile_coupon.click();
		 Thread.sleep(3000);
		String verifyDeleteAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))).getText();
		 Thread.sleep(6000);
	         Assert.assertTrue("Account is not deleted", verifyDeleteAccount.contains("Your account has been deleted successfully."));
	         System.out.println("your account delete successfully");
		

	}
	
}
