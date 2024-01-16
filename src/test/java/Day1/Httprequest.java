package Day1;

/*Given()
 * content type , set cookies , parameters, add auth , set headers
 * When()
 * get , post , put , delete
 * Then()
 * validation , status code , extract response, extract headers , 
 * cookies and response body
 */
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Httprequest
{
	
	int  id;
	@Test(priority=2)	
	void getusers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	
	}
	@Test(priority=1)
	void createuser()
	{
		HashMap hm=new HashMap();
		hm.put("name", "mamtha");
		hm.put("job", "teacher");
		
		id= given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://reqres.in/api/users")
			  .jsonPath().getInt("id");
		//.then()
//			.statusCode(201)
//			.log().all();
//	
		}
	@Test(priority=3, dependsOnMethods= {"createuser"})
	void updateuser()
	{
		HashMap hm=new HashMap();
		hm.put("name", "ovi");
		hm.put("job", "author");
		
		 given()
			.contentType("application/json")
			.body(hm)
		.when()
			.put("https://reqres.in/api/users/"+id)
			  
		.then()
			.statusCode(200)
			.log().all();
	
	}
	@Test(priority=4, dependsOnMethods= {"createuser"})
	void deleteuser()
	{
		given()
		
		.when()
		 .delete("https://reqres.in/api/users/"+id)
		 
		.then()
			.statusCode(204)
			.log().all();

	}
}
