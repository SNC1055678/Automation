package com.ybl.utils;

import io.qameta.allure.Step;

import java.io.IOException;
import java.util.Properties;

public class dataLoader {

    private  final Properties properties;
    private static dataLoader dataloader;

    private dataLoader() throws IOException {
        properties = PropertyUtils.propertiesLoader("src/test/resources/data.properties");
    }

    public static dataLoader getInstance() throws IOException {
        if(dataloader == null)
        {
            dataloader = new dataLoader();
        }
        return dataloader;
    }

    public String Get_user_id()
    {
        String prop = properties.getProperty("get_user_id");
        if(prop != null)
            return prop;
        else throw new RuntimeException("Property get_user_id is not specified in the data.properties file");
    }
    //configLoader.getInstance().getClientId();

    public String Update_user_id()
    {
        String prop = properties.getProperty("update_user_id");
        if(prop != null)
            return prop;
        else throw new RuntimeException("Property update_user_id is not specified in the data.properties file");
    }

    public String UserName()
    {
        String prop = properties.getProperty("Username");
        if(prop != null)
            return prop;
        else throw new RuntimeException("Property UserName is not specified in the data.properties file");
    }

    public String UserJob()
    {
        String prop = properties.getProperty("job");
        if(prop != null)
            return prop;
        else throw new RuntimeException("Property UserJob is not specified in the data.properties file");
    }

    public String UpdateUserJob()
    {
        String prop = properties.getProperty("Updatejob");
        if(prop != null)
            return prop;
        else throw new RuntimeException("Property Updatejob is not specified in the data.properties file");
    }


}
