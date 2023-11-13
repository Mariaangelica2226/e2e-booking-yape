package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;


public class TestStepDefinitions extends UIInteractionSteps {

    @Step("Busca los elementos y realiza una accion por cada uno")
    public void useElements() {
        given().get("https://restful-booker.herokuapp.com/booking");
    }

    @Step("Busca los elementos y realiza una accion por cada uno 2")
    public void useElements2() {
        then().statusCode(200).body("[0]", Matchers.hasKey("bookingid"));
    }
}