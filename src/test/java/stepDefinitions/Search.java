package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import hooks.MyHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	
	WebDriver driver;
	
	@Given("User navigates to the page")
	public void user_navigates_to_the_page() {
		driver = DriverFactory.getDriver();
		driver.get("https://tutorialsninja.com/demo/");
	    
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) {
		
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys(validProduct);
	    
	}

	@And("User clicks on the Search button")
	public void user_clicks_on_thr_search_button() {
		
		driver.findElement(By.xpath("//button//i[@class='fa fa-search']")).click();
	    
	}

	@Then("User should get a valid product displayed in serch results")
	public void user_should_get_a_valid_product_displayed_in_serch_results() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys(invalidproduct);		
	   
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		String noProductMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		Assert.assertEquals("There is no product that matches the search criteria.", noProductMessage);
	}

	@When("User dont enters any product into Search box field")
	public void user_dont_enters_any_product_into_search_box_field() {
	    
		//intentionally given
	}




}
