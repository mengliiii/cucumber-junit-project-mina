package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Etsy_StepDefinitions {
    EtsyHomePage etsyHomePage = new EtsyHomePage();
    @Given("user is on the Etsy home page")
    public void userIsOnTheEtsyHomePage() {
        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("user should see tile is as expected")
    public void userShouldSeeTileIsAsExpected() {
        String expectedTitle="Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        //inspect page and search //title
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @Then("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        etsyHomePage.searchBox.sendKeys("Wooden Spoon");

    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        etsyHomePage.btn_search.click();
    }

    @Then("User sees Wooden Spoon is in the title")
    public void userSeesWoodenSpoonIsInTheTitle() {
        BrowserUtils.verifyTitle("Wooden spoon - Etsy");
    }

    @Then("User types {string} in the search box")
    public void userTypesInTheSearchBox(String searchValue) {
        etsyHomePage.searchBox.sendKeys(searchValue);

    }

    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String expectedTitle) {
        BrowserUtils.verifyTitleContains(expectedTitle);
    }
}
