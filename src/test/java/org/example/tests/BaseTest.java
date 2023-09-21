package org.example.tests;

import org.example.pages.LoginPage;
import org.example.utility.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void initDriver() {
        Browser.initDriver();
        loginPage = new LoginPage();
        loginPage.openPage();
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
    }

}
