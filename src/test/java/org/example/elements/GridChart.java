package org.example.elements;

import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GridChart {
    private String GRID_CELL_PATTERN = "//*[@comp-id='%s']";

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(20);

    public WebElement getGridCell(String idGridCell) {
        String xpath = String.format(GRID_CELL_PATTERN, idGridCell);
        WebElement gridCell = new WebDriverWait(Browser.getDriver(), WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return gridCell;
    }
    public WebElement getElementTableGrid(By tableLocator) {
        WebElement tableGridChart = new WebDriverWait(Browser.getDriver(), WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(tableLocator));
        return tableGridChart;
    }
    public void clickOnGridElement(WebElement webGridElement) {
        webGridElement.click();
    }
}
