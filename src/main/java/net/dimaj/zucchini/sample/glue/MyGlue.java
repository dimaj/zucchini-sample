package net.dimaj.zucchini.sample.glue;

import static net.dimaj.zucchini.utils.Constants.CONTEXT_BROWSER;

import com.comcast.zucchini.TestContext;

import cucumber.api.java.Before;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class MyGlue {

    private WebDriver driver;
    
    public MyGlue() {
        this.driver = TestContext.getCurrent().get(CONTEXT_BROWSER);
    }
    
    @Before
    public void setup(Scenario scenario) {
        TestContext.getCurrent().set("scenario", scenario);
    }
    
    @When("^I navigate to google search$")
    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }
    
    @Then ("^I should see search box$")
    public void verifyGoogle() {
        driver.findElement(By.id("lst-ib"));
    }
    
    @And("^Take a picture")
    public void takePicture() {
        Scenario scenario = TestContext.getCurrent().get("scenario");
        try {  
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);  
            scenario.embed(screenshot, "image/png");  
        } catch (WebDriverException wde) {  
            System.err.println(wde.getMessage());  
        } catch (ClassCastException cce) {  
            cce.printStackTrace();  
        }  

    }
}
