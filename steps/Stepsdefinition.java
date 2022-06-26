package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepsdefinition {
  public ChromeDriver driver;
@Given("Open the Chrome browser")  
public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
@Given("Load the application url {string}")
public void loadUrl(String url) {
		driver.get(url);
	}
@Given("Enter the username {string}")
public void enterUsername(String uName) {
	driver.findElement(By.id("username")).sendKeys(uName);
	}
@Given("Enter the password {string}")
public void enterPassword(String pWord) {
	driver.findElement(By.id("password")).sendKeys(pWord);
}
@When("Click on Login button")
public void clickLoginButton() {
	driver.findElement(By.className("decorativeSubmit")).click();
}	
@Then("Homepage should be displayed")
public void verifyHomepage() {
	boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
	if(displayed) {
		System.out.println("Homepage is Displayed");
	}else {
		System.out.println("Homepage is not Displayed");
}			
}

}
