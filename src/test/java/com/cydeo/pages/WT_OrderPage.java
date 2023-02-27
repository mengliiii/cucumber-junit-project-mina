package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WT_OrderPage extends WT_BasePage {

    public WT_OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "product")
    public WebElement productDropdown;

    @FindBy(xpath = "//input[@name='card']")
    public List<WebElement> card_radioBtns;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadioButton;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCardRadioButton;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressRadioButton;
    @FindBy(name = "quantity")
    public WebElement quantity_input;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement customerName_input;
    @FindBy(name = "street")
    public WebElement street_input;
    @FindBy(name = "city")
    public WebElement city_input;
    @FindBy(name = "state")
    public WebElement state_input;
    @FindBy(name = "zip")
    public WebElement zip_input;
    @FindBy(name = "cardNo")
    public WebElement cardNo_input;
    @FindBy(name = "cardExp")
    public WebElement expireDate_input;
    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOder_btn;

    public void selectCardType(String cardType){
        switch (cardType){
            case "Visa":
                this.visaRadioButton.click();
                break;
            case "MasterCard":
                this.masterCardRadioButton.click();
                break;
            case "American Express":
                this.americanExpressRadioButton.click();
                break;
        }
    }
}
