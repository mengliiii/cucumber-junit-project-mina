package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaHomePage {

    public WikipediaHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;

    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    @FindBy(xpath = "(//div[@class='fn'])")
    public WebElement imageHeader;
    ////div[@class='fn']

}
