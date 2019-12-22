package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("localStorage.clear();");
        driver.get("http://todomvc.com/examples/vanillajs/");
    }

    @BeforeMethod
    public void returnToActive() {

    }

    @AfterClass
    public void tearDown() {
        browser.quitFromBrowser();
    }

}
