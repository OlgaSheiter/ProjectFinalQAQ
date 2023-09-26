package org.example.elements;

import org.example.enums.TablesSummaryEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Summary {
    private String MENU_TABLE_PATTERN = "//*[contains(text(),'%s')]//following-sibling::div";

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(20);

    public WebElement getTable(TablesSummaryEnum tablesSummaryEnum) {
        String xpath = String.format(MENU_TABLE_PATTERN, tablesSummaryEnum.getValue());
        WebElement summaryTable = new WebDriverWait(Browser.getDriver(), WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return summaryTable;
    }
    public WebElement getElement(String xpath) {
        WebElement Element = new WebDriverWait(Browser.getDriver(), WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return Element;
    }

}
