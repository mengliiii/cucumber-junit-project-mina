package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Bing_StepDef {
    BingSearchPage bingSearchPage = new BingSearchPage();

    @Given("user is on the Bing search page")
    public void userIsOnTheBingSearchPage() {
        Driver.getDriver().get("https://bing.com");
    }

    @When("user searches for orange")
    public void userSearchesForOrange() {
        bingSearchPage.searchBox.sendKeys("Orange");
        bingSearchPage.searchBox.sendKeys(Keys.ENTER);

    }

    @Then("user should see orange in the title")
    public void userShouldSeeOrangeInTheTitle() {
        String expectedTitle="Orange";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
