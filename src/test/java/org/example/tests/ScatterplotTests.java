package org.example.tests;

import org.example.pages.ScatterplotPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;
@Listeners(ResultListenerTests.class)
public class ScatterplotTests extends BaseTest {
    ScatterplotPage scatterplotPage;


    @BeforeMethod
    public void openHistogramPage() {
        scatterplotPage = new ScatterplotPage();
        scatterplotPage.openPage();
    }

    @DataProvider(name = "itemOfDropDown")
    public Object[][] xAttribute() {
        return new Object[][]{
                {"Avg fill price"},
                {"Exec size"},
                {"Num of executions"},
                {"Price"},
                {"Size"},
                {"Execution price volatility"},
                {"Permanent market impact"},
                {"Realized market impact"},
                {"Participation rate"},
                {"Shortfall"},
                {"Multiplier"},
                {"Tick size"},
                {"Currency code"},
                {"Sequence number"},
                {"Db sequence number"},
                {"Benchmark price"},
                {"Price imp. (ticks)"},
                {"Price imp. (amount)"},
        };
    }
    @Test(dataProvider = "itemOfDropDown")
    public void nameAxisXTest(String xAttribute) throws Exception {
        scatterplotPage.setXAttribute(xAttribute);
        Assert.assertEquals(scatterplotPage.getNameXAxis(), xAttribute,  "The name of X axis is not correct if attribute set"+xAttribute);
    }
    @Test(dataProvider = "itemOfDropDown")
    public void nameAxisYTest(String yAttribute) throws Exception {
        scatterplotPage.setYAttribute(yAttribute);
        Assert.assertEquals(scatterplotPage.getNameYAxis(), yAttribute,  "The name of Y axis is not correct if attribute set"+yAttribute);
    }


    @Test(dataProvider = "itemOfDropDown")
    public void updateXAxesTest(String xAttribute)throws Exception{
        List <WebElement> xAxisBefore = scatterplotPage.getListOfValuesXAxis();
        scatterplotPage.setXAttribute(xAttribute);
        List <WebElement> xAxisAfter = scatterplotPage.getListOfValuesXAxis();
        Assert.assertNotEquals(xAxisAfter.toString(), xAxisBefore.toString(),"Values of axis X are not updated if X attribute"+xAttribute);
    }
    @Test(dataProvider = "itemOfDropDown")
    public void updateYAxesTest(String yAttribute)throws Exception{
        List <WebElement> yAxisBefore = scatterplotPage.getListOfValuesYAxis();
        scatterplotPage.setYAttribute(yAttribute);
        List <WebElement> yAxisAfter = scatterplotPage.getListOfValuesYAxis();
        Assert.assertNotEquals(yAxisAfter.toString(), yAxisBefore.toString(),"Values of axis X are not updated if Y attribute"+yAttribute);
    }

}
