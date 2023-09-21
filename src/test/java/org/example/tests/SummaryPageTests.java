package org.example.tests;

import org.example.elements.TopMenu;
import org.example.enums.TopMenuEnum;
import org.example.pages.GridPage;
import org.example.pages.LoginPage;
import org.example.pages.SummaryPage;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SummaryPageTests extends BaseTest {
    private String buttonSettingsLocator = "//*[@title='Settings']";

    SummaryPage summaryPage;

    @BeforeMethod
    public void openSummaryPage() {
        summaryPage = new SummaryPage();
        summaryPage.openPage();
    }

    @Test(groups = "TC01")
    public void topMenuPresentTest() throws Exception {
        TopMenu topMenu = new TopMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(summaryPage.isItemMenuPresent(TopMenuEnum.Summary), "The menu Summary is absent");
        softAssert.assertTrue(summaryPage.isItemMenuPresent(TopMenuEnum.Grid), "The menu Grid is absent");
        softAssert.assertTrue(summaryPage.isItemMenuPresent(TopMenuEnum.Histogram), "The menu Histogram is absent");
        softAssert.assertTrue(summaryPage.isItemMenuPresent(TopMenuEnum.Scatter), "The menu Scatter is absent");
        softAssert.assertTrue(summaryPage.isItemMenuPresent(TopMenuEnum.Reports), "The menu Reports is absent");
        softAssert.assertAll();
    }

    @Test(groups = "TC01")
    public void buttonSettingsPresentTest() throws Exception {
        Assert.assertTrue(SummaryPage.isElementPresent(buttonSettingsLocator), "The button Settings is absent");
    }

    @Test(groups = "TC01")
    public void menuBenchmarkSelectorPresent() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        Browser.getDriver().findElement(By.xpath("//app-benchmark-selection")).click();
        softAssert.assertTrue(SummaryPage.isElementPresent("//*[contains(text(),'VWAP')]"), "The menu VWAP is absent");
        softAssert.assertTrue(SummaryPage.isElementPresent("//*[contains(text(),'QWAP')]"), "The menu QWAP is absent");
        softAssert.assertTrue(SummaryPage.isElementPresent("//*[contains(text(),'Arrival price (mid)')]"), "Arrival price (mid)");
        softAssert.assertTrue(SummaryPage.isElementPresent("//*[contains(text(),'Arrival price (market)')]"), "The menu Arrival price (market) is absent");
        softAssert.assertTrue(SummaryPage.isElementPresent("//*[contains(text(),'Execution by market')]"), "The menu Execution by market is absent");
        softAssert.assertAll();
    }
}
