package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class testCreateUser {

	Faker fake;
	user userpayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		
		fake = new Faker();
		userpayload = new user();
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setUsername(fake.name().username());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().safeEmailAddress());
		userpayload.setPassword(fake.internet().password(5,10));
		userpayload.setPhone(fake.phoneNumber().cellPhone());
		
		//obtain logger

				logger = LogManager.getLogger("RestAssuredFramework");
					
	}
	
	@Test(priority = 0)
	public void testCreateUser() {
		
		Response response = userEndPoints.createUser(userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("Create User Test case executed");
		logger.debug("Debug Message");
		logger.error("Error message");
	}
	
	@Test(priority = 1)
	public void testGetUser() {
		
		Response response = userEndPoints.GetUser(userpayload.getUsername());
		
        response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Get User Test case executed");
	}
	
	@Test(priority = 2)
	public void testUpdateUser() {

		userpayload.setFirstName(fake.name().firstName());
		Response response = userEndPoints.PutUser(userpayload.getUsername(), userpayload);
		
        response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("After update User Data.....");
		
      Response GetUserRes = userEndPoints.GetUser(userpayload.getUsername());
		
      GetUserRes.then().log().all();
	}
	
	@Test(priority = 3)
	public void testDeleteUser() {
		
		Response response = userEndPoints.DeleteUser(userpayload.getUsername());
		
        response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
}
