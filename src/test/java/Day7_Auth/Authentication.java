package Day7_Auth;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Authentication 
{
//Basic , Digest,Premptive,Bearer Token,Oath1.0,2.0,Apikey
	@Test(priority=1)
	void testauth()
	{
		given()
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority=2)
	void testdigestauth()
	{
		given()
			.auth().digest("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority=3)
	void testpreemptiveauth()
	{
		given()
			.auth().preemptive().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority=4)
	void testbearertoken()
	{
		String bearertoken="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";
		
		given()
		  .headers("Authorization","Bearer "+bearertoken)
		.auth().basic("postman","password")
		.when()
			.get("https://github.com/dashboard")
		.then()
			.statusCode(200)
			.log().all();
	}
    
	@Test(priority=5,enabled=false.)
	void testoauth1()
	{
	
		given()
     		//this is for oauth1
			.auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecret")
		.when()
		   .get("url")
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test(priority=6)
	void testoauth2()
	{
		
		given()
			.auth().oauth2("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")
		.when()
		  .get("https://github.com/dashboard")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}
	
	@Test(priority=7)
	void testapiauth()
	{
		
		given()
			.queryParam("appid","d14e68dc9dfc86c3688333720d20f18f")  //appid is API key
			
		.when()
		  .get("api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}


}
