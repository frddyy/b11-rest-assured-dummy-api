package com.restassured.dummyapi;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class DummyApiTests {

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
}

