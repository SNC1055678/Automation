package com.ybl.utils;

import com.ybl.api.StatusCode;
import com.ybl.pojo.UsersPojo;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GenericMethods {

    public static UsersPojo userListBuilder(String name, String job)
    {
        /*return UsersPojo.builder().
                name(name).
                job(job).
                build();
        */
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setJob(job);
        return usersPojo;

        // return new UsersPojo().setName(name).setJob(job);
    }

    public static void assertUserList(UsersPojo requsersPojo, UsersPojo responseUserPojo)
    {

        assertThat(responseUserPojo.getName(), equalTo(requsersPojo));
        assertThat(responseUserPojo.getJob(), equalTo(requsersPojo.getJob()));

    }

    public static void assertError(Error responseError, int expectedStatusCode, String expectedMessage)
    {
        //assertThat(responseError.getStatus() ,equalTo(expectedStatusCode));
        assertThat(responseError.getMessage(), equalTo(expectedMessage));
    }
    @Step
    public static void assertStatusCode(int actualStatusCode, StatusCode expectedStatusCode)
    {
        assertThat(actualStatusCode, equalTo(expectedStatusCode.getCode()));
    }

}
