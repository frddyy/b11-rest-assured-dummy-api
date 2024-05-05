package com.restassured.dummyapi;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserApiTests {

    @Test
    public void testDeleteUserWithAppIdUnregistered() { //TC1 DeleteUser - App Id Unregistered
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";

        // User ID to be updated
        String userId = "60d0fe4f5311236168a109cc";

        // Execute PUT request with an invalid app-id and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "662dd4bdfce0ef1111de25b")
            .when()
            .delete("user/" + userId)
            .then()
            .statusCode(403) // Expecting status code 403 Forbidden
            .body("error", equalTo("APP_ID_NOT_EXIST")) // Correct path to validate the error message
            .extract()
            .response();

        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
    }

    @Test
    public void testDeleteUserWithInvalidAppId() { //TC2 DeleteUser - App Id Invalid Format
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";

        // User ID to be updated
        String userId = "60d0fe4f5311236168a109cc";

        // Execute PUT request with an invalid app-id and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "afafyaf18r89ah10121")
            .when()
            .delete("user/" + userId)
            .then()
            .statusCode(403) // Expecting status code 403 Forbidden
            .body("error", equalTo("APP_ID_NOT_EXIST")) // Correct path to validate the error message
            .extract()
            .response();

        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
    }

    @Test
    public void testDeleteUserWithdAppIdNotFilled() { //TC3 DeleteUser - App Id Not Filled
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";

        // User ID to be updated
        String userId = "60d0fe4f5311236168a109cc";

        // Execute PUT request with an invalid app-id and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "")
            .when()
            .delete("user/" + userId)
            .then()
            .statusCode(403) // Expecting status code 403 Forbidden
            .body("error", equalTo("APP_ID_MISSING")) // Correct path to validate the error message
            .extract()
            .response();

        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
    }

    @Test
    public void testDeleteUserWithValidUserAndAppId() { //TC4 DeleteUser - User and App Id Valid Resgistered
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";

        // User ID to be updated
        String userId = "60d0fe4f5311236168a109cc";

        // Execute PUT request with an invalid app-id and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "662718b06cae038cebdee7c0")
            .when()
            .delete("user/" + userId)
            .then()
            .statusCode(200) // Expecting status code 200 OK 
            .body("id", equalTo("60d0fe4f5311236168a109cc")) // Correct path to validate the error message
            .extract()
            .response();

        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
    }

    @Test
    public void testDeleteUserWithValidUserIdbutUnregistered() { //TC5 DeleteUser - User Id Valid but Unregistered
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";

        // User ID to be updated
        String userId = "662dd4bdfce0ef07531de25b";

        // Execute PUT request with an invalid app-id and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "662718b06cae038cebdee7c0")
            .when()
            .delete("user/" + userId)
            .then()
            .statusCode(404) // Expecting status code 404 Not Found
            .body("error", equalTo("RESOURCE_NOT_FOUND")) // Correct path to validate the error message
            .extract()
            .response();

        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
    }

}
