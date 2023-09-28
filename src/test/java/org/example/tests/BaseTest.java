package org.example.tests;

import org.apache.log4j.Logger;
import org.example.pages.HistogramPage;
import org.example.pages.LoginPage;
import org.example.utility.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    LoginPage loginPage;

     Logger log = Logger.getLogger(BaseTest .class);

    @BeforeMethod
    public void initDriver() {
        Browser.initDriver();
        log.debug("The driver is successfully initialized");
        loginPage = new LoginPage();
        loginPage.openPage();
        log.info("The login page is successfully opened");
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
        log.info("The driver is successfully closed");
    }

}
