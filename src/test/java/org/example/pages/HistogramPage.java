package org.example.pages;

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

    By toolTipLocator = By.xpath("//*[@class='tooltip']");
    By intervalLocator =By.xpath("//div/app-intervals-count-autocomplete-control");
    By attributeLocator = By.xpath("//div/deltix-ng-autocomplete");
    List<WebElement> barContainers = Browser.getDriver().findElements(By.xpath("//*[@class='bar_container']/*[last()]"));
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    @Override
    public void openPage() {
        topMenu.clickOnMenuItem(TopMenuEnum.Histogram);
    }

    public void moveToContainer(Integer i){
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement((WebElement) barContainers.get(i), -50, -50);
        actions.build().perform();
        WebElement toolTip = new WebDriverWait(Browser.getDriver(), WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(toolTipLocator));
    }
    public List<String> getBoundaries() throws Exception {
        List<String> borders = new ArrayList<>();
        for (int i = 0; i < barContainers.size(); i++) {
            moveToContainer(i);
            WebElement toolTipContainer = Browser.getDriver().findElement(toolTipLocator);
            borders.add(toolTipContainer.findElement(By.xpath("./div[1]")).getText());
        }
        return borders;
    }

    public List<String> getNumberOfOrders() throws Exception {
        List<String> numberOfOrders = new ArrayList<>();
        for (int i = 0; i < barContainers.size(); i++) {
            moveToContainer(i);
            WebElement toolTipContainer = Browser.getDriver().findElement(toolTipLocator);
            numberOfOrders.add(toolTipContainer.findElement(By.xpath("./div[2]")).getText());
        }
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

