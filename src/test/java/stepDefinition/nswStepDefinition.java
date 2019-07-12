package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class nswStepDefinition {
	public static WebDriver driver;
	  
	
	@Given("^User successfully navigate to the URL$")
	public void user_successfully_navigate_to_the_URL()  {
		
	   System.setProperty("webdriver.chrome.driver", "chromedriver");
       driver = new ChromeDriver();
       driver.get("https://www.service.nsw.gov.au/");
       driver.manage().window().maximize();
	}

	@Given("^User successfully search \"([^\"]*)\"$")
	public void user_successfully_search(String search_text)  {
	      driver.findElement(By.xpath("//div[@id='globalAutosuggest']//input")).sendKeys(search_text,Keys.ENTER);
	   
	}

	@Then("^user navigates to the appropriate page$")
	public boolean user_navigates_to_the_appropriate_page()  {
		try{
			driver.findElement((By.xpath("//a[text()='Apply for a number plate']"))).click();
        
            return true;
        }
        catch (Exception e){
            return false;
        }
	    
	}

	@Then("^user validates the navigated page \"([^\"]*)\"$")
	public void user_validates_the_navigated_page(String search_text)  {
		String pageTitle = driver.findElement(By.xpath("//header[@class='page-header']//h1")).getText().trim();
    	//assertEquals(searchText, pageTitle);
    	Assert.assertEquals(search_text, pageTitle);
	    
	}

	@Then("^user click on the Find Location button$")
	public void user_click_on_the_Find_Location_button()  {
        driver.findElement(By.xpath("//div[@class='global-header__main']//a[text()='Find locations']")).click();
	}

	@Then("^Enter the \"([^\"]*)\"$")
	public void enter_the(String suburb)  {
        driver.findElement(By.id("locatorTextSearch")).sendKeys(suburb,Keys.ENTER);
	    
	}

	@Then("^Search for the \"([^\"]*)\"$")
	public boolean search_for_the(String service_center)  {
		 try{
	           driver.findElement(By.xpath("//a[@class='location__title'][text() ='"+service_center+"')]"));
	            return true;
	        }
	        catch (Exception e){
	            return false;
	        }
	    
	}

}
