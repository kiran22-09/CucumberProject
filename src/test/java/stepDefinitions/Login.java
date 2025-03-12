package stepDefinitions;


import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import hooks.MyHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
		

    @Given("User has navigated to login page")
    public void user_has_navigated_to_login_page() {
    	driver = DriverFactory.getDriver();
    	driver.findElement(By.xpath("//span[text()='My Account']")).click();
    	driver.findElement(By.xpath("//a[text()='Login']")).click();
    }
    
    @When("^User enters valid email address (.+) into email field$")
    public void User_enters_valid_email_address_into_email_field(String emailText) {
    	
    	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);
    	
    }
    
    @And("^User has entered valid password (.+) into password field$")
    public void User_has_entered_valid_password_into_password_field(String passwordText) {
    	
    	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);

    	
    }
    
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
    	
    	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	}
    
    @Then("user should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
  	
    }
    
    @When("User enters invalid email address {string} into email field")
    public void User_enters_invalid_email_address_into_email_field(String invalidemailText) {
    	
    	
    	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailWithTimeStamp());

    	
    }
    
    @And("User has entered invalid password {string} into password field")
    public void User_has_entered_invalid_password_into_password_field(String invalidpasswordText) {
    	
    	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidpasswordText);
    	
    }
    
    @Then("user should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
    	
		String warningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
    	Assert.assertTrue(warningMessage.contains("Warning: No match for E-Mail Address and/or Password"));
    }
    
      
    
    @When("User dont enters email address into email field")
    public void User_dont_enters_email_address_into_email_field() {
    	
    	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
    	
    }
    
    @And("User dont enters password into password field")
    public void User_dont_enters_password_into_password_field() {
    	
    	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
    	
    }
    
    public String getEmailWithTimeStamp() {
    	 Date date =  new Date();
    	 
    	 return "krian"+date.toString().replace(" " , "_").replace(":", "_")+"@gmail.com";
    	 }
    
}
