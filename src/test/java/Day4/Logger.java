package Day4;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Logger
{
	
	@Test(priority=1)
	void testjsonresponselogger()
	{
    	
    	
    	given()
    		.contentType(ContentType.JSON)
    	.when()
    		.get("http://localhost:3000/store")
    	.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("book[3].title",equalTo("Sword of honor"));
	}
    

}
