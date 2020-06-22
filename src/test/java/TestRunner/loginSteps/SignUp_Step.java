package TestRunner.loginSteps;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.Robot; 
import java.awt.event.KeyEvent;
import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;
public class SignUp_Step extends SetupClass {
	
	
       JavascriptExecutor js = (JavascriptExecutor) driver;
	public static String Email_Address;
	Random rad = new Random();
	WebDriverWait wait = new WebDriverWait(driver,50);

//	String name = "" + rad.nextInt(100000) + "@gmail.com";

	// Open web site URl
	@Given("^Navigates to website url\\.$")
	public void Navigates_to_website_url() throws InterruptedException {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		Thread.sleep(2000);
		try {
			WebElement Website = driver.findElement(SignupObject.close_add);
			Website.click();
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
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

       
	@Then("^Creating new account$")
	public void Creating_new_account() throws Throwable {
		//WebElement Email_Address = driver.findElement(By.xpath("//*[@id='email_address']"));
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
		try {
			    WebElement new_signup = driver.findElement(By.xpath("//*[@id='email_address']"));
				Thread.sleep(2000);
			    new_signup.sendKeys(full_email);
				Thread.sleep(2000);
		}
		catch( NoSuchElementException popup) {
		}
				// enter name
               try {
			   WebElement First_Name= driver.findElement(By.xpath("//*[@id='firstname']"));
		First_Name.click();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		First_Name.clear();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		First_Name.sendKeys("Selenium");
		Thread.sleep(2000);
		//wait.implictywait(driver);
		log.info("It's entering the user First Name");
                    }
		catch( NoSuchElementException popup) {
		}
		try {
			    WebElement Last_Name= driver.findElement(By.xpath("//*[@id='lastname']"));
		Last_Name.click();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Last_Name.clear();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Last_Name.sendKeys("Testing");
		Thread.sleep(2000);
		//wait.implictywait(driver);
		log.info("It's entering the user Last Name");
			}
		catch( NoSuchElementException popup) {
		}	
				//enter password
		try {
				 WebElement Pas_word = driver.findElement(By.xpath("//*[@id='password']"));
		Pas_word.click();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Pas_word.clear();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Pas_word.sendKeys("selenium@123");
		Thread.sleep(2000);
		//wait.implictywait(driver);
		log.info("It's entering the user password");
                 }
		catch( NoSuchElementException popup) {
		}
		try {
				    WebElement Confirm_passw= driver.findElement(By.xpath("//*[@id='password-confirmation']"));
		//wait.implictywait(driver);
		Thread.sleep(2000);
		Confirm_passw.click();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Confirm_passw.clear();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Confirm_passw.sendKeys("selenium@123");
		Thread.sleep(2000);
		//wait.implictywait(driver);
		log.info("It's entering the user password");
			}
		catch( NoSuchElementException popup) {
		}		
					// enter captcha
		try {
					WebElement Captcha_ch= driver.findElement(By.xpath("//*[@id='captcha_user_create']"));
		//wait.implictywait(driver);
		Thread.sleep(2000);
		//Captcha_ch.click();
		//Thread.sleep(2000);
		//wait.implictywait(driver);
		Captcha_ch.clear();
		Thread.sleep(2000);
		//wait.implictywait(driver);
		Captcha_ch.sendKeys("Aj7W2mtf9namwf55");
		Thread.sleep(1000);
		//wait.implictywait(driver);
		log.info("It's entering the user password");
			}
		catch( NoSuchElementException popup) {
		}	    
				    // sign  up button
		try {
				    WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement ele_ment = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/form/fieldset/div[8]/div[2]/div/div/button"));
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", ele_ment);
			Thread.sleep(2000);

			}
		catch( NoSuchElementException popup) {
		}
	}

	
	@Then("^After signup see the price page$")
	public void After_signup_see_the_price_page() throws InterruptedException {
		/*driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		//wait.implictywait(driver);
		Thread.sleep(2000);
		String expectedTitle = "Pricing";
		//wait.implictywait(driver);
		Thread.sleep(2000);
		Assert.assertEquals(expectedTitle, actualTitle);
		//wait.implictywait(driver);*/
		driver.get("https://www.slideteam.net/pricing");
		Thread.sleep(2000);
		WebElement free_ppt_btn= driver.findElement(By.xpath("//a[contains(.,'Free PPTs')]"));
		js.executeScript("arguments[0].scrollIntoView();",free_ppt_btn);
		Thread.sleep(2000);
	    free_ppt_btn.click();
	    Thread.sleep(2000);
	   
		Thread.sleep(1000);
	}

	
	@Then("^user will download a free product cd$")
	public void user_will_download_a_free_product_cd() throws InterruptedException  {
		try {
		driver.findElement(By.cssSelector("li.item:nth-child(8) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(3000);
		WebElement Down_load= driver.findElement(By.xpath("//*[@id='clicking']"));
			js.executeScript("arguments[0].scrollIntoView();",Down_load);
			Down_load.click();
		Thread.sleep(3000);
		
		}
		catch( NoSuchElementException popup) {
		}
	}
		//Close the dialog box
      @Then("^close the dialog box")
		public void close_the_dialog_box() throws AWTException 
		{
			Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}

	
        	@Then("^user deleted the account$")
	public void user_deleted_the_account() throws Throwable {
		Thread.sleep(3000);
	    driver.get("https://www.slideteam.net/");
		Thread.sleep(2000);
		

		 driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		 Thread.sleep(3000);
		 
		


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


      
		 WebElement delete_account = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'Continue')]")));
		js.executeScript("arguments[0].scrollIntoView();",continue_delete);
		continue_delete.click();
		 Thread.sleep(3000);
	}


	
}
