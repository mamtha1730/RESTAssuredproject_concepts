package Day2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Postreqways 
{
//	    post request body using Hashmap
//		using org.json
//		pojo class
//		external json files
/*
		@Test(priority=1)
		void testpostusinghashmap()
		{
			HashMap hm= new HashMap();
			hm.put("name", "Scott");
			hm.put("location","France");
			hm.put("phone","9854885");
			String coursesarr[]= {"science","botany"};
			hm.put("courses", coursesarr);
			
			given()
				.contentType("application/json")
				.body(hm)
			
			.when()
				.post("http://localhost:3000/users")
			
			.then()
			  .statusCode(201)
			  .body("name",equalTo("Scott"))
			  .body("location",equalTo("France"))
			  .body("phone",equalTo("9854885"))
			  .body("courses[0]",equalTo("science"))
			  .header("Content-Type","application/json; charset=utf-8")
			  .log().all();
			
		}
		
		@Test(priority=2)
		void testdelete()
		{
			given()
			.when()
				.delete("http://localhost:3000/users/4")
			.then()
			.statusCode(200);
		}
		//post request using jso.org library
		@Test(priority=1)
		void testpostusingorg()
		{
			JSONObject data=new JSONObject();
			data.put("name","Scott");
			data.put("location","France");
			data.put("phone","9854885");
			
			String coursesarr[]= {"science","botany"};
			
			data.put("courses", coursesarr);
			
			given()
				.contentType("application/json")
				.body(data.toString())
			.when()
				.post("http://localhost:3000/users")
			.then()
				.statusCode(201)
			  .body("name",equalTo("Scott"))
			  .body("location",equalTo("France"))
			  .body("phone",equalTo("9854885"))
			  .body("courses[0]",equalTo("science"))
			  .header("Content-Type","application/json; charset=utf-8")
			  .log().all();
			}
			
			@Test(priority=2)
			void testdelete()
		    {
			given()
			
			.when()
				.delete("http://localhost:3000/users/4")
			.then()
				.statusCode(200);
		     }

			//3)POJO CLAss
			@Test(priority=1)
		    void testpostusingpojoclass()
		    {
			Pojo_postrequest data=new Pojo_postrequest();
			data.setName("Scott");
			data.setLocation("France");
			data.setPhone("9854885");
			String coursesarr[]= {"science","botany"};
			data.setCourses(coursesarr);
			
			given()
				.contentType("application/json")
				.body(data)
			.when()
				.post("http://localhost:3000/users")
			.then()
				.statusCode(201)
			  .body("name",equalTo("Scott"))
			  .body("location",equalTo("France"))
			  .body("phone",equalTo("9854885"))
			  .body("courses[0]",equalTo("science"))
			  .header("Content-Type","application/json; charset=utf-8")
			  .log().all();
			}
			
			@Test(priority=2)
			void testdelete()
		   {
			given()
			
			.when()
				.delete("http://localhost:3000/users/4")
			.then()
				.statusCode(200);
		   }
	*/		
//4)using External JSON files
			@Test(priority=1)
		    void testpostusingexternaljson() throws FileNotFoundException
		    {
				File f=new File(".\\body.json");
				FileReader fr=new FileReader(f);
				JSONTokener  jt= new JSONTokener(fr);
				JSONObject data=new JSONObject(jt);
				
			given()
				.contentType("application/json")
				.body(data.toString())
			.when()
				.post("http://localhost:3000/users")
			.then()
				.statusCode(201)
			  .body("name",equalTo("Scott"))
			  .body("location",equalTo("France"))
			  .body("phone",equalTo("9854885"))
			  .body("courses[0]",equalTo("science"))
			  .header("Content-Type","application/json; charset=utf-8")
			  .log().headers();
			}
			
			@Test(priority=2)
			void testdelete()
		   {
			given()
			
			
			.when()
				.delete("http://localhost:3000/users/4")
			.then()
				.statusCode(200);
		   }
		
}
