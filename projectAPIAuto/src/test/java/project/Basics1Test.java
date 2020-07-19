package project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * Description: Basics methods practice of rest assured
 * @link Basics1Test
 *
 * @author Diksha.Singh
 */
public class Basics1Test {

	@Test(enabled = true)
	public void getListOfUsers() {

		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		/**
		 * Request specification
		 */
		RequestSpecification reqsep = RestAssured.given();
		Response response = reqsep.get();
		String str = response.asString();
		System.out.println(str);
		int status = response.statusCode();
		System.out.println(status);
	}

	@Test
	public void getListOfUsersDirect() {

		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification reqsep = RestAssured.given();
		Response response = reqsep.get();
		int status = response.statusCode();
		System.out.println(status);
	}

}




/**
 * URI stands for Uniform Resource Identifier. A Uniform
 * Resource Identifier is a sequence of characters used for identification of a
 * particular resource. It enables for the interaction of the representation of
 * the resource over the network using specific protocols.
 */