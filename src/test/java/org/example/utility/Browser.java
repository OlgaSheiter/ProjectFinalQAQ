package org.example.utility;

import org.example.enums.BrowserType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static BrowserType browserType;

    private Browser() {

    }

    static Properties properties;

    public static void initDriver() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/project.properties"));
            Browser.browserType = BrowserType.valueOf(properties.getProperty("browser"));
            driver = BrowserFactory.createDriver(browserType);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (Exception ex) {
        }
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

    public static void saveScreenShot() throws IOException {

        File screenShots = new File("./testsFailure/screenshots");

        if (!screenShots.exists()) {
            screenShots.mkdirs();
        }
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");
        String formattedDate = simpleDateFormat.format(date);
        String fileName = browserType.name() + "_" + formattedDate + "screenshot.png";

        byte[] scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Files.write(new File("./testsFailure/screenshots/" + fileName).toPath(), scrFile, StandardOpenOption.CREATE);
    }

}
