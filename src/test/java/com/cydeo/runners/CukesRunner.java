package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//to make it runnable
@CucumberOptions(
        plugin = {
                "pretty",       //allows us to print out additional info about which scenario and step is executing on the console
                "html:target/cucumber-reports.html",    //specify our report type-html, Register plugins. Built-in plugin types: junit, htm
                "rerun:target/rerun.txt",               //we want to enable rerun plugins and store txt iniside target
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"

        },
        features = "src/test/resources/features", //specify our features directory path
        glue = "com/cydeo/step_definitions",      //specify our step-definition package path
        dryRun = false,                           //by default its false, to execute scenarios and generate missing snippets
        tags = "",                            //only execute scenarios with matching tag
        publish = true                            //generating a report with public link or not
        //monochrome = true       //colors with pretty
)
public class CukesRunner {
}
