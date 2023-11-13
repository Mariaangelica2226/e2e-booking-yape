package org.example.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;


public class BookingStepDefinitions {

    Response response;

    @Given("I request all booking IDs")
    public void userRequestTheGETEndpointHttpsRestfulBookerHerokuappComBooking() {
        given().get("https://restful-booker.herokuapp.com/booking");

    }

    @Then("I validate the response with a JSON Schema")
    public void iValidateTheResponseWithAJSONSchema() {
        then().assertThat().body(matchesJsonSchemaInClasspath("jsonschemas/getBookingsIds.json"));
    }
}
