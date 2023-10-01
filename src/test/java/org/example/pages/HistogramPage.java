package org.example.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HistogramPage extends BasePage {
    private Logger log = Logger.getLogger(HistogramPage.class);

    By toolTipLocator = By.xpath("//*[@class='tooltip']");
    By intervalLocator =By.xpath("//div/app-intervals-count-autocomplete-control");
    By attributeLocator = By.xpath("//div/deltix-ng-autocomplete");
    List<WebElement> barContainers = Browser.getDriver().findElements(By.xpath("//*[@class='bar_container']/*[last()]"));
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    @Override
    public void openPage() {
        mainMenu.clickOnMenuItem(TopMenuEnum.Histogram);
        log.info("The tab Histogram is successfully opened");
    }

    public void moveToContainer(Integer i){
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement((WebElement) barContainers.get(i), -50, -50);
        actions.build().perform();
        WebElement toolTip = new WebDriverWait(Browser.getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(toolTipLocator));
        log.debug("The mouse is moved to Container");
    }
    public List<String> getBoundaries() throws Exception {
        List<String> borders = new ArrayList<>();
        for (int i = 0; i < barContainers.size(); i++) {
            moveToContainer(i);
            WebElement toolTipContainer = Browser.getDriver().findElement(toolTipLocator);
            borders.add(toolTipContainer.findElement(By.xpath("./div[1]")).getText());
        }
        log.debug("The borders are got"+borders);
        return borders;
    }

    public List<String> getNumberOfOrders() throws Exception {
        List<String> numberOfOrders = new ArrayList<>();
        for (int i = 0; i < barContainers.size(); i++) {
            moveToContainer(i);
            WebElement toolTipContainer = Browser.getDriver().findElement(toolTipLocator);
            numberOfOrders.add(toolTipContainer.findElement(By.xpath("./div[2]")).getText());
        }
        log.debug("The number of orders are got"+numberOfOrders);
        return numberOfOrders;
    }

    public void clickOnContainer() {
        for (int i = 0; i < barContainers.size(); i++) {
            moveToContainer(i);
            Actions actions = new Actions(Browser.getDriver());
            actions.click().perform();
        }
    }
}

