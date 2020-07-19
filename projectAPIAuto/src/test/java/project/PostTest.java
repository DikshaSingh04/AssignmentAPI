package project;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;
/**
 * Description: Methods practice using POST request
 * @link PostTest
 *
 * @author Diksha.Singh
 */
public class PostTest {

	@Test(enabled = true)
	public void getListOfUsers() {
		given()
		.headers("content-type","application/json")
		.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}")
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.post()
		.then().log().all();
	}



	@Test(enabled = false)
	public void getListOfUsersUsingFileRead() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/project/src/test/resources/createPayload.txt");
		given()
		.headers("content-type","application/json")
		.body(fis)
		.baseUri("https://reqres.in/api/users")
		.when()
		.post()
		.then().log().all();
	}

	@Test(enabled = true)
	public void postBodyUsingJsonObject() throws FileNotFoundException {

		JSONObject jo = new JSONObject();
		jo.put("name", "DikshaSingh");
		jo.put("job", "leader");
		given()
		.headers("content-type","application/json") 
		.body(jo.toString())
		.baseUri("https://reqres.in/api/users") .when() .post()
		.then().log().all();

	}
}
