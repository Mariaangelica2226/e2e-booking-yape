package com.mariacastro.steps;

import com.mariacastro.tasks.CreditCardForm;
import io.cucumber.java.en.And;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreditCardStepDefinitions {

    @And("fills credit card data")
    public void fillsCreditCardData() {
        theActorInTheSpotlight().attemptsTo(
                CreditCardForm.fill()
        );

    }
}
