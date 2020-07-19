package project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Description: Basics methods practice of rest assured
 * @link Basics2Test
 *
 * @author Diksha.Singh
 */
public class Basics2Test {

	@Test
	public void getListOfUsersTest() {
		/**
		 * given() when() Then() Assert
		 */
		given().contentType(ContentType.JSON).baseUri("https://reqres.in/api/users?page=2").when().get().then()
				.statusCode(200);
	}

	@Test
	public void getListOfUsersOrintingResponsTest() {
		/**
		 * given() when() Then() Assert
		 */
		Response response = given().contentType(ContentType.JSON).baseUri("https://reqres.in/api/users?page=2").when()
				.get();
		System.out.println(response.asString());
	}

	@Test
	public void getListOfUsersAssertionTest() {
		/**
		 * given() when() Then() Assert
		 */
		given().contentType(ContentType.JSON)
		.baseUri("https://reqres.in/api/users?page=2").when().get()
		.then().body("page", equalTo(1));
		
	}
}
