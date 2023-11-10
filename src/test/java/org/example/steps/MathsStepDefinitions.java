package org.example.steps;


import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.app.Calculator;
import org.example.navigation.NavigateTo;
import org.openqa.selenium.WebElement;

public class MathsStepDefinitions {

    int a = 1;
    int b = 0;
    int total = 0;

    Calculator calculator = new Calculator();

    @Given("se loguea en rurall app")
    public void givenAIs() {
        NavigateTo.theLoginPage();
        Target element= Target.the("Cualquier elemento").locatedBy("//*[@id=\"root\"]/div/div/div[2]/form/button");
        WaitUntil.the(element, WebElementStateMatchers.isVisible());
        //actor.attemptsTo(Click.on(element));
       // Ensure.that("El resultado debería ser verdadero", true).isTrue();


        TestStepDefinitions tsd = new TestStepDefinitions();
        tsd.useElements();


    }

    @Given("b is {int}")
    public void givenBIs(int value) {
        b = value;
    }

    @When("I add a and b")
    public void iAddAAndB() {
        total = calculator.add(a,b);
    }

    @Then("the total should be {int}")
    public void theTotalShouldBe(int expectedTotal) {
        assertThat(total).isEqualTo(expectedTotal);
    }

}
