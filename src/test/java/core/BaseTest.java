package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    Browser browser = new Browser();

    @BeforeClass
    public void setUp() throws IOException {
        driver = browser.manageBrowser();
    }

    @BeforeMethod
    public void setPageToDefaultState() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.clear();");
        driver.get(browser.mainPageUrl);
    }

    @AfterClass
    public void tearDown() {
        browser.quitFromBrowser();
    }
}
