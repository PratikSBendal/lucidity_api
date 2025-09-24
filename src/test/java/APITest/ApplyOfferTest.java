package APITest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import apimethod.ApplyOffer;
import io.restassured.response.Response;
import utils.JsonReader;

public class ApplyOfferTest {
	ApplyOffer applyoffermethod = new ApplyOffer();
	Response response = null;

	public void testApplyOffer() {
		try {
			Map<String, Object> applyofferdata = JsonReader.getJsonData("JsonTestData/applyoffer.json");
			HashMap<String, Object> request = new HashMap<>();
			Map<String, Object> requestresponse = new HashMap<>();
			for (Map.Entry<String, Object> apirequest : applyofferdata.entrySet()) {
				String key = apirequest.getKey();
				Object value = apirequest.getValue();

				if (key.startsWith("expected_")) {
					requestresponse.put(key.replace("expected_", ""), value);
				} else {
					request.put(key, value);
				}
			}

			// Call API 
			response = applyoffermethod.postApplyOffer(request);
			Assert.assertEquals(response.getStatusCode(), 200, "Apply Offer Fail");
			System.out.println("Apply Offer created successfully.");

			// Validate response using expectedResponse map
			for (Map.Entry<String, Object> entry : requestresponse.entrySet()) {
				Object actualValue = response.jsonPath().get(entry.getKey());
				Assert.assertEquals(actualValue, entry.getValue(), "Mismatch in key: " + entry.getKey());
			}

			System.out.println("Test passed for request: " + request);

		} catch (Exception e) {
			System.out.println("Exception occurred during test: " + e.getMessage());
			if (response != null) {
				System.out.println("API Response: " + response.asString());
			}
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

}
