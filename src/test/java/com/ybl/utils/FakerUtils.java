package com.ybl.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerUtils {



        public static String RandomName()
        {
            Faker faker = new Faker();
            return  faker.regexify("[A-Za-z0-9,_]{10}");
        }


        public static String RandomNumber()
    {
        Faker faker = new Faker();
        //System.out.println(faker.regexify("[0-9]{10}"));
        return  faker.regexify("[0-9]{10}");
    }


}
