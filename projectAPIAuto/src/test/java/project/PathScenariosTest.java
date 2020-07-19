package project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

/**
 * Description: Methods practice by JSON path scenarios and pat scenarios
 * @link PathScenariosTest
 *
 * @author Diksha.Singh
 */
public class PathScenariosTest {


	@SuppressWarnings("deprecation")
	@Test(enabled = true)
	public void responseLog()  {
		given()
		.headers("content-type","application/json")
		.baseUri("https://reqres.in/api/users?page=2")
		.when()
		.get()
		.then().log().all()
		.root("data[0]")
		.body("id", equalTo(1));
	}


	@Test(enabled = true)
	public void rootPathAndJsonRest()  {
		//		RestAssured.rootPath = "data[0]";
		String str = given()
				.headers("content-type","application/json")
				.baseUri("https://reqres.in/api/users?page=2")
				.when()
				.get().body().asString();	

		/**
		 * JSON PARH scenario
		 */
		JsonPath jo = new JsonPath(str);
		jo.get("data[0].0");
		System.out.println(jo.get("data[0]"));
	}


	@Test(enabled = true)
	public void PrepareSpecification()  {
		/**
		 * Step 1:  Creating request specification
		 */
		RequestSpecBuilder rsb = new RequestSpecBuilder();
		rsb.addHeader("content-type","application/json");
		rsb.addQueryParam("page", "2");
		rsb.setBaseUri("https://reqres.in/");
		RequestSpecification reqSpec = rsb.build();

		/**
		 * Step 2: Asserting response
		 */
		given()
		.spec(reqSpec)
		.when()
		.get("api/users").then().assertThat().statusCode(200);

	}

}
