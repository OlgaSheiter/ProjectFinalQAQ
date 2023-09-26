package org.example.pages;

import org.example.utility.Browser;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import static org.example.utility.Browser.getProjectProperties;


public class LoginPage extends BasePage {
    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public void openPage() {
        Browser.getDriver().get(getProjectProperties().getProperty("siteUrl"));
        Browser.getDriver().manage().window().maximize();
        Browser.getDriver().findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(getProjectProperties().getProperty("userName"));
        Browser.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(getProjectProperties().getProperty("userPassword"));
        Browser.getDriver().findElement(By.xpath("//button")).click();
        log.info("The user has successfully logged in");
    }

}
