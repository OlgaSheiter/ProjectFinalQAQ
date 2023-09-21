package org.example.pages;

import org.example.enums.TopMenuEnum;
import org.openqa.selenium.By;

public class GridPage extends BasePage {
    private By gridTableLocator = By.xpath("//div[@class='flex-1 post-trade__grid post-trade__grid_fullscreen']");
    private By linesLocator = By.xpath("//span[contains(text(),'+ Lines')]");
    @Override
    public void openPage(){
        topMenu.clickOnMenuItem(TopMenuEnum.Grid);
    };


}
