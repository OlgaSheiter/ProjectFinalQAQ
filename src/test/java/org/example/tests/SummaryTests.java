package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.elements.MainMenu;
import org.example.enums.TopMenuEnum;
import org.example.pages.SummaryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(ResultListenerTests.class)
public class SummaryTests extends BaseTest {

    private String buttonSettingsLocator = "//*[@title='Settings']";

    SummaryPage summaryPage;

    @BeforeMethod
    public void openSummaryPage() {
        summaryPage = new SummaryPage();
        summaryPage.openPage();
    }

    @Epic("Smoke Tests")
    @Feature("SummaryPage")
    @Test(groups = "TC01", priority =1)
    @Description("TC01:Login and check main components")
    @Step("Presence of element menu Summary")
    public void topMenuPresentTest() throws Exception {
        MainMenu mainMenu = new MainMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(summaryPage.isItemTopMenuPresent(TopMenuEnum.Summary), "The menu Summary is absent");
        softAssert.assertTrue(summaryPage.isItemTopMenuPresent(TopMenuEnum.Grid), "The menu Grid is absent");
        softAssert.assertTrue(summaryPage.isItemTopMenuPresent(TopMenuEnum.Histogram), "The menu Histogram is absent");
        softAssert.assertTrue(summaryPage.isItemTopMenuPresent(TopMenuEnum.Scatter), "The menu Scatter is absent");
        softAssert.assertTrue(summaryPage.isItemTopMenuPresent(TopMenuEnum.Reports), "The menu Reports is absent");
        softAssert.assertAll();
    }

    @Test(groups = "TC01", priority =1)
    @Description("TC01:Login and check main components")
    @Step("Presence of element button Settings")
    public void buttonSettingsPresentTest() throws Exception {
        Assert.assertTrue(SummaryPage.isElementPresent(buttonSettingsLocator), "The button Settings is absent");
    }

    @Test(groups = "TC01", priority =1)
    @Description("TC01:Login and check main components")
    @Step("Presence of items of menu Benchmark Selector")
    public void menuBenchmarkSelectorPresent() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        summaryPage.clickQWAPButton();
        softAssert.assertTrue(summaryPage.IsItemMenuQWAPPresent("VWAP"), "The menu VWAP is absent");
        softAssert.assertTrue(summaryPage.IsItemMenuQWAPPresent("QWAP"), "The menu QWAP is absent");
        softAssert.assertTrue(summaryPage.IsItemMenuQWAPPresent("Arrival price (mid)"), "The menu Arrival price (mid) is absent");
        softAssert.assertTrue(summaryPage.IsItemMenuQWAPPresent("Arrival price (market)"), "The menu Arrival price (market) is absent");
        softAssert.assertTrue(summaryPage.IsItemMenuQWAPPresent("Execution by market"), "The menu Execution by market is absent");
        softAssert.assertAll();
    }
}
