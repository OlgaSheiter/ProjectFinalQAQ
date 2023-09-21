package org.example.pages;

import org.example.utility.Browser;
import org.openqa.selenium.By;


import static org.example.utility.Browser.getProjectProperties;


public class LoginPage extends BasePage {

    @Override
    public void openPage() {
            Browser.getDriver().get(getProjectProperties().getProperty("siteUrl"));
            Browser.getDriver().manage().window().maximize();
            Browser.getDriver().findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("selenium_chrome");
            Browser.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Axa@Demo");
            Browser.getDriver().findElement(By.xpath("//button")).click();
    }

}
