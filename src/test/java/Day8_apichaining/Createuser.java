package Day8_apichaining;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Createuser
{
    @Test(priority=1)
	void test_createuser()
	{
    	Faker faker=new Faker();
    	JSONObject data=new JSONObject();
    	data.put("name",faker.name().fullName());
    	data.put("gender", "male");
    	data.put("email" , faker.internet().emailAddress());
    	data.put("Status","inactive");
    	
		
	}
	
}
