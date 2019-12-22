package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    String mainPageUrl;

    WebDriver manageBrowser() throws IOException {
        PropertyFile propertyFile = new PropertyFile("target/test-classes/test.properties");
        mainPageUrl = propertyFile.getProperty("mainPageURL");
        String chromeDriverPath = new File("chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String implicityWaitTimeout = propertyFile.getProperty("defaultTimeout");
        driver.manage().timeouts().implicitlyWait(Long.parseLong(implicityWaitTimeout), TimeUnit.SECONDS);
        driver.get(mainPageUrl);
        return driver;
    }

    void quitFromBrowser() {
        driver.quit();
    }
}
