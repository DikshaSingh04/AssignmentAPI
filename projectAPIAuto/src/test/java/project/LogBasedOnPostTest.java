package project;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

/**
 * Description Logging functionality & Reading data from file system tests
 * 
 * @link LogBasedOnPostTest
 * @author Diksha.Singh
 */

public class LogBasedOnPostTest {

	/**
	 * given()- resquest When()- condition given then()- Validatable post()- action
	 * response
	 * 
	 * @throws FileNotFoundException
	 */

	@Test(enabled = false)
	public void responseLog() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/project/src/test/resources/createPayload.txt");
		given().headers("content-type", "application/json").body(fis).baseUri("https://reqres.in/api/users").when()
				.post().then().log().all();/**response log**/
	}

	@Test(enabled = false)
	public void requestLogging() throws FileNotFoundException {

		JSONObject jo = new JSONObject();
		jo.put("name", "DikshaSingh");
		jo.put("job", "SWE");
		given()
				/** logging a request body **/
				.log().body().headers("content-type", "application/json").body(jo.toString())
				.baseUri("https://reqres.in/api/users").when().post().then().assertThat().statusCode(201);

	}

	@Test(enabled = true)
	public void requestLogWhenError() throws FileNotFoundException {

		JSONObject jo = new JSONObject();
		jo.put("name", "DikshaSingh");
		jo.put("job", "SWE");

		given().headers("content-type", "application/json").body(jo.toString()).baseUri("https://reqres.in/api/users")
				.when().post().then().log().ifValidationFails().assertThat().statusCode(203);
	}
}
