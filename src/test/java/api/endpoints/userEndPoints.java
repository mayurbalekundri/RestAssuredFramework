package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	
	public static Response createUser(user payload){
		
		Response res = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return res;
		
	}
	
	public static Response GetUser(String UserName) {
		
		
		Response res = given()
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		
		.when()
		.get(Routes.get_url);
		
		return res;
		
	}
			
	public static Response PutUser(String UserName,user payload)	{
		
		Response res = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", UserName)
		.body(payload)
		
		.when()
		.put(Routes.put_url);
		
		return res;
		
		
	}
	
	public static Response DeleteUser(String UserName) {
		
		Response res = given()
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.when()
		.delete(Routes.del_url);
		
		return res;
	}
	

}
