package org.example.pages;

import org.apache.log4j.Logger;
import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;


public class ScatterplotPage extends BasePage {

    private Logger log = Logger.getLogger(this.getClass());
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
    By attributeXLocator = By.xpath("//div[contains(text(),'X ')]/following-sibling::deltix-ng-autocomplete");
    private static final String ITEM_DROPDOWN_PATTERN = "//li[contains(@title,'%s')]";
    By attributeYLocator = By.xpath("//div[contains(text(),'Y ')]/following-sibling::deltix-ng-autocomplete");
    By intervalsLocator = By.xpath("//div/app-intervals-count-autocomplete-control");
    By diagramLocator = By.xpath("//*[@class='scatter-plot']");


    @Override
    public void openPage() {
        mainMenu.clickOnMenuItem(TopMenuEnum.Scatter);
        log.info("The tab Scatter-plot is successfully opened");
    }

    public String getNameXAxis(){
       return Browser.getDriver().findElement(By.xpath("//*[@class='scatter-plot-x-label']")).getText();
    }
    public String getNameYAxis(){
        return Browser.getDriver().findElement(By.xpath("//*[@class='scatter-plot-y-label']")).getText();
    }

    public void setXAttribute(String xAttribute) throws Exception {
        Browser.getDriver().findElement(attributeXLocator).click();
        String xpathPointDropdown = String.format(ITEM_DROPDOWN_PATTERN, xAttribute);
        Browser.getDriver().findElement(By.xpath(xpathPointDropdown)).click();
        Thread.sleep(1000);
    }

    public void setYAttribute(String yAttribute) throws Exception {
        Browser.getDriver().findElement(attributeYLocator).click();
        String xpathPointDropdown = String.format(ITEM_DROPDOWN_PATTERN, yAttribute);
        Browser.getDriver().findElement(By.xpath(xpathPointDropdown)).click();
        Thread.sleep(1000);
    }

    public void setIntervals(String intervals) throws Exception {
        Browser.getDriver().findElement(intervalsLocator).click();
        String xpathPointDropdown = String.format(ITEM_DROPDOWN_PATTERN, intervals);
        Browser.getDriver().findElement(By.xpath(xpathPointDropdown)).click();
    }


    public List <WebElement> getListOfValuesXAxis() {
        List <WebElement> xAxes = Browser.getDriver().findElements(By.xpath("//*[@class='x axis']/*[@class]/*[2]"));
        return xAxes;
    }
    public List <WebElement> getListOfValuesYAxis() {
        List <WebElement> yAxes = Browser.getDriver().findElements(By.xpath("//*[@class='y axis']/*[@class]/*[2]"));
        return yAxes;
    }
}
