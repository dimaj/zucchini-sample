package net.dimaj.zucchini.sample.glue;

import static net.dimaj.zucchini.utils.Constants.CONTEXT_BROWSER;

import com.comcast.zucchini.TestContext;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyGlue {

    private WebDriver driver;
    
    public MyGlue() {
        this.driver = TestContext.getCurrent().get(CONTEXT_BROWSER);
    }
    
    @When("^I navigate to google search$")
    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }
    
    @Then ("^I should see search box$")
    public void verifyGoogle() {
        driver.findElement(By.id("lst-ib"));
    }
}
