package Day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Parsingjsonresponsedata 
{
    @Test(priority=1,enabled=false)
	void testjsonresponse()
	{
    	
    	//Approach1
    	given()
    		.contentType(ContentType.JSON)
    	.when()
    		.get("http://localhost:3000/store")
    	.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("book[3].title",equalTo("Sword of honor"));
	}
    
    //Approach2
    @Test(priority=2,enabled=false)
	void testjsonresponse2()
	{
    	Response res=given()
    		.contentType(ContentType.JSON)
    	.when()
    		.get("http://localhost:3000/store");
    	Assert.assertEquals(res.getStatusCode(),200); //validation1
    	Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
    	String bookname=res.jsonPath().get("book[3].title").toString();
    	Assert.assertEquals(bookname,"Sword of honor");
    }
  //Approach3
    @Test(priority=3,enabled=false)
	void testjsonresponse3()
	{
    	Response res=given()
    		.contentType(ContentType.JSON)
    	.when()
    		.get("http://localhost:3000/store");
    	
    	//JSONObject class
    	JSONObject jo=new JSONObject(res.asString());  //converting response to json object type
    	boolean status=false;
    	for(int i=0;i<jo.getJSONArray("book").length();i++)
    	{
    		String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
//    		String  bookprice=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
//    		System.out.println("Book Title"+"  "+booktitle);
//    		System.out.println("book price"+"     "+bookprice);
            
    		if(booktitle.equals("Sword of honor"))
    		{
    			status= true;
    			break;
    		}
    	}
    	Assert.assertEquals(status, true);
    	
    	}
  //Approach4
    @Test(priority=4)
	void testjsonresponse4()
	{
    	Response res=given()
    		.contentType(ContentType.JSON)
    	.when()
    		.get("http://localhost:3000/store");
    	
    	//JSONObject class
    	JSONObject jo=new JSONObject(res.asString());  //converting response to json object type
    	
    	double totalprice=0;
    	for(int i=0;i<jo.getJSONArray("book").length();i++)
    	{
    		
            String  bookprice=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
    		totalprice=totalprice+Double.parseDouble(bookprice);
    		
       }
    	System.out.println("Total price of books is "+totalprice);
    	Assert.assertEquals(totalprice,681.49);
    	}
    
    
    
	
}
