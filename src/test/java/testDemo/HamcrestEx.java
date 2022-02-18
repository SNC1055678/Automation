package testDemo;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class HamcrestEx {
	
	
	
	@Test (priority=3)
	public void TextAssert3()
	{
		RestAssured.baseURI="https://reqres.in";
		
		given().get("/api/users?page=2").then().assertThat()
		.body("data.last_name[1]", equalToIgnoringCase("ferguson"))
		.and().body("data.first_name[0]", equalTo("Michael"));
		
	}
	
	
	@Test (priority=2)
	
	public void TextAssert2()
	{
		RestAssured.baseURI="https://reqres.in";
		
		given().get("/api/users/2").then().assertThat()
		
		.body("data", hasKey("first_name"))
		.and().body("data", hasValue("Weaver"));
	}
	

	@Test (priority=1)
	public void TextAssert1()
	{
		RestAssured.baseURI="https://reqres.in";
		
		given().get("/api/users?page=2").then().assertThat()
		.body("data.last_name[1]", equalToIgnoringCase("Ferguson"))
		.and().body("data.first_name[0]", equalTo("Michael"))
		.and().body("data.first_name", hasItem("Michael"))
		.and().body("data.first_name", hasItems("Michael", "Rachel"));
		
	}
	
	
}
