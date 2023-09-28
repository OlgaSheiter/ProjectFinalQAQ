package org.example.elements;

import org.example.enums.TopMenuEnum;
import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainMenu {

    private static final String MENU_ITEM_PATTERN = "//div[@class='app-title' and contains(text(),'%s')]";
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(5);


    private WebElement getMenuElement(TopMenuEnum topMenuEnum) {
        String xpath = String.format(MENU_ITEM_PATTERN, topMenuEnum.getValue());
        WebElement menuItem = new WebDriverWait(Browser.getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public void clickOnMenuItem(TopMenuEnum topMenuEnum) {
        getMenuElement(topMenuEnum).click();
    }
    public boolean isItemMenuExist(TopMenuEnum topMenuEnum) {
        return getMenuElement(topMenuEnum).isDisplayed();
    }

   public void waitElementIsDisplayed (By elementLocator){
      WebDriverWait wait = new WebDriverWait(Browser.getDriver(),5);
      wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}
