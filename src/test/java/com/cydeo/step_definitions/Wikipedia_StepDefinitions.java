package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_StepDefinitions {
    WikipediaHomePage wikipediaHomePage = new WikipediaHomePage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaHomePage.searchBtn.click();
    }







    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchValue) {
        wikipediaHomePage.searchBox.sendKeys(searchValue );

    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String expectedTitleText) {
        BrowserUtils.verifyTitleContains(expectedTitleText);

    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String headerText) {
        Assert.assertEquals(headerText,wikipediaHomePage.mainHeader.getText());
    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String imageHeader) {
        Assert.assertEquals(imageHeader, wikipediaHomePage.imageHeader.getText());
    }
}
