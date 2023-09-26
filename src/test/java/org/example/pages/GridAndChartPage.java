package org.example.pages;

import org.apache.log4j.Logger;
import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;


public class GridAndChartPage extends BasePage {
    private Logger log = Logger.getLogger(this.getClass());
    private By gridTableLocator = By.xpath("//div[@class='flex-1 post-trade__grid post-trade__grid_fullscreen']");
    private By linesLocator = By.xpath("//span[contains(text(),'+ Lines')]");
    private By avgFillPriceLegendLocator = By.xpath("//div[1]/div/div[@class='legend-container__item-value']");
    private By midPriceLegendLocator = By.xpath("//div[2]/div/div[@class='legend-container__item-value']");

    private By midPriceColorLocator = By.xpath("//div[2]/div/div[@class='legend-container__square']");
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    private static final String ITEM_TOOLTIP_PATTERN = "//*[@class='dc-y-axis-label-container dc-y-axis-label-container-%s']";

    private static final String ITEM_FILTER_PATTERN = "//div[1]/div/*[@title='%s']/preceding-sibling::span";


    String dataOfSelectedRow;

    @Override
    public void openPage() {
        mainMenu.clickOnMenuItem(TopMenuEnum.Grid);
        log.info("The tab Grid & Chart is successfully opened");
    }

    ;

    public void clickOnRandomRow() throws Exception {
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(Browser.getDriver().findElement(gridTableLocator), -50, -50);
        Thread.sleep(5000);
        actions.click().build().perform();
        dataOfSelectedRow = Browser.getDriver().findElement(By.xpath("//div[@class='chart-view__info mb-2 hidden-text']/div")).getText();
    }

    public String getAvgFillPriceFromGrid() throws Exception {
        String id = dataOfSelectedRow.substring(5, 19);
        String avgFillPriceFromGrid = Browser.getDriver().findElement(By.xpath("//*[@row-id='" + id + "']/div[@col-id='averageFillPrice']/span")).getText();
        return avgFillPriceFromGrid;
    }

    public String getAvgFillPriceFromLegend() throws Exception {
        String avgFillPriceFromLegend = String.valueOf(Browser.getDriver().findElement(avgFillPriceLegendLocator).getText());
        return avgFillPriceFromLegend;
    }

    public String getMidPriceFromLegend() throws Exception {
        String midPriceFromLegend = String.valueOf(Browser.getDriver().findElement(midPriceLegendLocator).getText());
        return midPriceFromLegend;
    }

    public String getTextTooltip(String namePrice) throws Exception {
        String xpathOfTooltip = String.format(ITEM_TOOLTIP_PATTERN, namePrice);
        String textTooltip = Browser.getDriver().findElement(By.xpath(xpathOfTooltip)).getText();
        if (namePrice.equals("MID_PRICE")) {
            textTooltip = textTooltip.substring(5);
        }
        return textTooltip;
    }

    public String getExecPrice() {
        int index = dataOfSelectedRow.indexOf("Exec price:");
        int index2 = dataOfSelectedRow.indexOf(",", index + 13);
        String textExecPrice = dataOfSelectedRow.substring(index + 13, index2);
        return textExecPrice;
    }

    public String getColorFromTooltip(String namePrice) {
        String xpathOfTooltip = String.format(ITEM_TOOLTIP_PATTERN, namePrice);
        String colorTooltip = Browser.getDriver().findElement(By.xpath(xpathOfTooltip + "/*")).getAttribute("fill");
        colorTooltip = colorTooltip.substring(1);
        Color color = new Color(Integer.parseInt(colorTooltip, 16));
        colorTooltip = "" + String.valueOf(color.getRed()) + String.valueOf(color.getGreen()) + String.valueOf(color.getBlue());
        return colorTooltip;
    }

    public String getColorFromMidPriceLegend() {
        String color = Browser.getDriver().findElement(midPriceColorLocator).getAttribute("style");
        String colorMidPrice = color.replaceAll("[^0-9]", "");
        return colorMidPrice;

    }

    public boolean IsHeaderPresent(String header) {
        try {
            if (Browser.getDriver().findElement(By.xpath("//span[@class='ag-header-cell-text' and contains(text(),'" + header + "')]")).isDisplayed()) {
                return true;
            } else return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public void clickOnItemOfFilter(String nameFilter) throws Exception {
        Browser.getDriver().findElement(By.xpath("//button[@title='Filters']")).click();
        mainMenu.waitElementIsDisplayed(By.xpath("//div[1]/div/*[@title='Id']/preceding-sibling::span"));
        Browser.getDriver().findElement(By.xpath("//div[1]/div/*[@title='" + nameFilter + "']/preceding-sibling::span")).click();
    }


    public void openToolPanel(){
        Browser.getDriver().findElement(By.xpath("//*[@class='ag-icon-columns']")).click();
    }
    public void openFilterVisibilityColumnFromGrid(String column){
        Browser.getDriver().findElement(By.xpath("//*[@role='columnheader' and contains(text(),'"+column+"')]/ancestor::div[1]/preceding-sibling::span")).click();
        Browser.getDriver().findElement(By.xpath("//*[@class='ag-icon ag-icon-columns']")).click();
    }
    public void clickOnItemOfToolPanel(String column) {
        Browser.getDriver().findElement(By.xpath("//*[@title='" + column + "']/preceding-sibling::span")).click();
    }
    public void clickOnItemOfFilterVisibilityFromGrid(String column) {
        Browser.getDriver().findElement(By.xpath("//div[@class='ag-menu-column-select-wrapper']//*[@title='Start time']/preceding-sibling::span")).click();
    }
}

