package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class Pathandqueryparam
{
	@Test
	void testqueryandpathparam()
	{
		given()
	   // .pathParam("mypath1","api")
		.pathParam("mypath","users")//path param
		.queryParam("page",2) //query param
		.queryParam("id",5)
	.when()
		.get("https://reqres.in/api/{mypath}")
	.then()
		.statusCode(200)
		.log().all();

}
}
