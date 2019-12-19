package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    WebDriver manageBrowser() throws IOException {
        PropertyFile propertyFile = new PropertyFile("target/classes/test.properties");
        String mainPageUrl = propertyFile.getProperty("mainPageURL");
        String chromeDriverPath = new File("chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(mainPageUrl);
        return driver;
    }

    void quitFromBrowser() {
        driver.quit();
    }



}
