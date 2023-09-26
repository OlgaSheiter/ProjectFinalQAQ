package org.example.tests;

import org.example.pages.GridAndChartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ResultListenerTests.class)
public class GridAndChartTests extends BaseTest {
    GridAndChartPage gridAndChartPage;

    @BeforeMethod
    public void openGridAndChartPage() {
        gridAndChartPage = new GridAndChartPage();
        gridAndChartPage.openPage();
    }

    @Test(groups = "TC14")
    public void tooltipMatchesAvgFillPriceFromGridTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getAvgFillPriceFromGrid(), gridAndChartPage.getTextTooltip("AVERAGE_EXECUTION_PRICE"), "AvgFillPrice from Grid does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    public void tooltipMatchesAvgFillPriceFromLegendTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getAvgFillPriceFromLegend(), gridAndChartPage.getTextTooltip("AVERAGE_EXECUTION_PRICE"), "AvgFillPrice from Legend does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    public void tooltipMatchesAvgFillPriceExecPriceTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getExecPrice(), gridAndChartPage.getTextTooltip("AVERAGE_EXECUTION_PRICE"), "Value of Exec Price does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    public void tooltipMatchesAvgFillPriceMidPriceTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.clickOnRandomRow();
        Assert.assertEquals(gridAndChartPage.getMidPriceFromLegend(), gridAndChartPage.getTextTooltip("MID_PRICE"), "Value of Mid Price does not match Tooltip from Chart");
    }

    @Test(groups = "TC14")
    public void colorTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.clickOnRandomRow();
        gridAndChartPage.getColorFromTooltip("MID_PRICE");
        Assert.assertEquals(gridAndChartPage.getColorFromTooltip("MID_PRICE"), gridAndChartPage.getColorFromMidPriceLegend(), "color of tooltip Mid Price does not matches with color Mid Price in legend");
    }

    @Test(groups = "TC46")
    public void filterColumnVisibilityTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.clickOnItemOfFilter("Id");
        Assert.assertFalse(gridAndChartPage.IsHeaderPresent("Id"),"The column Id does not disappear");
        gridAndChartPage.clickOnItemOfFilter("Id");
        Assert.assertTrue(gridAndChartPage.IsHeaderPresent("Id"),"The column Id does not appear");
    }
    @Test(groups = "TC46")
    public void toolPanelColumnVisibilityTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.openToolPanel();
        gridAndChartPage.clickOnItemOfToolPanel("Side");
        Assert.assertFalse(gridAndChartPage.IsHeaderPresent("Side"),"The column Side does not disappear");
        gridAndChartPage.clickOnItemOfToolPanel("Side");
        Assert.assertTrue(gridAndChartPage.IsHeaderPresent("Side"),"The column Side type does not appear");
    }
    @Test(groups = "TC46")
    public void filterFromGridColumnVisibilityTest() throws Exception {
        gridAndChartPage.openPage();
        gridAndChartPage.openFilterVisibilityColumnFromGrid("Id");
        gridAndChartPage.clickOnItemOfFilterVisibilityFromGrid("Start time");
        Assert.assertFalse(gridAndChartPage.IsHeaderPresent("Start time"),"The column Start time does not disappear");
        gridAndChartPage.clickOnItemOfFilterVisibilityFromGrid("Start time");
        Assert.assertTrue(gridAndChartPage.IsHeaderPresent("Start time"),"The column Start time type does not appear");

    }

}