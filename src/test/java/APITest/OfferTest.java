package APITest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import apimethod.Offer;
import io.restassured.response.Response;
import utils.JsonReader;

public class OfferTest {
	Offer offermethod = new Offer();
	Response response = null;
	
	@Test
	public void testOffer() {
	try {
		Map<String, Object> offerfdata = JsonReader.getJsonData("JsonTestData/createoffer.json");
		response = 	offermethod.postOffer(offerfdata);
		Assert.assertEquals(response.getStatusCode(), 200, "Offer creation failed!");
		System.out.println("Offer created successfully.");
	} catch (Exception e) {
		System.out.println("testOffer in testCreateBook: " + e.getMessage());
		if (response != null) {
			System.out.println("Response: " + response.asString());
		}
		Assert.fail("Offer creation test failed due to exception.");
	}
	}
}
