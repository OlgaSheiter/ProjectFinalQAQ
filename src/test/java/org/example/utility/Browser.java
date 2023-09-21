package org.example.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;

    private static Properties properties;

    public static void initDriver() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/project.properties"));
            if (properties.getProperty("browser").equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty("driverLocation"));
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (Exception ex) {}
    }
    public static Properties getProjectProperties() {
        return properties;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
