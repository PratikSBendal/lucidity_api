package APITest;

import java.util.Map;

import org.testng.Assert;

import apimethod.UserSegment;
import io.restassured.response.Response;
import utils.JsonReader;

public class UserSegmentTest {
	UserSegment usersegmentmethod = new UserSegment();
	Response response = null;

	public void testUserSegment() {
		try {
			response = usersegmentmethod.getUserSegment();
			Assert.assertEquals(response.getStatusCode(), 200, "Offer creation failed!");
			System.out.println("Get UserSegment successfully.");
		} catch (Exception e) {
			System.out.println("testOffer in testUserSegment: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Get UserSegment test failed due to exception.");
		}
	}
}
