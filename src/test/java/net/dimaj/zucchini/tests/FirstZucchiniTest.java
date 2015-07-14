package net.dimaj.zucchini.tests;

import java.util.ArrayList;
import java.util.List;

import com.comcast.zucchini.AbstractZucchiniTest;
import com.comcast.zucchini.TestContext;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import net.dimaj.zucchini.utils.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@CucumberOptions(
    features = { "src/test/resources" },
    glue = { "net.dimaj.zucchini.sample.glue" }
)
public class FirstZucchiniTest extends AbstractZucchiniTest {

    @Override
    public List<TestContext> getTestContexts() {
        List<TestContext> rv = new ArrayList<TestContext>();
        
        TestContext chrome = new TestContext("chrome");
        chrome.set(Constants.CONTEXT_BROWSER, new ChromeDriver());
        rv.add(chrome);
        
        TestContext ff = new TestContext("firefox");
        ff.set(Constants.CONTEXT_BROWSER, new FirefoxDriver());
        rv.add(ff);
        
        return rv;
    }
    
    @Before
    public void setupTests(Scenario scenario) {
        TestContext.getCurrent().set(Constants.CONTEXT_SCENARIO, scenario);
    }
    
    @Override
    public void cleanup(TestContext out) {
        WebDriver driver = out.get(Constants.CONTEXT_BROWSER);
        if (null != driver) {
            driver.quit();
        }
    }

    
}
