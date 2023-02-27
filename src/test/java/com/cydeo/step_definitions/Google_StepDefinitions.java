package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();


    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user should see the title is Google")
    public void user_should_see_the_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.closeDriver();

    }




    @When("user searches for {string}")//never touch this part
    public void userSearchesFor(String searchKey) {//parameter name can be changed
        googleSearchPage.searchBox.sendKeys(searchKey + Keys.ENTER);
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String arg0) {
        BrowserUtils.verifyTitle(arg0);
    }
}
