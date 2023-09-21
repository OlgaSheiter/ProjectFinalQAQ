package org.example.tests;

import org.example.pages.GridPage;
import org.example.pages.LoginPage;
import org.example.pages.SummaryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GridPageTests extends BaseTest {
    LoginPage loginPage;
    GridPage gridPage;
    @BeforeMethod
    public void openDeltixuat() {
        loginPage = new LoginPage();
        gridPage = new GridPage();
        loginPage.openPage();
    }


}