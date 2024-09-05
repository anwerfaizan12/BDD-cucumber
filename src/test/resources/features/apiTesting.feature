Feature: User Registration

Scenario: Register a new user
Given I set the base URI
When I set the request body for user registration
And I send a POST request to "/users/register"
Then the response status code should be 201


Scenario: Login a user
When I set the request body for user login
And I send a POST request to "/users/login"
Then the response status code should be 200
And the response body should contain "Login successful"


Scenario: Add a new restaurant
When I set the request body for adding a new restaurant
And I send a POST request to "/restaurants"
Then the response status code should be 201


Scenario: Retrieve restaurant details
When I send a GET request to "/restaurants/1"
Then the response status code should be 200


Scenario: Place a new order
When I set the request body for placing a new order
And I send a POST request to "/orders"
Then the response status code should be 201


Scenario: Retrieve order details
When I send a GET request to "/orders/1"
Then the response status code should be 200


Scenario: Update user profile
When I set the request body for updating user profile
And I send a PUT request to "/users/1"
Then the response status code should be 200


Scenario: Delete user account
When I send a DELETE request to "/users/2"
Then the response status code should be 204


Scenario: Search foods by name
When I send a GET request to "/foods/search?name=juice"
Then the response status code should be 200



Scenario: Filter foods by cuisine
When I send a GET request to "/foods/filter?cuisine=korean"
Then the response status code should be 200
