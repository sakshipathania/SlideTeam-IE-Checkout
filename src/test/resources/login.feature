@signInTest 
Feature: signin Test On Web Application 
Scenario: 
	Given Open the website url. 
	Then click on most downloaded link. 
	Then select a product item. 
	Then click on download this presentation link. 
Scenario Outline: Data driving for invalid data for sign-in. 
	Then Enter user email address as "<EmailAddress>". 
	Then Insert the Password "<Pass>". 
	Then Click on Login button. 
	Then Verify uesr "<EmailAddressVal>" validation message for Email Address. 
	Then Verify user "<PassVal>" validation message for Password. 
	Then Verify user "<Signin_error_Msg>" message for all invalid credentials. 
	Examples: 
		|EmailAddress        |Pass     | EmailAddressVal           |    PassVal                |Signin_error_Msg           |
		|                    |         | This is a required field. |This is a required field.  |                           |
		|test@gmail.com      |         |                           |This is a required field.  |                           | 
		|test@gmail.com      |tes@1234 |                           |                           | Invalid login or password.|
		
		
@signInTest_tochek_payement_option 
Scenario: 
	Given Open the website url. 
	Then click on most downloaded link. 
	Then select a product item. 
	Then click on download this presentation link. 
	Then Enter user a email address as. 
	Then Enter password as. 
	Then Click on Login button. 
	Given after login redirect to price page. 
	Then Select any of price subscription. 
	Then Verify the payment option field. 
	
	
@signInTest_and_redirect_paypal_page 
Scenario: 
	Given Open the website url. 
	Then click on most downloaded link. 
	Then select a product item. 
	Then click on download this presentation link. 
	Then Enter user a email address as. 
	Then Enter password as. 
	Then Click on Login button. 
	Then after login redirect to price page. 
	Then Select any of price subscription. 
	Then  See default payment option as paypal. 
	Then  Enter coupon code. 
	Then  Apply cuopon code. 
	Then  Verify applied coupon code offer. 
	Then  click on place order CTA. 
	Then  Verify the paypal payement page. 
	
	
@signInTest_and_redirect_paypal_page_without_apply_code 
Scenario: 
	Given Open the website url. 
	Then click on most downloaded link. 
	Then select a product item. 
	Then click on download this presentation link. 
	Then Enter user a email address as. 
	Then Enter password as. 
	Then Click on Login button. 
	Then after login redirect to price page. 
	Then Select any of price subscription. 
	Then  See default payment option as paypal. 
	Then  click on place order CTA. 
	Then  Verify the paypal payement page. 
	
@signInTest_and_redirect_card_page 
Scenario: 
	Given Open the website url. 
	Then click on most downloaded link. 
	Then select a product item. 
	Then click on download this presentation link. 
	Then Enter user a email address as. 
	Then Enter password as. 
	Then Click on Login button. 
	Then after login redirect to price page. 
	Then Select any of price subscription. 
	Then  Select payment option as Card. 
	Then  Enter coupon code. 
	Then  Apply cuopon code. 
	Then  Verify applied coupon code offer. 
	Then  click on place order CTA. 
	Then  Verify card payement page. 
	
@signInTest_and_redirect_card_page_without_coupon 
Scenario: 
	Given Open the website url. 
	Then click on most downloaded link. 
	Then select a product item. 
	Then click on download this presentation link. 
	Then Enter user a email address as. 
	Then Enter password as. 
	Then Click on Login button. 
	Then after login redirect to price page. 
	Then  Select any of price subscription. 
	Then  Select payment option as Card. 
	Then  click on place order CTA. 
	Then  Verify card payement page. 
	
	
