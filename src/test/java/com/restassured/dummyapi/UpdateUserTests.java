package com.restassured.dummyapi;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTests {

    //TC01
    @Test
    public void testUpdateUserWithInvalidAppId() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";

        // User ID to be updated
        String userId = "60d0fe4f5311236168a109dc";

        // Prepare the body of the request
        String requestBody = "{\"firstName\": \"John\", \"lastName\": \"Doe\"}";

        // Execute PUT request with an invalid app-id and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "622dd9bdfce0af1111de25b")
            .body(requestBody)
            .when()
            .put("user/" + userId)
            .then()
            .statusCode(403) // Expecting status code 403 Forbidden
            .body("error", equalTo("APP_ID_NOT_EXIST")) // Correct path to validate the error message
            .extract()
            .response();

        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
    }

    //TC04
    @Test
    public void testUpdateUserWithValidData() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662dd4bdfce0ef07531de25b"; // Replace with your actual App ID
        String userId = "60d0fe4f5311236168a109d5"; // User ID to update

        // JSON body for the PUT request
        String requestBody = """
        {
            "title": "mr",
            "firstName": "Aini",
            "lastName": "Diah",
            "gender": "other",
            "dateOfBirth": "2003-08-25",
            "phone": "+1234567890",
            "picture": "https://example.com/profile.jpg",
            "location": {
                "street": "123 Main Street",
                "city": "New York",
                "state": "New York",
                "country": "United States",
                "timezone": "+7:00"
            }
        }""";

        // Execute PUT request and validate response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", appId)
            .body(requestBody)
            .log().all()  // Log the request details
            .when()
            .put("/user/" + userId)
            .then()
            .log().all()  // Log the response details
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Aini"))
            .body("lastName", equalTo("Diah"))
            .body("gender", equalTo("other"))
            .body("dateOfBirth", equalTo("2003-08-25"))
            .body("phone", equalTo("+1234567890"))
            .body("picture", equalTo("https://example.com/profile.jpg"))
            .body("location.street", equalTo("123 Main Street"))
            .body("location.city", equalTo("New York"))
            .body("location.state", equalTo("New York"))
            .body("location.country", equalTo("United States"))
            .body("location.timezone", equalTo("+7:00"))
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

    //TC33
    @Test
    public void testUpdateUserFirstNameWithValidRange() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662dd4bdfce0ef07531de25b"; // Replace with your actual App ID
        String userId = "60d0fe4f5311236168a109d5"; // User ID to update

        // JSON body for the PUT request
        String requestBody = """
        {
            "firstName": "Ainidiah"
        }""";

        // Execute PUT request and validate response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", appId)
            .body(requestBody)
            .log().all()  // Log the request details
            .when()
            .put("/user/" + userId)
            .then()
            .log().all()  // Log the response details
            .statusCode(200)
            .body("firstName", equalTo("Ainidiah"))
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }


    //TC40
@Test
    public void testUpdateUserGenderWithNotString() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662dd4bdfce0ef07531de25b"; // Replace with your actual App ID
        String userId = "60d0fe4f5311236168a109d5"; // User ID to update

        // JSON body for the PUT request
        String requestBody = """
        {
            "gender": 254
        }""";

        // Execute PUT request and validate response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", appId)
            .body(requestBody)
            .log().all()  // Log the request details
            .when()
            .put("/user/" + userId)
            .then()
            .log().all()  // Log the response details
            .statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"))
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

    //TC64
    @Test
    public void testUpdateUserWithValidEmail() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662dd4bdfce0ef07531de25b"; // Replace with your actual App ID
        String userId = "60d0fe4f5311236168a109d5"; // User ID to update

        // JSON body for the PUT request
        String requestBody = """
        {
            "email": "alexandra123@gmail.com",
        }""";

        // Execute PUT request and validate response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", appId)
            .body(requestBody)
            .log().all()  // Log the request details
            .when()
            .put("/user/" + userId)
            .then()
            .log().all()  // Log the response details
            .statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"))
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

}

