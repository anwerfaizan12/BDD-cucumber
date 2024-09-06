package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import org.testng.Assert;
//import org.junit.Assert;

public class apiStepDefinitions {

    private Response response;
    private String requestBody;

    @Given("I set the base URI")
    public void setBaseURI() {
        RestAssured.baseURI = "http://localhost:5000";
    }

    @When("I set the request body for user registration")
    public void setRequestBodyForUserRegistration() {
        requestBody = "{\n" +
                "  \"username\": \"shaheen\",\n" +
                "  \"password\": \"324567\",\n" +
                "  \"email\": \"shaheen123@gmail.com\"\n" +
                "}";
    }

    @When("I set the request body for user login")
    public void setRequestBodyForUserLogin() {
        requestBody = "{\n" +
                "  \"username\": \"Faizan\",\n" +
                "  \"password\": \"12345\"\n" +
                "}";
    }

    @When("I set the request body for adding a new restaurant")
    public void setRequestBodyForNewRestaurant() {
        requestBody = "{\n" +
                "  \"name\": \"Nazeer\",\n" +
                "  \"address\": \"Shaheen Bagh, Delhi\",\n" +
                "  \"cuisineType\": \"Indian\",\n" +
                "  \"contactInfo\": \"8823457681\"\n" +
                "}";
    }

    @When("I set the request body for placing a new order")
    public void setRequestBodyForNewOrder() {
        requestBody = "{\n" +
                "  \"restaurantId\": 6,\n" +
                "  \"customerId\": 6,\n" +
                "  \"foodItem\": \"Chowmin\",\n" +
                "  \"totalPrice\": 200\n" +
                "}";
    }

    @When("I set the request body for updating user profile")
    public void setRequestBodyForUpdatingUserProfile() {
        requestBody = "{\n" +
                "  \"userName\": \"faizan khan\",\n" +
                "  \"email\": \"anwerfaizan13@gmail.com\"\n" +
                "}";
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String endpoint) {
        response = given()
                .contentType(JSON)
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = given()
                .contentType(JSON)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    @When("I send a PUT request to {string}")
    public void sendPutRequest(String endpoint) {
        response = given()
                .contentType(JSON)
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    @When("I send a DELETE request to {string}")
    public void sendDeleteRequest(String endpoint) {
        response = given()
                .contentType(JSON)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response body should contain {string}")
    public void validateResponseBodyContains(String expectedMessage) {
        String actualMessage = response.jsonPath().getString("message");
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}






