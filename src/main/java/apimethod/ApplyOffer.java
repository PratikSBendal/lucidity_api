package apimethod;

import static io.restassured.RestAssured.given;

import java.util.Map;

import base.RequestBuilder;
import endpoint.APIEndPoint;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class ApplyOffer {
	Response response = null;

	public Response postApplyOffer(Map<String, Object> body) {

		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.body(body)
					.when()
					.post(APIEndPoint.APPLYOFFER)
					.then()
					.extract().response();
			
			Allure.addAttachment("Apply Offer Request", body.toString());
			Allure.addAttachment("Apply Offer Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in postApplyOffer(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Apply Offer Response Failure", response.asString());
			} else {
				Allure.addAttachment("Apply Offer Response Failure", "No response captured due to exception.");
			}
		}

		return response;
	}
	
}