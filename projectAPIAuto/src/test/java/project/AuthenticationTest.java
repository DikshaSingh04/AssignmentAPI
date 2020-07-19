package project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * Description Authentication test by using data provider
 * @link AuthenticationTest
 *
 * @author Diksha.Singh
 */
public class AuthenticationTest {


	@Test(dataProvider = "Data_Page_User_Nuber")
	public void getListOfUsers(int pageNumber, int userNumberVal) {

		given().auth().preemptive()/** preemptive for better security ***/
				.basic("user1", "user2").params("page", pageNumber).contentType(ContentType.JSON)
				.baseUri("https://reqres.in/api/users").when().get().then().log().all();

	}

	@Test(dataProvider = "Data_Page_User_Nuber")
	public void getSingleUser(int pageNumber, int userNumberVal) {

		given().auth().form("UserId", "password")
		.params("userNumberVal", userNumberVal).when()
				.get("https://reqres.in/api/users/{userNumberVal}").then().log().all();
	}


	/**
	 * TestNg data provider
	 * 
	 * @return
	 */
	@DataProvider(name = "Data_Page_User_Nuber")
	public Object[][] getPageNumberUserNumber() {

		return new Object[][] { { 1, 2 }, { 2, 3 }, { 2, 4 } };

	}
}
