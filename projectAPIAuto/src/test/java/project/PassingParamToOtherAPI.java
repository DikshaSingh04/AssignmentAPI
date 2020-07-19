package project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

/**
 * Description: Methods practice by using Parameterization, Use of value IN to other API calls 
 * @link PassingParamToOtherAPI
 *
 * @author Diksha.Singh
 */
public class PassingParamToOtherAPI {

	/**
	 * Use of value to other API calls
	 */
	@Test
	public void getListOfUsers() {

		int i = given().when().get("https://reqres.in/api/users")
		.then()
		.extract()
		.path("data[0].id");
		System.out.println("int i  is: "+i);
		
		
		given()
		.pathParam("paramName", i)
		.when().get("https://reqres.in/api/users/{paramName}")
		.then()
		.log()
		.all();
		

	}
}
