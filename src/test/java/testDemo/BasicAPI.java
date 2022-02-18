package testDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BasicAPI {

	//public static void main(String[] args) throws IOException {
	
	
	@Test
	public void TestngAPI() throws IOException
	{
		
		  FileInputStream fileInputStream =new FileInputStream("D:\\Java\\XML file\\postDemo.xml");

	        RestAssured.baseURI="http://www.dneonline.com";

	        Reporter.log("Step 1 baseURI:"+RestAssured.baseURI);
	        Reporter.log("Step 2 Resource:  /calculator.asmx");

	        Response response= 
	                given()
	                .header("Content-Type","text/xml")
	                .and()
	                .body(org.apache.commons.io.IOUtils.toString(fileInputStream,"UTF-8"))
	                .when()
	                .post("/calculator.asmx")
	                .then()
	                .statusCode(200)
	                .and()
	                .log().all().extract().response();


	        Reporter.log("response: "+response.toString());

	        String body=response.getBody().asString();

	        System.out.println("Body: "+body);
	        

	        Reporter.log("DivideResults: "+body);

	    //    XmlPath xmlpath=new XmlPath(response.toString());
	        //    System.out.println("response :"+xmlpath.toString());    


	}

}
