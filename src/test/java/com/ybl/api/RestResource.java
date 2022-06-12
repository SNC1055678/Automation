package com.ybl.api;

import com.ybl.pojo.UsersPojo;
import io.restassured.response.Response;

import static com.ybl.api.SpecBuilder.getRequestSpec;
import static com.ybl.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object requestUser)    //add String token if required
    {

        return given().spec(getRequestSpec()).
                body(requestUser).                       //auth().oauth2()[for add token instead of add headers]
                when().post(path).             //"/api/users"
                then().spec(getResponseSpec()).extract().response();
    }
    public static Response get(String path)     //add String token
    {
        return given(getRequestSpec()).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().response();

    }

    public static Response update(String path, Object requestUser)
    {
        return given().spec(getRequestSpec()).body(requestUser).
                when().
                put(path).
                then().spec(getResponseSpec()).
                extract().response();


    }

}

