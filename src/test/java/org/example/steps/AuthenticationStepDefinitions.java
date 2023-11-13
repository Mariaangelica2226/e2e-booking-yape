package org.example.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthenticationStepDefinitions {

    @Given("The API endpoint is {string}" )
    public void setApiEndpoint(String endpoint) {
        RestAssured.baseURI = endpoint;
    }
    @When("a POST request is made with username {string} and password {string}")
    public void makePostRequest(String username, String password) {
        given()
                .header("Content-Type", "application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}")
                .when()
                .post();
    }
    @Then("the response status code should be {int}" )
    public void verifyResponseStatusCode(int statusCode) {
        then().statusCode(statusCode);
    }
    @And("the response should contain a token")
     public void verifyResponseContainsToken() {
            then().body("token", notNullValue());
        }
    @And("the response should contain the text {string}")
    public void verifyResponseContainsText(String expectedText) {
        then().body("reason", equalTo(expectedText));
    }
}
