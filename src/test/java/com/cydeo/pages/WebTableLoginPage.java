package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement input_username;
    @FindBy(name = "password")
    public WebElement input_password;
    @FindBy(tagName = "button")
    public WebElement btn_login;

    /**
     * This method will log in with below credentials
     * @username : Test
     * @password : Tester
     */
    public void login(){
        this.input_username.sendKeys("Test");
        this.input_password.sendKeys("Tester");
        this.btn_login.click();
    }

    public void login(String user, String pass){
        this.input_username.sendKeys(user);
        this.input_password.sendKeys(pass);
        this.btn_login.click();
    }
}
