package apimethod;

import static io.restassured.RestAssured.given;

import base.RequestBuilder;
import endpoint.APIEndPoint;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class UserSegment {
	public Response getUserSegment() {
		Response response = null;

		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.queryParam("user_id", 1)
					.when()
					.get(APIEndPoint.USERSEGMENT)
					.then()
					.extract().response();
 
			Allure.addAttachment("Get User Segment Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in getUserSegment(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Get User Segment Response Failure", response.asString());
			} else {
				Allure.addAttachment("Get User Segment Response Failure", "No response captured due to exception.");
			}
		}

		return response;

	}
}
