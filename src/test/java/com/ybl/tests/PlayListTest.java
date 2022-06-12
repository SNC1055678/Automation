package com.ybl.tests;

import com.ybl.pojo.UsersPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.ybl.api.SpecBuilder.getRequestSpec;
import static com.ybl.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PlayListTest {


    String access_token = "";




    public void toCreatePlayList()
    {
        /*String payload ="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";*/
        /*UsersPojo requsersPojo = new UsersPojo();
        requsersPojo.setName("New User");
        requsersPojo.setJob("New User's Job description ");


*/

        UsersPojo requsersPojo = new UsersPojo();
                //.setName("New User").setJob("New User's Job description ");
       requsersPojo.setName("New User");
       requsersPojo.setJob("New User's Job description ");


        UsersPojo response = given().spec(getRequestSpec()).
                body(requsersPojo).
                when().post("/api/users").
        then().spec(getResponseSpec()).assertThat().
                statusCode(201).extract().response().as(UsersPojo.class);

        assertThat(response.getName(), equalTo(requsersPojo));
        assertThat(response.getJob(), equalTo(requsersPojo.getJob()));

    }


    public void toCreateGetPlayList()
    {


        given().spec(getRequestSpec()).
                when().get("/api/users?page=2").
                then().spec(getResponseSpec()).
                statusCode(200)
                .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"),
            "data.last_name", hasItems("Lawson","Ferguson", "Funke"));

    }


    public void toUpdatePlaylist()
    {

        String payload ="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";


                given().spec(getRequestSpec()).body(payload).pathParam("job", "zion resident").
                when().
                put("/api/users/2/{job}").
                then().spec(getResponseSpec()).
                assertThat().
                body("job", equalTo("zion resident"));



    }


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




}


