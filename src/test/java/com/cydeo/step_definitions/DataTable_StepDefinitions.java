package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class DataTable_StepDefinitions {

    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {
        //the tables we write at feature file , between the pipes
        //will be add automatically inside the parameter list of string
        //fruitsAndVegetables = [orange, apple, kiwi, strawberry, tomato, pear, eggplant]

        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);
    }


    @Then("user should see below pet list")
    public void userShouldSeeBelowPetList(List<String> pets) {
        System.out.println("pets = " + pets);
    }

    @Then("officer is able to see any data he wants")
    public void officerIsAbleToSeeAnyDataHeWants(Map<String, String> driverInfoMap) {
        System.out.println("dirverInfoMap = " + driverInfoMap);
        System.out.println("driverInfoMap.get(\"phone\") = " + driverInfoMap.get("phone"));
        System.out.println("driverInfoMap.get(\"name\") = " + driverInfoMap.get("name"));
    }

    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }

    DropdownPage dropdownPage = new DropdownPage();

    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInMonthDropdown(List<String> expectedMonths) {

        dropdownPage.monthDropdown.click();

        List<String> actualMonths = BrowserUtils.convertDropdownOptionsToListOfString(dropdownPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths);


    }
}
