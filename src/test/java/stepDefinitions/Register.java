package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import hooks.MyHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	
	
	WebDriver driver;
	
	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		
    	driver = DriverFactory.getDriver();
    	driver.findElement(By.xpath("//span[text()='My Account']")).click();
    	driver.findElement(By.xpath("//li//a[text()='Register']")).click();
	    
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataMap.get("password"));
		
		    
	}

	@And("User select Privacy Policy")
	public void user_select_privacy_policy() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed());
		
		
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	    
	}


	@Then("User gets a proper warning message about duplicate email")
	public void user_gets_a_proper_warning_message_about_duplicate_email(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataMap.get("email"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataMap.get("password"));
		
		String WarningMessage = driver.findElement(By.xpath("//div[contains(@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(WarningMessage.contains("Warning: E-Mail Address is already registered!"));
    
	} 

	@When("User dont enter any details")
	public void user_dont_enter_any_details() {
		
		//intentionally given
	    
	}
 
	@Then("User gets a proper warning messages for every mandatory fields")
	public void user_gets_a_proper_warning_messages_for_every_mandatory_fields() {
		driver.findElement(By.xpath("//div[contains(@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: E-Mail Address is already registered!");
		Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());


	}
	
	public String getEmailWithTimeStamp() {
   	 Date date =  new Date();
   	 
   	 return "krian"+date.toString().replace(" " , "_").replace(":", "_")+"@gmail.com";
   	 }




}
