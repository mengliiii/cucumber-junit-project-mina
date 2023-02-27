package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class Driver {


    //singleton design pattern==> return same driver instance all the time to us

    //1- create a private constructor===> cant create obj from this class


    private Driver(){}

    //2- create WebDriver object

    //private static WebDriver driver;------old one
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    //3- create a static method to return driver

    public static WebDriver getDriver(){

        if (driverPool.get()==null){              //if driver is null, we instantiate the driver

            String browserType=ConfigurationReader.getProperty("browser");

           // WebDriverManager.chromeDriver().setup();========we dont need webdriver manager anymore!!!!!

           switch (browserType){
               case "chrome":
                   driverPool.set(new ChromeDriver());
                   break;
               case "firefox":
                   driverPool.set(new FirefoxDriver());
                   break;
           }

           driverPool.get().manage().window().maximize();

           driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
            //driver=null;//we assign driver back to null, so that my singleton can crate a newer one if needed

        }
    }

}
