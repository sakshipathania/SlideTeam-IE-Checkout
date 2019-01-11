package ObjectRepository;

import org.openqa.selenium.By;

public class LoginObject {
	public static By UserId=By.id("email");
	public static By userpass = By.id("pass");
	public static By login = By.id("send2");
	
	// Error message for invalid data
	public static By uesremail_val=By.id("advice-required-entry-email");
	public static By error_val=By.id(".error-msg>ul>li>span");
	public static By pass_val=By.id("advice-required-entry-pass");
	
	
	public static By sign_in= By.cssSelector(".account-login>ul>li>ul>li>span");
	
	
	//Forgot password object
	public static By Forgot=By.xpath("//*[text()='Forgot Your Password?']");
	public static By enter_mail=By.id("email_address");
	public static By Button_submit=By.cssSelector(".buttons-set>button");
	public static By invalid_error=By.id("advice-required-entry-email_address");
	public static By verify_sucess=By.cssSelector(".success-msg>ul>li>span");
	

}
