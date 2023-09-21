package org.example.pages;

import org.example.elements.GridChart;
import org.example.elements.Summary;
import org.example.elements.TopMenu;



public abstract class BasePage {

    public abstract void openPage();
    TopMenu topMenu = new TopMenu();
    static Summary summaryTables = new Summary();

    GridChart gridChart = new GridChart();

}
