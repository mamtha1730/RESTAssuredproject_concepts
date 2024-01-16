package Day3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Cookiesdemo 
{
	@Test(priority=2)
	void getcookiesinfo()
	{
		
			Response res=given()
		
		.when()
			.get("https://www.google.com/");
		
			}

}
