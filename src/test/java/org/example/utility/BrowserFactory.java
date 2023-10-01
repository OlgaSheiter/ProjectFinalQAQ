package org.example.utility;

import org.example.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.example.utility.Browser.getProjectProperties;

public class BrowserFactory {
    static
    {
        System.setProperty("webdriver.chrome.driver",getProjectProperties().getProperty("driverChromeLocation"));
        System.setProperty("webdriver.gecko.driver",getProjectProperties().getProperty("driverFirefoxLocation"));
    }

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case REMOTEWEBDRIVER:
            try {
                DesiredCapabilities capabilities =DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL("http://192.168.100.17:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException("URL is not supported" + e.getMessage());
            }
            break;
            default:
                throw new IllegalStateException("Browser not Supported: " + browserType);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
