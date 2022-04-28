package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.*;


import java.util.List;

public class StepDefinations {
WebDriver driver;

@Given("User is navigated to the Website")
public void user_is_navigated_to_the_website() throws InterruptedException {
   System.setProperty("webdriver.chrome.driver", "src\\test\\java\\chromedriver.exe");
   driver=new ChromeDriver();
    
   driver.get("https://www.airasia.co.in/home");
   Thread.sleep(3000);
}
@Given("verify the title of the page")
public void verify_the_title_of_the_page() {
   String title="AirAsia India - Book Your Flights and Explore India";
   String actualltitlr=driver.getTitle();
   assertEquals(title,actualltitlr);
}
@When("user enter all required details")
public void user_enter_all_required_details(DataTable data) throws InterruptedException {
    driver.findElement(By.xpath("//div[@id='Round Trip']")).click();
    driver.findElement(By.cssSelector("div.flight-search-source-field-text.flight-search-polygon-cut-from:first-child")).click();
    driver.findElement(By.cssSelector("input.set-outline.form-control")).sendKeys(data.cell(0, 0));
    driver.findElement(By.cssSelector("div[data-testid='destination-field']")).click();
    driver.findElement(By.cssSelector("input.form-control")).sendKeys(data.cell(0, 1));
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("button.arrival-dropdown-list-group-item.list-group-item.list-group-item-action")).click();
    driver.findElement(By.cssSelector("div.flight-search-date-picker-wrapper")).click();
  
    Actions a=new Actions(driver);
WebElement q= driver.findElement(By.cssSelector("div[data-date-value='1654021800000']"));
WebElement qa=  driver.findElement(By.cssSelector("div[data-date-value='1654367400000']"));
    a.moveToElement(q).click().perform();
    a.moveToElement(qa).click().perform();
    
    driver.findElement(By.cssSelector("button.btn-flight")).click();
}
@Then("verify that navigated successfully to flight page")
public void verify_that_navigated_successfully_to_flight_page() {
   String expectedURL=driver.getCurrentUrl();
   String actualURL="https://www.airasia.co.in/flight-availability?/BLR/PNQ/2022-04-12/N/2/0/0/0/0/0/0/O/N/INR/ST";
   assertEquals("actualURL","expectedURL");
}



}
