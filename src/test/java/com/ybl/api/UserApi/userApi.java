package com.ybl.api.UserApi;

import com.ybl.pojo.UsersPojo;
import io.restassured.response.Response;

import static com.ybl.api.Route.*;
import static com.ybl.api.SpecBuilder.getRequestSpec;
import static com.ybl.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class userApi {

    public static Response post(UsersPojo requestUser)
    {
        return given().spec(getRequestSpec()).
                body(requestUser).
                when().post(API+USERS+"/").
                then().spec(getResponseSpec()).extract().response();
    }
    public static Response get(String userId)
    {
        return given(getRequestSpec()).
                when().get(API+USERS+"?"+ PAGE+"="+userId).
                then().spec(getResponseSpec()).
                extract().response();

    }

    public static Response update(String userId, UsersPojo requestUser)
    {
       return given().spec(getRequestSpec()).body(requestUser).
                when().
                put(API+USERS+"/"+userId+"/"+requestUser).
                then().spec(getResponseSpec()).
                extract().response();


    }

}
