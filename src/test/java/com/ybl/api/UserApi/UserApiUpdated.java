package com.ybl.api.UserApi;

import com.ybl.api.RestResource;
import com.ybl.pojo.UsersPojo;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.ybl.api.Route.*;
import static io.restassured.RestAssured.given;

public class UserApiUpdated {

    public static Response post(UsersPojo requestUser) {
        return RestResource.post(API + USERS + "/", requestUser);
    }
    @Step
    public static Response get(String userId) {
        return RestResource.get(API + USERS + "/" + PAGE +"="+ userId);
    }



    public static Response update(String userId, UsersPojo requestUser)
    {
        return RestResource.update(API+USERS+"/"+userId, requestUser );

    }



}
