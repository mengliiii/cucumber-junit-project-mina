package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //we will be able to create pre and post condition for all the scenarios and even steos


    @Before(order = 1)//import from cucumber,  not junit
    public void setupMethod() {
        System.out.println("from Hook class---> @Before: Running before each scenario");

    }
    @Before(value = "@login",order = 2)//this before is only for the @login, order only for login funcBy
    public void loginScenarioBefore() {
        System.out.println("from Hook class---> @Before: Running before each scenario");

    }
    @After  //will be executed automatically after every scenario in the project
    public void tearDownMethod(Scenario scenario) {

        //Scenario obj keeping track of the on executing scenario, name, status

        if (scenario.isFailed()){//if scenario failed, take screenshots

            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }


        BrowserUtils.sleep(2);
        System.out.println("from Hook class---> @After: Running after each scenario");

        Driver.closeDriver();
    }



    //@BeforeStep
    public void setupStep(){
        System.out.println("@BeforeStep: Running before each step");
    }
    //@AfterStep
    public void tearDownStep(){
        System.out.println("@AfterStep: Running after each step");
    }
}
