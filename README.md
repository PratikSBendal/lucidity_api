# lucidity_api
A Java-based API Test Automation Framework using TestNG, RestAssured, and Allure. It follows a modular design, supports JSON-driven data, validates request/response, and generates rich reports. Easily extendable to UI tests with Selenium and ready for CI/CD integration.

🚀 Tech Stack

Language: Java

Build Tool: Maven

Test Framework: TestNG

API Testing: RestAssured

UI Support (if required): Selenium

Reports: Allure

⚙️ Prerequisites

Make sure you have the following installed:

Java 8+

Maven 3+

TestNG

📌 How It Works

Test Data is stored in JsonTestData folder (e.g., applyoffer.json).

Utils.JsonReader reads the JSON test data into a Map<String,Object>.

apimethod.ApplyOffer executes the request using RestAssured and attaches logs in Allure.

APITest.ApplyOfferTest validates request → response mapping against expected values.

✅ Features

JSON-driven test cases

Request/response logging in Allure

Modular design with Page Object-like pattern for APIs

Easy integration with CI/CD (Jenkins, GitHub Actions, etc.)

▶️ Running Tests

Run the tests using Maven: mvn clean test


