package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeamlesslyLoginPage {
    public SeamlesslyLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement input_username;
    @FindBy(id = "password")
    public WebElement input_password;
    @FindBy(id = "submit-form")
    public WebElement btn_login;



    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        input_username.sendKeys(ConfigurationReader.getProperty("username"));
        input_password.sendKeys(ConfigurationReader.getProperty("password"));
        btn_login.click();
    }
}
