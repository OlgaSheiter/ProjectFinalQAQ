package org.example.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import java.awt.*;
import java.time.Duration;


public class GridAndChartPage extends BasePage {
    private Logger log = Logger.getLogger(this.getClass());
    private By gridTableLocator = By.xpath("//div[@class='flex-1 post-trade__grid post-trade__grid_fullscreen']");
    private By linesLocator = By.xpath("//span[contains(text(),'+ Lines')]");
    private By avgFillPriceLegendLocator = By.xpath("//div[1]/div/div[@class='legend-container__item-value']");
    private By midPriceLegendLocator = By.xpath("//div[2]/div/div[@class='legend-container__item-value']");

    private By midPriceColorLocator = By.xpath("//div[2]/div/div[@class='legend-container__square']");
    private By dataOfOrderSelectedRowLocator=By.xpath("//div[@class='chart-view__info mb-2 hidden-text']/div");
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
    private By buttonFiltersLocator=By.xpath("//button[@title='Filters']");
    private By toolPanelLocator=By.xpath("//*[@class='ag-icon-columns']");

    private By buttonFilterVisibilityColummnFromGrid=By.xpath("//*[@class='ag-icon ag-icon-columns']");

    private static final String ITEM_TOOLTIP_PATTERN = "//*[@class='dc-y-axis-label-container dc-y-axis-label-container-%s']";

    private static final String ITEM_FILTER_PATTERN = "//div[1]/div/*[@title='%s']/preceding-sibling::span";


    String dataOfSelectedRow;

    @Override
    public void openPage() {
        mainMenu.clickOnMenuItem(TopMenuEnum.Grid);
        log.info("The tab Grid & Chart is successfully opened");
    }


@Step
    public void clickOnRandomRow() throws Exception {
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(Browser.getDriver().findElement(gridTableLocator), -50, -50);
        Thread.sleep(5000);
        actions.click().build().perform();
        dataOfSelectedRow = Browser.getDriver().findElement(dataOfOrderSelectedRowLocator).getText();
        log.debug("The data of row is got:"+dataOfSelectedRow);
    }
    @Step
    public String getAvgFillPriceFromGrid() throws Exception {
        String id = dataOfSelectedRow.substring(5, 19);
        String avgFillPriceFromGrid = Browser.getDriver().findElement(By.xpath("//*[@row-id='" + id + "']/div[@col-id='averageFillPrice']/span")).getText();
        log.debug("The data of Avg fill price is got from grid:"+avgFillPriceFromGrid);
        return avgFillPriceFromGrid;
    }
    @Step
    public String getAvgFillPriceFromLegend() throws Exception {
        String avgFillPriceFromLegend = String.valueOf(Browser.getDriver().findElement(avgFillPriceLegendLocator).getText());
        log.debug("The data of Avg fill price from legend is got:"+avgFillPriceFromLegend);
        return avgFillPriceFromLegend;
    }
    @Step
    public String getMidPriceFromLegend() throws Exception {
        String midPriceFromLegend = String.valueOf(Browser.getDriver().findElement(midPriceLegendLocator).getText());
        log.debug("The data of Mid price from legend is got:"+midPriceFromLegend);
        return midPriceFromLegend;
    }
    @Step
    public String getTextTooltip(String namePrice) throws Exception {
        String xpathOfTooltip = String.format(ITEM_TOOLTIP_PATTERN, namePrice);
        String textTooltip = Browser.getDriver().findElement(By.xpath(xpathOfTooltip)).getText();
        if (namePrice.equals("MID_PRICE")) {
            textTooltip = textTooltip.substring(5);
        }
        log.debug("The text of tooltip is got:"+textTooltip);
        return textTooltip;
    }
    @Step
    public String getExecPrice() {
        int index = dataOfSelectedRow.indexOf("Exec price:");
        int index2 = dataOfSelectedRow.indexOf(",", index + 13);
        String textExecPrice = dataOfSelectedRow.substring(index + 13, index2);
        log.debug("The text of Exec Price is got:"+textExecPrice);
        return textExecPrice;
    }
    @Step
    public String getColorFromTooltip(String namePrice) {
        String xpathOfTooltip = String.format(ITEM_TOOLTIP_PATTERN, namePrice);
        String colorTooltip = Browser.getDriver().findElement(By.xpath(xpathOfTooltip + "/*")).getAttribute("fill");
        colorTooltip = colorTooltip.substring(1);
        Color color = new Color(Integer.parseInt(colorTooltip, 16));
        colorTooltip = "" + String.valueOf(color.getRed()) + String.valueOf(color.getGreen()) + String.valueOf(color.getBlue());
        log.debug("The color of tooltip is got:"+colorTooltip);
        return colorTooltip;
    }
    @Step
    public String getColorFromMidPriceLegend() {
        String color = Browser.getDriver().findElement(midPriceColorLocator).getAttribute("style");
        String colorMidPrice = color.replaceAll("[^0-9]", "");
        return colorMidPrice;

    }
    @Step
    public boolean IsHeaderPresent(String header) {
        try {
            if (Browser.getDriver().findElement(By.xpath("//span[@class='ag-header-cell-text' and contains(text(),'" + header + "')]")).isDisplayed()) {
                return true;
            } else return false;
        } catch (Exception ex) {
            log.error("The xpath of header"+header+"does not exist");
            return false;
        }
    }
    @Step
    public void clickOnItemOfFilter(String nameFilter) throws Exception {
        Browser.getDriver().findElement(buttonFiltersLocator).click();
      //  mainMenu.waitElementIsDisplayed(By.xpath("//div[1]/div/*[@title='Id']/preceding-sibling::span"));
        Browser.getDriver().findElement(By.xpath("//div[1]/div/*[@title='" + nameFilter + "']/preceding-sibling::span")).click();
        log.debug("The click on item of filter:"+nameFilter);
    }

    @Step
    public void openToolPanel(){
        Browser.getDriver().findElement(toolPanelLocator).click();
        log.debug("The click on tool panel button:");
    }
    @Step
    public void openFilterVisibilityColumnFromGrid(String column){
        Browser.getDriver().findElement(By.xpath("//*[@role='columnheader' and contains(text(),'"+column+"')]/ancestor::div[1]/preceding-sibling::span")).click();
        Browser.getDriver().findElement(buttonFilterVisibilityColummnFromGrid).click();
    }
    public void clickOnItemOfToolPanel(String column) {
        Browser.getDriver().findElement(By.xpath("//*[@title='" + column + "']/preceding-sibling::span")).click();
    }
    public void clickOnItemOfFilterVisibilityFromGrid(String column) {
        Browser.getDriver().findElement(By.xpath("//div[@class='ag-menu-column-select-wrapper']//*[@title='"+column+"']/preceding-sibling::span")).click();
    }
}

