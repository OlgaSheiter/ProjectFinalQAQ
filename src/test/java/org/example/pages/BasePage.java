package org.example.pages;

import org.example.elements.Summary;
import org.example.elements.MainMenu;



public abstract class BasePage {

    public abstract void openPage();
    MainMenu mainMenu = new MainMenu();
    static Summary summaryTables = new Summary();


}
