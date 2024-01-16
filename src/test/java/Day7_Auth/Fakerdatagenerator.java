package Day7_Auth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Fakerdatagenerator
{
	@Test(priority=1)
	void testgeneratedummydata()
	{
		
		Faker faker = new Faker();
		
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		
		String username=faker.name().username();
		String password=faker.internet().password();
		
		String phone=faker.phoneNumber().cellPhone();
		String email=faker.internet().emailAddress();
		String cardnum= faker.business().creditCardNumber();
		
		System.out.println(" full name:"+fullname);
		System.out.println(" First name :"+firstname);
		System.out.println(" Last name:"+lastname);
		System.out.println(" Username:"+username);
		System.out.println(" Password:"+password);
		System.out.println(" Phone:"+phone);
		System.out.println(" Email:"+email);
		System.out.println(" Card number"+cardnum);
		
		
		
		
		
	}

}
