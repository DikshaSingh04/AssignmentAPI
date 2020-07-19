package project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Description: Basics methods practice of rest assured
 * @link Basics3Test
 *
 * @author Diksha.Singh
 */
public class Basics3Test extends TestBase {

	public Basics3Test() throws IOException {
		super();
	}

	@Test
	public void getListOfUsers3() {
		/**
		 * given() when() Then() Assert
		 */
		given().contentType(ContentType.JSON).baseUri("https://reqres.in/api/users?page=2").when().get().then()
				.body("page", equalTo(1));

	}

	/*
	 * @Test public void hamcrestAssertEmailOfData3Test() {
	 * 
	 * given() .contentType(ContentType.JSON)
	 * .baseUri("https://reqres.in/api/users?page=2") .when() .get() .then()
	 * .assertThat() .body("data[2].email", contaionsString("abc@gmail.com"));
	 * 
	 * }
	 */

	@Test
	public void hamcrestAssertTest2() {

		given().contentType(ContentType.JSON).baseUri("https://reqres.in/api/users?page=2").when().get().then()
				.assertThat().header("server", equalTo("cloudflare"));
//		.then().log().all();

	}

	@Test
	public void readDataFromProp() {

		given().when().get(props.getProperty("endpoint")).then().statusCode(200);

	}
}
