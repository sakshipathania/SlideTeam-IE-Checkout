package ObjectRepository;

import org.openqa.selenium.By;

public class SignupObject {
		public static By close_add=By.cssSelector(".fancybox-item.fancybox-close");
		public static By Most = By.cssSelector("#new-menu>li:nth-child(3)>a>p");
		public static By Select_item = By.cssSelector(".product-info>h2>a[title='Project Scoping Powerpoint Presentation Slides']");
		public static By Downloaded = By.cssSelector(".download-wishlist-button>div>button");
		public static By create = By.cssSelector(".buttons-set>button[title='Create an Account']>span");
		public static By Email = By.id("email_address");
		public static By FName = By.id("firstname");
		public static By lastname = By.id("lastname");
		public static By password = By.id("password");
		public static By Cpassword = By.id("confirmation");
		public static By Captcha = By.id("captcha_user_create");
		//public static By reload_Captcha = By.id("captcha-reload");
		public static By take_Captcha = By.id("#user_create");
		public static By Signup=By.cssSelector("#form-validate >div.buttons-set>button");
			
		//error message
		public static By Email_AddressVal = By.id("advice-required-entry-email_address");
		public static By FNVal = By.id("advice-required-entry-firstname");
		public static By LNVal = By.id("advice-required-entry-lastname");
		public static By Signup_errormessage = By.cssSelector(".error-msg");
		public static By password_errormessage = By.id("advice-validate-password-password");
		public static By repeat_errormessage = By.cssSelector("advice-required-entry-confirmation");
		public static By captcha = By.cssSelector("advice-required-entry-captcha_user_create");
		
		//price element
		
		public static By random_Price = By.cssSelector(".btn.btn-primary.join-now");
		
		public static By Monthly_Price = By.cssSelector(".btn.btn-primary.join-now.monthly-join-now");
		public static By Semi_Price = By.cssSelector(".btn.btn-primary.join-now.semi-annual-join-now");
		public static By Annual_Price = By.cssSelector(".btn.btn-primary.join-now.annual-join-now");
		public static By AnnualCustom_Price = By.cssSelector(".btn.btn-primary.join-now.annual-custom-join-now");
		public static By Team_Price = By.cssSelector(".btn.btn-primary.join-now.team-join-now");
		
		// apply Coupon
		public static By Enter_Coupon = By.id("coupon_code");
		public static By Apply_Coupon = By.cssSelector("#couponapply[title='Apply Coupon']");
		public static By verify_apply_code=By.cssSelector("#checkout-review-table > tfoot > tr:nth-child(2) > td:nth-child(1)");

	//See the discount price is applied 
		
		// click on place order cta
		public static By place_cta=By.cssSelector("#submit>span>span");
		
		// the payment option 
		public static By paymentfield=By.cssSelector(".fieldset");
		public static By payment=By.cssSelector("#opc-payment>div>h2");
		 //
		
		//select payment option as paypal 
		public static By paypay_radio_button=By.id("p_method_paypal_standard");
		public static By verify_paypal_text=By.cssSelector(".form-list");
		public static By paypal_screen = By.cssSelector(".contentArea");
		
		//Select payment option as card
		public static By card_radio_button=By.id("p_method_tco");
		public static By verify_2checkout=By.cssSelector("#dt_method_tco>label");

		
		
		// Delete Account 
		public static By MyAccount=By.cssSelector(".signin-link[title='My Account']");
		public static By Delete=By.cssSelector("#del_acc>a");
		public static By Delete_Yes=By.cssSelector("#confirm_id > input.confirm-cl.yes.btn.btn-default.get-button.small-button");
		public static By Conf_delete=By.xpath("//*[text()='Your account has been deleted successfully.']");

	}


