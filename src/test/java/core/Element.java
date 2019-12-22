package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {
    private WebDriver driver;
    private static final int TIME_IN_SECONDS_FOR_WAIT = 60;

    public Element(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementIsDisplayed(By elementOnPage){
        WebDriverWait webDriverWait = new WebDriverWait(driver, TIME_IN_SECONDS_FOR_WAIT);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementOnPage));
    }
}
