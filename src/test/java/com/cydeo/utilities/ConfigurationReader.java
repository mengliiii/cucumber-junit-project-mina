package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- create a property object to read file

    private static Properties properties = new Properties();

    //private: limit access to only this class
    //static to be able to access inside the static block
    //static block only accept static memeber
    //we need to use try catch block=====>has to be inside block, to use
    //solve the checked exception

    //2- create FileInputStream object to open the file
    static {
        try{

            FileInputStream file = new FileInputStream("configuration.properties");

     //3- load the file to the properties object
            properties.load(file);

        }catch (IOException e){
            System.out.println("File not found with the given path");
        }

    }

    //4- create a static method to return the property value, with the given KEY

    public static String getProperty( String keyword){
        return properties.getProperty(keyword);
    }



}
