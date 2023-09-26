package org.example.pages;

import org.apache.log4j.Logger;
import org.example.enums.TablesSummaryEnum;
import org.example.enums.TopMenuEnum;


public class SummaryPage extends BasePage {
    private Logger log = Logger.getLogger(this.getClass());


    public static boolean isElementPresent(String xpath) {
        summaryTables.getElement(xpath).isDisplayed();
        return true;
    }

    @Override
    public void openPage() {
        mainMenu.clickOnMenuItem(TopMenuEnum.Summary);
        log.info("The tab Summary is successfully opened");
    }

    public boolean isItemMenuPresent(TopMenuEnum topMenuEnum) {
        mainMenu.isItemMenuExist(topMenuEnum);
        return true;
    }

    public void expandTable(TablesSummaryEnum tablesSummaryEnum) {
        summaryTables.getTable(TablesSummaryEnum.AlgoPerformance).click();
    }

}
