package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    Browser browser = new Browser();

    @BeforeClass
    public void setUp() throws IOException {
        driver = browser.manageBrowser();
    }

    @AfterClass
    public void tearDown() {
        browser.quitFromBrowser();
    }

}
