package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.example.pages.GridAndChartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ResultListenerTests.class)
public class GridAndChartTests extends BaseTest {
    Logger log = Logger.getLogger(GridAndChartTests.class);
    GridAndChartPage gridAndChartPage;
    @Epic("Smoke Tests")
    @Feature("GridAndChartPage")
    @BeforeMethod
    public void openGridAndChartPage() {
        gridAndChartPage = new GridAndChartPage();
        gridAndChartPage.openPage();
    }

    @Test(groups = "TC14")
    @Description("TC14:Check Avg fill price and Mid price")
    @Step("Check that tooltip matches Avg Fill Price from grid")
    public void tooltipMatchesAvgFillPriceFromGridTest() throws Exception {

        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getAvgFillPriceFromGrid(), gridAndChartPage.getTextTooltip("AVERAGE_EXECUTION_PRICE"), "AvgFillPrice from Grid does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    @Description("TC14:Check Avg fill price and Mid price")
    @Step("Check that tooltip matches Avg Fill Price from Legend")
    public void tooltipMatchesAvgFillPriceFromLegendTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getAvgFillPriceFromLegend(), gridAndChartPage.getTextTooltip("AVERAGE_EXECUTION_PRICE"), "AvgFillPrice from Legend does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    @Description("TC14:Check Avg fill price and Mid price")
    @Step("Check that tooltip matches Avg Fill Price to Exec Price")
    public void tooltipMatchesAvgFillPriceExecPriceTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getExecPrice(), gridAndChartPage.getTextTooltip("AVERAGE_EXECUTION_PRICE"), "Value of Exec Price does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    @Description("TC14:Check Avg fill price and Mid price")
    @Step("Check that tooltip matches Avg Fill Price to Mid Price")
    public void tooltipMatchesAvgFillPriceMidPriceTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getMidPriceFromLegend(), gridAndChartPage.getTextTooltip("MID_PRICE"), "Value of Mid Price does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    @Description("TC14:Check Avg fill price and Mid price")
    @Step("Check that  color of tooltip matches color of square")
    public void colorTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.clickOnRandomRow();
        gridAndChartPage.getColorFromTooltip("MID_PRICE");
        Assert.assertEquals(gridAndChartPage.getColorFromTooltip("MID_PRICE"), gridAndChartPage.getColorFromMidPriceLegend(), "color of tooltip Mid Price does not matches with color Mid Price in legend");
    }

    @Test(groups = "TC46")
    @Description("TC46:Check column visibility")
    @Step("Verification of visibility of column if use filter")
    public void filterColumnVisibilityTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.clickOnItemOfFilter("Id");
        Assert.assertFalse(gridAndChartPage.IsHeaderPresent("Id"),"The column Id does not disappear");
        gridAndChartPage.clickOnItemOfFilter("Id");
        Assert.assertTrue(gridAndChartPage.IsHeaderPresent("Id"),"The column Id does not appear");
    }
    @Test(groups = "TC46")
    @Description("TC46:Check column visibility")
    @Step("Verification of visibility of column if use tool panel")
    public void toolPanelColumnVisibilityTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.openToolPanel();
        gridAndChartPage.clickOnItemOfToolPanel("Side");
        Assert.assertFalse(gridAndChartPage.IsHeaderPresent("Side"),"The column Side does not disappear");
        gridAndChartPage.clickOnItemOfToolPanel("Side");
        Assert.assertTrue(gridAndChartPage.IsHeaderPresent("Side"),"The column Side type does not appear");
    }
    @Test(groups = "TC46")
    @Description("TC46:Check column visibility")
    @Step("Verification of visibility of column if use filter from grid")
    public void filterFromGridColumnVisibilityTest() throws Exception {
        gridAndChartPage.openPage();
        log.info("The page GridAndChart is successfully opened");
        gridAndChartPage.openFilterVisibilityColumnFromGrid("Id");
        gridAndChartPage.clickOnItemOfFilterVisibilityFromGrid("Start time");
        Assert.assertFalse(gridAndChartPage.IsHeaderPresent("Start time"),"The column Start time does not disappear");
        gridAndChartPage.clickOnItemOfFilterVisibilityFromGrid("Start time");
        Assert.assertTrue(gridAndChartPage.IsHeaderPresent("Start time"),"The column Start time type does not appear");

    }

}