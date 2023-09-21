package org.example.tests;

import org.example.pages.ScatterplotPage;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ScatterplotTests extends BaseTest {
    ScatterplotPage scatterplotPage;

    @BeforeMethod
    public void openHistogramPage() {
        scatterplotPage = new ScatterplotPage();
        scatterplotPage.openPage();
    }
    @Test
    public void axisXTest() throws Exception {
        scatterplotPage.setXAttribute("Price");
        Assert.assertEquals(Browser.getDriver().findElement(By.xpath("//*[@class='scatter-plot-x-label']")).getText(),"Price");
    }
    @Test
    public void axisYTest() throws Exception {
        scatterplotPage.setYAttribute("Size");
        Assert.assertEquals(Browser.getDriver().findElement(By.xpath("//*[@class='scatter-plot-y-label']")).getText(),"Size");
    }

    /*@Test
    public void updateXAxesTest()throws Exception{
        List <WebElement> xAsexBefore = scatterplotPage.getListOfXAxes();
        scatterplotPage.setYAttribute("Permanent market impact");
        List <WebElement> xAsesAfter = scatterplotPage.getListOfXAxes();
        Assert.assertNotEquals(xAsesAfter, xAsexBefore,"Values of axes are not updated");
        Thread.sleep(2000);
    }*/

}
