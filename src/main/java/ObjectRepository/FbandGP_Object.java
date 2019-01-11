package ObjectRepository;

import org.openqa.selenium.By;

public class FbandGP_Object {
//Facebook
	public static By fbLink=By.cssSelector(".main .inchoo-socialconnect-facebook-inner>a");
	public static By Login_fbLink=By.cssSelector("#login-form a[title='facebook-connect']");    
	public static By Femai = By.id("email");
	public static By Fpassword=By.id("pass");
	public static By FbLogin=By.id("loginbutton");
	public static By continue_as_QA=By.name("__CONFIRM__");
	// Google Plus
	public static By GooglePlusLink=By.cssSelector(".main .inchoo-socialconnect-google-inner");
	public static By GPEmail=By.id("identifierId");
	public static By Next_cta=By.id("identifierNext");
	public static By GPpass=By.cssSelector("#password>div.aCsJod.oJeWuf >div div.Xb9hP>input");
	public static By Next_button=By.id("passwordNext");
	//identifierNext
}
