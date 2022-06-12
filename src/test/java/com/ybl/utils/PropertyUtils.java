package com.ybl.utils;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertiesLoader(String filePath) throws IOException {

        Properties properties = new Properties();
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                throw new RuntimeException("Failed to load properties file"+filePath);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Properties file not found at "+filePath);
        }
        return properties;
    }

}