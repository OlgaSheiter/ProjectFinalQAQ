package org.example.pages;

import org.apache.log4j.Logger;
import org.example.enums.TablesSummaryEnum;
import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;


public class SummaryPage extends BasePage {
    private By buttonQWAPLocatorPage = By.xpath("//app-benchmark-selection");
    private static Logger log = Logger.getLogger(SummaryPage.class);
    private static final String ITEM_MENU_BUTTON_QWAP_PATTERN = "//*[contains(text(),'%s')]";


    public boolean IsItemMenuQWAPPresent(String itemMenuButtonQWAP) throws Exception {
        clickQWAPButton();
        String xpathItemMenuQWAP = String.format(ITEM_MENU_BUTTON_QWAP_PATTERN, itemMenuButtonQWAP);
        Browser.getDriver().findElement(By.xpath(xpathItemMenuQWAP)).isDisplayed();
        return true;
    }

    public static boolean isElementPresent(String xpath) {
        summaryTables.getElement(xpath).isDisplayed();
        log.debug("The element in Summary page" + xpath + "is present");
        return true;
    }

    @Override
    public void openPage() {
        mainMenu.clickOnMenuItem(TopMenuEnum.Summary);
        log.info("The tab Summary is successfully opened");
    }

    public boolean isItemTopMenuPresent(TopMenuEnum topMenuEnum) {
        mainMenu.isItemMenuExist(topMenuEnum);
        log.debug("The tab" + topMenuEnum + "is present");
        return true;
    }

    public void clickQWAPButton() {
        Browser.getDriver().findElement(buttonQWAPLocatorPage).click();
        log.debug("The click on QWAP button");
    }


    public void expandTable(TablesSummaryEnum tablesSummaryEnum) {
        summaryTables.getTable(TablesSummaryEnum.AlgoPerformance).click();
    }

}
