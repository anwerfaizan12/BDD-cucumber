//package stepDefinitions;
//
//import io.cucumber.java.en.*;
//import io.restassured.response.Response;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//public class apiStepDefinitions{
//	private Response response;
//	
//	@Given("I set the base URI")
//	public void setBaseURI() {
//	given().baseUri("http://localhost:4000");
//	}
//
//	@When("I set the request body for user registration")
//	public void setRequestBody() {
//	String requestBody = "{ \"username\": \"aleena\", \"password\": \"password123\", \"email\": \"aleena12@gmail.com\" }";
//	given().body(requestBody);
//	}
//
//	@When("I send a POST request to \"/users/register\"")
//	public void sendPostRequest1() {
//	response = given().post("/users/register");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode1(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//
//	@When("I set the request body for user login")
//	public void setRequestBody2() {
//	String requestBody = "{ \"username\": \"Faizan\", \"password\": \"12345\" }";
//	given().body(requestBody);
//	}
//
//	@When("I send a POST request to \"/users/login\"")
//	public void sendPostRequest2() {
//	response = given().post("/users/login");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode2(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	@Then("the response body should contain {string}")
//	public void verifyResponseBody2(String message) {
//	response.then().body("message", equalTo(message));
//	}
//	
//	@When("I set the request body for adding a new restaurant")
//	public void setRequestBody3() {
//	String requestBody = "{ \"name\": \"New Restaurant\", \"address\": \"Address1\", \"cuisineType\": \"Cuisine1\", \"contactInfo\": \"Contact1\" }";
//	given().body(requestBody);
//	}
//
//	@When("I send a POST request to \"/restaurants\"")
//	public void sendPostRequest3() {
//	response = given().post("/restaurants");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode3(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//
//	@When("I send a GET request to \"/restaurants/{restaurantId}\"")
//	public void sendGetRequest4(int restaurantId) {
//	response = given().pathParam("restaurantId", restaurantId).get("/restaurants/{restaurantId}");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode4(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//	
//	@When("I set the request body for placing a new order")
//	public void setRequestBody5() {
//	String requestBody = "{ \"userId\": 1, \"restaurantId\": 1, \"foodItems\": [\"Food1\", \"Food2\"], \"totalPrice\": 20.0 }";
//	given().body(requestBody);
//	}
//
//	@When("I send a POST request to \"/orders\"")
//	public void sendPostRequest5() {
//	response = given().post("/orders");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode5(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//	@When("I send a GET request to \"/orders/{orderId}\"")
//	public void sendGetRequest6(int orderId) {
//	response = given().pathParam("orderId", orderId).get("/orders/{orderId}");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode6(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//	@When("I set the request body for updating user profile")
//	public void setRequestBody7() {
//	String requestBody = "{ \"username\": \"updatedUser\", \"email\": \"updated@example.com\" }";
//	given().body(requestBody);
//	}
//
//	@When("I send a PUT request to \"/users/{userId}\"")
//	public void sendPutRequest7(int userId) {
//	response = given().pathParam("userId", userId).put("/users/{userId}");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode7(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//	@When("I send a DELETE request to \"/users/{userId}\"")
//	public void sendDeleteRequest8(int userId) {
//	response = given().pathParam("userId", userId).delete("/users/{userId}");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode8(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//	
//	@When("I send a GET request to \"/foods/search?name={foodName}\"")
//	public void sendGetRequest9(String foodName) {
//	response = given().queryParam("name", foodName).get("/foods/search");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode9(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	@When("I send a GET request to \"/foods/filter?cuisine={cuisineType}\"")
//	public void sendGetRequest10(String cuisineType) {
//	response = given().queryParam("cuisine", cuisineType).get("/foods/filter");
//	}
//
//	@Then("the response status code should be {int}")
//	public void verifyStatusCode10(int statusCode) {
//	response.then().statusCode(statusCode);
//	}
//
//	
//}













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
        RestAssured.baseURI = "http://localhost:4000";
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






