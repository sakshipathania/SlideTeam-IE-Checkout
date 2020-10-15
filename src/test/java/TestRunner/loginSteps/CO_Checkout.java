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

public class CO_Checkout extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver,60);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Website Home Page (\\d+)CO$")
	public void user_is_already_on_Website_Home_Page_CO(int arg1) throws Throwable {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
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
		Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
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
			    WebElement new_email_signup = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/form/fieldset/div[4]/div/input"));
				Thread.sleep(2000);
			    new_email_signup.sendKeys(full_email);
				Thread.sleep(2000);
				
				// enter name

			    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/form/fieldset/div[5]/div[1]/div/input")));
				Thread.sleep(2000);
			    new_fname_signup.sendKeys("Selenium");
				Thread.sleep(2000);

			    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#lastname")));
				Thread.sleep(2000);
			    new_lname_signup.sendKeys("Testing");
				Thread.sleep(2000);
				
				//enter password
				 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
					Thread.sleep(2000);
				    new_pwd_signup.sendKeys("selenium@123");
					Thread.sleep(2000);

				    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password-confirmation")));
					Thread.sleep(2000);
				    new_pwd1_signup.sendKeys("selenium@123");
					Thread.sleep(2000);
					
					// enter captcha
					WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captcha_user_create")));
					Thread.sleep(2000);
				    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
					Thread.sleep(2000);
				    
				    // sign  up button
				    WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
					Thread.sleep(2000);
				    new_btn_signup.click();
					Thread.sleep(2000);
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
		
		Thread.sleep(3000);
		String actualTitle = "Team License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "Team License";
		Thread.sleep(1000);
		//wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		js.executeScript("alert('Text Team License is present and correct');");
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
		
           /* WebElement Monthly = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div[1]/span/span/em"));
             String strng1 = Monthly.getText();
            System.out.println(strng1);
            Assert.assertEquals("Monthly", strng1);
		
	    WebElement Monthly_pay = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div[2]/span/span/em"));
             String strng2 = Monthly_pay.getText();
            System.out.println(strng2);
            Assert.assertEquals("$49.99", strng2);
		
	    WebElement Semi_Annual = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[3]/div[1]/span/span/em"));
             String strng3 = Semi_Annual.getText();
            System.out.println(strng3);
            Assert.assertEquals("Semi_Annual", strng3);
		
	    WebElement Semi_Annual_pay = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[3]/div[2]/span[2]/span[2]/em"));
             String strng4 = Semi_Annual_pay.getText();
            System.out.println(strng4);
            Assert.assertEquals("$149.99", strng4);
		
		WebElement Annual = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[4]/div[1]/span/span/em"));
             String strng5 = Annual.getText();
            System.out.println(strng5);
            Assert.assertEquals("Annual", strng5);
	
		
		WebElement Annual_pay = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[4]/div[2]/span[2]/span[2]/em"));
             String strng6 = Annual_pay.getText();
            System.out.println(strng6);
            Assert.assertEquals("$249.99", strng6);
		
		
		WebElement Annual_Custom = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[5]/div[1]/span[2]/span/em"));
             String strng7 = Annual_Custom.getText();
            System.out.println(strng7);
            Assert.assertEquals("Annual + Custom Design", strng7);
		
		WebElement Annual_Custom_pay = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[5]/div[2]/span[2]/span[2]/em"));
             String strng8 = Annual_Custom_pay.getText();
            System.out.println(strng8);
            Assert.assertEquals("$299.99", strng8);
		
		WebElement Team_License = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[6]/div[1]/span/span/em"));
             String strng9 = Team_License.getText();
            System.out.println(strng9);
            Assert.assertEquals("Team License", strng9);
		
		WebElement Team_License_pay = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[6]/div[2]/span[2]/span[2]/em"));
             String strng10 = Team_License_pay.getText();
            System.out.println(strng10);
            Assert.assertEquals("$599.99", strng10);*/
		
            
		@Then("Join the subscription$")
		public void Join_the_subscription() throws Throwable {
		//assertEquals(driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div[1]/span/span/em".getText(),"Monthly")));
		// choose a plan
		Thread.sleep(4000);
		//driver.get("https://www.slideteam.net/pricing");
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Join now')])[8]")));
		js.executeScript("arguments[0].scrollIntoView();",join_now_btn);		
		Thread.sleep(2000);
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
		WebElement co_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tco_checkout")));
		Thread.sleep(2000);
	         co_btn.click();
		Thread.sleep(5000);
	     } catch( NoSuchElementException popup) { 
	     }
		
		// place order button 
		try {
			
		 WebElement place_order_btn  =  driver.findElement(By.cssSelector("#place-order-trigger > span"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			//js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
		    place_order_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^paypal popup appears and user navigates back to my account (\\d+)CO$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_CO(int arg1) throws Throwable {
	    String co_page_title=driver.getTitle();
		Thread.sleep(3000);
	    System.out.println("Title of the Page is --> "+co_page_title);
	    
	    String page_title="2Checkout";
	    
	    if(page_title.equalsIgnoreCase(co_page_title))
	    {
	    	System.out.println(" user is on the 2checkout page");
	    	log.info("USER IS ON THE 2CHECKOUT PAGE");
	    }
	    else
	    {
	    	System.out.println("user is on the wrong page");
	    	log.info("USER IS ON THE WRONG PAGE");
	    }
		Thread.sleep(3000);
	}

	@Then("^user deleted the account (\\d+)CO$")
	public void user_deleted_the_account_CO(int arg1) throws Throwable {
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


      
		 WebElement delete_account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Delete Account')]")));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deleteaccount-form']/button[1]")));
		js.executeScript("arguments[0].scrollIntoView();",continue_delete);
		continue_delete.click();
		 Thread.sleep(3000);
	}


	
}
