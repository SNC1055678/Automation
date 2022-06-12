package com.ybl.tests;

import com.ybl.api.UserApi.UserApiUpdated;
import com.ybl.pojo.UsersPojo;
import com.ybl.utils.dataLoader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTestUpdatedBuilder {



    public UsersPojo userListBuilder(String name, String job)
    {
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setJob(job);
        return usersPojo;

       // return new UsersPojo().setName(name).setJob(job);
    }

    public void assertUserList(UsersPojo requsersPojo, UsersPojo responseUserPojo)
    {

        assertThat(responseUserPojo.getName(), equalTo(requsersPojo));
        assertThat(responseUserPojo.getJob(), equalTo(requsersPojo.getJob()));

    }

    public void assertError(Error responseError, int expectedStatusCode, String expectedMessage)
    {
        //assertThat(responseError.getStatus() ,equalTo(expectedStatusCode));
        assertThat(responseError.getMessage(), equalTo(expectedMessage));
    }

    public void assertStatusCode(int actualStatusCode, int expectedStatusCode)
    {
        assertThat(actualStatusCode, equalTo(expectedStatusCode));
    }

    public void toCreateUser()
    {


        UsersPojo requsersPojo = new UsersPojo();
        requsersPojo = userListBuilder("morpheus","leader");

        Response response = UserApiUpdated.post(requsersPojo);
        assertStatusCode(response.statusCode(), 201);
        //UsersPojo responseUser = response.as(UsersPojo.class);
        //assertUserList(requsersPojo, responseUser);

//        assertThat(responseUser.getName(), equalTo(requsersPojo));
//        assertThat(responseUser.getJob(), equalTo(requsersPojo.getJob()));

    }




    public void toCreateGetUser() throws IOException {

        Response response = UserApiUpdated.get(dataLoader.getInstance().Get_user_id());

        assertStatusCode(response.statusCode(),200);

      //  assertThat(response.statusCode(), equalTo(200));

//       UsersPojo responseUser = response.as(UsersPojo.class);
//        assertThat(responseUser.getName(), equalTo(requsersPojo));
//        assertThat(responseUser.getJob(), equalTo(requsersPojo.getJob()));

    }



    public void toUpdatePlaylist() throws IOException {

        UsersPojo requsersPojo = new UsersPojo( );
        requsersPojo = userListBuilder("morpheus","leader");

        Response response = UserApiUpdated.update(dataLoader.getInstance().Update_user_id(), requsersPojo);

        assertStatusCode(response.statusCode(),200);
    }
/*

    @Test
    public void toCreatePlayListWithoutName()
    {
        String payload ="{\n" +
                "    \"name\": \"\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";


        given().spec(getRequestSpec()).
                body(payload).
                when().post("/api/users").
                then().spec(getResponseSpec()).
                statusCode(201).body("error.status", equalTo(null), "job", equalTo("leader"));


    }
*/


}
