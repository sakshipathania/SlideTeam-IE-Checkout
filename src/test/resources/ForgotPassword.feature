@forgotTest 
Feature: Verify the forgot password. 
Scenario Outline: Test the forgot password. 
	Given To the application URL. 
	And  Select on Complete ppts CTA. 
	And Select as a Project Scoping Powerpoint. 
	And Click on download link cta. 
	Then Click on forgot password link. 
	Then Enter the user email address is registerd as "<Email Address>". 
	Then Click on submit button. 
	Then Verify "<Email AddressVal>" the validation message. 
	Examples: 
		|Email Address                               |Email AddressVal                                                                                                             |
		|                                            |  This is a required field.                                                                                                  |
Scenario Outline: 
	Given To the application URL. 
	And  Select on Complete ppts CTA. 
	And Select as a Project Scoping Powerpoint. 
	And Click on download link cta. 
	Then Click on forgot password link. 
	Then Enter the user email address is registerd as "<Email Address>". 
	Then Click on submit button. 
	Then "<password SendVal>" validation message.
	Examples: 
		|Email Address          |password SendVal                                                                                                             |
		|test.shadab@gmail.com  |  If there is an account associated with test.shadab@gmail.com you will receive an email with a link to reset your password. |