package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.pages.HistogramPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(ResultListenerTests.class)
public class HistogramTests extends BaseTest {

    HistogramPage histogramPage;

    @Epic("Smoke Tests")
    @Feature("HistogramPage")
    @BeforeMethod
    public void openHistogramPage() {
        histogramPage = new HistogramPage();
        histogramPage.openPage();
    }


    @Test(groups = "TC04")
    @Description("TC04:Hover over a bar selection")
    @Step("Presence of boundaries")
    public void boundariesTest() throws Exception {
        List<String> borders = histogramPage.getBoundaries();
        for (int i = 0; i < borders.size(); i++) {
            Assert.assertTrue(borders.get(i).matches("Avg fill price: [\\[,\\(]\\d+\\.\\d+, \\d+\\.\\d+[),\\]]"));
        }
    }

    @Test(groups = "TC04")
    @Description("TC04:Hover over a bar selection")
    @Step("Verification of amount of orders")
    public void numberOfOrdersTest() throws Exception {
        List<String> numberOfOrders = histogramPage.getNumberOfOrders();
        for (int i = 0; i < numberOfOrders.size(); i++) {
            Assert.assertTrue(numberOfOrders.get(i).matches("Count: \\d+"));
        }
    }
}
