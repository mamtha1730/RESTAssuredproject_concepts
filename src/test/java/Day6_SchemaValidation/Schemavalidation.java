package Day6_SchemaValidation;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class Schemavalidation
{
	@Test(priority=1)
	void jsonschemavalidation()
	{
		given()
		
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		
	}

}
