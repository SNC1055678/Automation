package com.ybl.utils;

import java.io.IOException;
import java.util.Properties;

public class configLoader {

    private  final Properties properties;
    private static configLoader configloader;

    private configLoader() throws IOException {
        properties = PropertyUtils.propertiesLoader("src/test/resources/config.properties");
    }

    public static configLoader getInstance() throws IOException {
        if(configloader == null)
        {
            configloader = new configLoader();
        }
        return configloader;
    }

    public String getClientId()
    {
        String prop = properties.getProperty("client_id");
        if(prop != null)
            return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }
    //configLoader.getInstance().getClientId();
}
