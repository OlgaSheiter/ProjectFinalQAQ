package org.example.pages;

import org.example.enums.TablesSummaryEnum;
import org.example.enums.TopMenuEnum;



public class SummaryPage extends BasePage {


    public static boolean isElementPresent(String xpath) {
        summaryTables.getSummaryElement(xpath).isDisplayed();
        return true;
    }

    @Override
    public void openPage() {
        topMenu.clickOnMenuItem(TopMenuEnum.Summary);
    }

    public boolean isItemMenuPresent(TopMenuEnum topMenuEnum) {
        topMenu.isItemMenuExist(topMenuEnum);
        return true;
    }

    public void expandTable(TablesSummaryEnum tablesSummaryEnum) {
        summaryTables.getTable(TablesSummaryEnum.AlgoPerformance).click();
    }

}
