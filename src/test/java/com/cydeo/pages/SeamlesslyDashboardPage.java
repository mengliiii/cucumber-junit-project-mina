package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeamlesslyDashboardPage {
    public SeamlesslyDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='expand']//img")
    public WebElement avatar_icon;

    @FindBy(xpath = "//li[@data-id='logout']/a")
    public WebElement btn_logout;
    @FindBy(xpath = "//li[@data-id='settings']/a")
    public WebElement btn_settings;
    @FindBy(tagName = "h3")
    public List<WebElement> profile_settings_labels;
}
