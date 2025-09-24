package apimethod;

import static io.restassured.RestAssured.given;

import java.util.Map;

import base.RequestBuilder;
import endpoint.APIEndPoint;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class Offer {
	public Response postOffer(Map<String, Object> body) {
		Response response = null;

		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.body(body)
					.when()
					.post(APIEndPoint.OFFER)
					.then()
					.extract().response();
			
			Allure.addAttachment("Offer Request", body.toString());
			Allure.addAttachment("Offer Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in postOffer(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Offer Response Failure", response.asString());
			} else {
				Allure.addAttachment("Offer Response Failure", "No response captured due to exception.");
			}
		}

		return response;
	}
}
