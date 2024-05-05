package com.restassured.dummyapi;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTests {
    
//TC4 Create user dengan semua field terisi dengan tipe data yang valid (PASS)
@Test
    public void testCreateUserWithValidData() {
        // Set base URI for all requests
        String baseURI = "https://dummyapi.io/data/v1";

        // Replace with your actual App ID
        String appId = "662718b06cae038cebdee7c0";

        // Generate email address with random timestamp (buat test aja biar ga harus ubah email terus)
        String randomEmail = "user" + System.currentTimeMillis() + "@example.com";

        // JSON body for the POST request
        String requestBody = """
        {
            "title": "mrs",
            "firstName": "Ahmad",
            "lastName": "Dafa",
            "gender": "female",
            "email": "%s",
            "dateOfBirth": "2003-02-02",
            "phone": "+628521458999",
            "picture": "https://example.com/dafaahmad.jpg",
            "location": {
                "street": "892, Grande Rue",
                "city": "Besancon",
                "state": "Seine-et-Marne",
                "country": "France",
                "timezone": "+7:00"
            }
        }""".formatted(randomEmail);

        // Execute POST request and validate response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", appId)
            .body(requestBody)
            .log().all()  // Log the request details
            .when()
            .post("/user/create")  // Change to POST method
            .then()
            .log().all()  // Log the response details
            .statusCode(200) // Expecting status code 200
            .body("title", equalTo("mrs"))
            .body("firstName", equalTo("Ahmad"))
            .body("lastName", equalTo("Dafa"))
            .body("gender", equalTo("female"))
            .body("email", equalTo(randomEmail))
            .body("dateOfBirth", equalTo("2003-02-02T00:00:00.000Z"))
            .body("phone", equalTo("+628521458999"))
            .body("picture", equalTo("https://example.com/dafaahmad.jpg"))
            .body("location.street", equalTo("892, Grande Rue"))
            .body("location.city", equalTo("Besancon"))
            .body("location.state", equalTo("Seine-et-Marne"))
            .body("location.country", equalTo("France"))
            .body("location.timezone", equalTo("+7:00"))
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

    //TC12 Create user dengan semua field terisi kecuali field email (PASS)
    @Test
    public void testCreateUserWithoutEmail() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662718b06cae038cebdee7c0"; // Replace with your actual App ID

        // JSON body for the POST request without email
        String requestBody = """
        {
            "firstName": "ecaa",
            "lastName": "thniana",
            "email": ""
        }""";

        // Execute POST request and validate response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", appId)
            .body(requestBody)
            .log().all()  // Log the request details
            .when()
            .post("/user/create")  // Change to POST method
            .then()
            .log().all()  // Log the response details
            .statusCode(400) // Expecting status code 400
            .body("error", equalTo("BODY_NOT_VALID"))
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

    //TC13 Create user dengan semua field diisi kosong (PASS)
    @Test
    public void testCreateUserWithEmptyFields() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1/";
        
        // Prepare request body with empty fields
        String requestBody = "{"
                            + "\"title\": \"\","
                            + "\"firstName\": \"\","
                            + "\"lastName\": \"\","
                            + "\"gender\": \"\","
                            + "\"email\": \"\","
                            + "\"dateOfBirth\": \"\","
                            + "\"phone\": \"\","
                            + "\"picture\": \"\","
                            + "\"location\": {"
                            +     "\"street\": \"\","
                            +     "\"city\": \"\","
                            +     "\"state\": \"\","
                            +     "\"country\": \"\","
                            +     "\"timezone\": \"\""
                            + "}"
                            + "}";
        
        // Execute POST request and verify the response
        Response response = given()
            .header("Content-Type", "application/json")
            .header("app-id", "662718b06cae038cebdee7c0")
            .body(requestBody)
        .when()
            .post("/user/create")
        .then()
            .statusCode(400) // Expecting status code 400 Bad Request
            .extract()
            .response();
        
        // Print the complete response for debugging
        System.out.println("Complete Response Body: " + response.getBody().asString());
        
        // Perform additional assertions as needed
        // Example:
        response.then()
            .body("error", equalTo("BODY_NOT_VALID")); // Verify error field
    }
    
    //TC29 Create user dengan field picture diisi selain format URL (FAILED)
    @Test
    public void testCreateUserWithInvalidPictureURL() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662718b06cae038cebdee7c0"; // Replace with your actual App ID

        // Generate email address with random timestamp (buat test aja biar ga harus ubah email terus)
        String randomEmail = "user" + System.currentTimeMillis() + "@example.com";

        // JSON body for the POST request with invalid picture URL
        String requestBody = """
        {
            "title": "mr",
            "firstName": "dafa",
            "lastName": "ahmad",
            "gender": "male",
            "email": "%s",
            "dateOfBirth": "1900-02-02",
            "phone": "0852145899",
            "picture": "ahmad123.jpg",
            "location": {
                "street": "892, Grande Rue",
                "city": "Besançon",
                "state": "Seine-et-Marne",
                "country": "France",
                "timezone": "+09:00"
            }
        }""".formatted(randomEmail);

        // Execute POST request and validate response
        Response response = given()
                .header("Content-Type", "application/json")
                .header("app-id", appId)
                .body(requestBody)
                .log().all()  // Log the request details
                .when()
                .post("/user/create")  // Change to POST method
                .then()
                .log().all()  // Log the response details
                .statusCode(400) // Expecting status code 400
                .body("error", equalTo("BODY_NOT_VALID"))
                .extract()
                .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

    //TC54 Create user dengan field title diisi selain "mr,ms,mrs,miss,dr" dan kosong (PASS)
    @Test
    public void testCreateUserWithInvalidTitle() {
        // Set base URI for all requests
        baseURI = "https://dummyapi.io/data/v1";

        String appId = "662718b06cae038cebdee7c0"; // Replace with your actual App ID

         // Generate email address with random timestamp (buat test aja biar ga harus ubah email terus)
         String randomEmail = "user" + System.currentTimeMillis() + "@example.com";

        // JSON body for the POST request with invalid title
        String requestBody = """
        {
            "title": "King",
            "firstName": "dafa",
            "lastName": "ahmad",
            "gender": "male",
            "email": "%s",
            "dateOfBirth": "1900-02-02",
            "phone": "0852145899",
            "picture": "https://example.com/dafaahmad.jpg",
            "location": {
                "street": "892, Grande Rue",
                "city": "Besançon",
                "state": "Seine-et-Marne",
                "country": "France",
                "timezone": "+09:00"
            }
        }""".formatted(randomEmail);

        // Execute POST request and validate response
        Response response = given()
                .header("Content-Type", "application/json")
                .header("app-id", appId)
                .body(requestBody)
                .log().all()  // Log the request details
                .when()
                .post("/user/create")  // Change to POST method
                .then()
                .log().all()  // Log the response details
                .statusCode(400) // Expecting status code 400
                .body("error", equalTo("BODY_NOT_VALID"))
                .extract()
                .response();

        // Print response for debugging
        System.out.println("Response Body: " + response.asString());
    }

}
