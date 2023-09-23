package org.example.pages;

import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class ScatterplotPage extends BasePage {
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
    By attributeXLocator = By.xpath("//div[contains(text(),'X ')]/following-sibling::deltix-ng-autocomplete");
    private static final String ITEM_DROPDOWN_PATTERN = "//li[contains(@title,'%s')]";
    By attributeYLocator = By.xpath("//div[contains(text(),'Y ')]/following-sibling::deltix-ng-autocomplete");
    By intervalsLocator = By.xpath("//div/app-intervals-count-autocomplete-control");
    By diagramLocator = By.xpath("//*[@class='scatter-plot']");


    @Override
    public void openPage() {
        topMenu.clickOnMenuItem(TopMenuEnum.Scatter);
    }

    public void setXAttribute(String xAttribute) throws Exception {
        Browser.getDriver().findElement(attributeXLocator).click();
        String xpathPointDropdown = String.format(ITEM_DROPDOWN_PATTERN, xAttribute);
        Browser.getDriver().findElement(By.xpath(xpathPointDropdown)).click();
    }

    public void setYAttribute(String yAttribute) throws Exception {
        Browser.getDriver().findElement(attributeYLocator).click();
        String xpathPointDropdown = String.format(ITEM_DROPDOWN_PATTERN, yAttribute);
        Browser.getDriver().findElement(By.xpath(xpathPointDropdown)).click();
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
