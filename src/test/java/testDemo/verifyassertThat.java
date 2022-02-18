package testDemo;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
public class verifyassertThat {
	
	@Test
	public void verify()
	{
		List <String>  email, firstname, lastname, avatar;
		List<Integer> id;
		
		RestAssured.baseURI="https://reqres.in";
		
		Response response = given().get("/api/users?page=2");
		email = new ArrayList<String>();
		email = JsonPath.from(response.getBody().asString()).get("data.email");
		
		firstname =  new ArrayList<String>();
		firstname= JsonPath.from(response.getBody().asString()).get("data.first_name");
		
		lastname = new ArrayList<String>();
		lastname = JsonPath.from(response.getBody().asString()).get("data.last_name");
		
		avatar =  new ArrayList<String>();
		avatar = JsonPath.from(response.getBody().asString()).get("data.avatar");
		
		id = new ArrayList<Integer>();
		id = JsonPath.from(response.getBody().asString()).get("data.id");
		
		
		//Assertion
		assertThat((new Object[] {id.get(0), firstname.get(0), lastname.get(0),email.get(0), avatar.get(0)}), is (new Object[] {7, "Michael", "Lawson", "michael.lawson@reqres.in", "https://reqres.in/img/faces/7-image.jpg" }));
	}

}
