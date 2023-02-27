package com.cydeo.step_definitions;

import com.cydeo.pages.WT_ViewAllOrdersPage;
import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class Webtable_StepDefinitions {


WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on Web Table login page")
    public void userIsOnWebTableLoginPage() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    @Then("user enters user name")
    public void userEntersUserName() {
        webTableLoginPage.input_username.sendKeys("Test");

    }

    @And("user enters password")
    public void userEntersPassword() {
        webTableLoginPage.input_password.sendKeys("Tester");
    }

    @And("user clicks to login button")
    public void userClicksToLoginButton() {
        webTableLoginPage.btn_login.click();
    }

    @Then("Verify the URL")
    public void verifyTheURL() {
        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedInUrl="orders";
        Assert.assertTrue(actualUrl.contains(expectedInUrl));
    }

    @Then("user enters {string} as user name and {string} as password")
    public void userEntersAsUserNameAndAsPassword(String username, String password) {
        webTableLoginPage.input_username.sendKeys(username);
        webTableLoginPage.input_password.sendKeys(password);
    }

    @Then("user enters below correct credentials")
    public void userEntersBelowCorrectCredentials(Map<String, String> credentials) {
       //for map to get value===> get( givenKey)===>return value
        webTableLoginPage.input_username.sendKeys( credentials.get("username"));
        webTableLoginPage.input_password.sendKeys(credentials.get("password"));
    }

    @Given("user is already logged in to The Web table app")
    public void userIsAlreadyLoggedInToTheWebTableApp() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        webTableLoginPage.login();

    }
    WT_OrderPage orderPage = new WT_OrderPage();


    @When("user is on the Order page")
    public void userIsOnTheOrderPage() {
        orderPage.orderLink.click();
    }

    @Then("user sees below options under product dropdown")
    public void userSeesBelowOptionsUnderProductDropdown(List<String> expectedOptions) {

        List<String > actualOptions = BrowserUtils.convertDropdownOptionsToListOfString(orderPage.productDropdown);
        Assert.assertEquals(expectedOptions,actualOptions);
    }

    @Then("user sees Visa as enabled payment option")
    public void userSeesVisaAsEnabledPaymentOption() {

        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());

    }

    @Then("user sees MasterCard as enabled payment option")
    public void userSeesMasterCardAsEnabledPaymentOption() {
    //enable option===>isEnabled()
        Assert.assertTrue(orderPage.masterCardRadioButton.isEnabled());

    }

    @Then("user sees American Express as enabled payment option")
    public void userSeesAmericanExpressAsEnabledPaymentOption() {

        Assert.assertTrue(orderPage.americanExpressRadioButton.isEnabled());

    }

    @And("user enters street name {string}")
    public void userEntersStreetName(String street) {
        orderPage.street_input.sendKeys(street);

    }

    @Then("user selects Product {string}")
    public void userSelectsProduct(String selectValue) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByValue(selectValue);
    }

    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {

        orderPage.quantity_input.clear();//clear the option!!!!!!!!!!

        //another option as deleting whatever already in the input box

        //orderPage.inputName.sendKeys(Keys.BACK_SPACE);
        orderPage.quantity_input.sendKeys(quantity);
    }


    @And("user enters customer name {string}")
    public void userEntersCustomerName(String name) {
        orderPage.customerName_input.sendKeys(name);
    }

    @And("user enters city name {string}")
    public void userEntersCityName(String city) {
        orderPage.city_input.sendKeys(city);
    }

    @And("user enters state name {string}")
    public void userEntersStateName(String state) {
        orderPage.state_input.sendKeys(state);
    }

    @And("user enters zip code {string}")
    public void userEntersZipCode(String zip) {
        orderPage.zip_input.sendKeys(zip);
    }

    @And("user selects card type {string}")
    public void userSelectsCardType(String cardType) {
        orderPage.selectCardType(cardType);
    }

    @And("user enters card number {string}")
    public void userEntersCardNumber(String cardNo) {
        orderPage.cardNo_input.sendKeys(cardNo);
    }

    @And("user enters expire date {string}")
    public void userEntersExpireDate(String expireDate) {
        orderPage.expireDate_input.sendKeys(expireDate);
    }

    @And("user clicks to Process Order button")
    public void userClicksToProcessOrderButton() {
        orderPage.processOder_btn.click();
    }




    @Then("user clicks to the calculate button")
    public void userClicksToTheCalculateButton() {
        orderPage.calculateButton.click();
    }
    WT_ViewAllOrdersPage viewAllOrdersPage = new WT_ViewAllOrdersPage();

    @Then("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {
        String actualName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(actualName, expectedName);
    }
}
