package com.ybl.tests;

import java.lang.Error;

import com.ybl.api.StatusCode;
import com.ybl.api.UserApi.UserApiUpdated;
import com.ybl.pojo.UsersPojo;
import com.ybl.utils.dataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.ybl.utils.GenericMethods.assertStatusCode;
import static com.ybl.utils.GenericMethods.userListBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;




@Epic("ReqRes API")
@Feature("Users_Employees")
public class UserAPITest {


    @Story("To Post to create a user Story")
    @Link("https://example.org")
    @Link(name="allure", type ="mylink")
    @TmsLink("34567")
    @Issue("Defect12345")
    @Description("This is the description")
    @Test(description = "POST method to create a new User")
    public void toCreateUser() throws IOException {
        UsersPojo requsersPojo;
        requsersPojo = userListBuilder(dataLoader.getInstance().UserName(),dataLoader.getInstance().UserJob());
        //Username=morpheus job=leader

        Response response = UserApiUpdated.post(requsersPojo);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        //UsersPojo responseUser = response.as(UsersPojo.class);
        //assertUserList(requsersPojo, responseUser);

//        assertThat(responseUser.getName(), equalTo(requsersPojo));
//        assertThat(responseUser.getJob(), equalTo(requsersPojo.getJob()));

    }




    @Story("To Get a user Story")
    @Link("https://example.org")
    @Link(name="allure", type ="mylink")
    @TmsLink("34567")
    @Issue("SD12345")
    @Description("This is the description")
    @Test(description = "Get method to fetch data of User")
    public void toCreateGetUser() throws IOException {

        Response response = UserApiUpdated.get(dataLoader.getInstance().Get_user_id());

        assertStatusCode(response.statusCode(),StatusCode.CODE_200);

      //  assertThat(response.statusCode(), equalTo(200));

//       UsersPojo responseUser = response.as(UsersPojo.class);
//        assertThat(responseUser.getName(), equalTo(requsersPojo));
//        assertThat(responseUser.getJob(), equalTo(requsersPojo.getJob()));

    }


    @Story("To Update a user Story")
    @Link("https://example.org")
    @Link(name="allure", type ="mylink")
    @TmsLink("34567")
    @Issue("SD12345")
    @Description("This is the description")
    @Test(description = "PUT method for Update the data")
    public void toUpdatePlaylist() throws IOException {

        UsersPojo requsersPojo;
        requsersPojo = userListBuilder(dataLoader.getInstance().UserName(),dataLoader.getInstance().UpdateUserJob());
       // Username=morpheus Updatejob=zion resident
        Response response = UserApiUpdated.update(dataLoader.getInstance().Update_user_id(), requsersPojo);

        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
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
