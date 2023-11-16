package com.mariacastro.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mariacastro.targets.SearchTargets.DESTINATION_INPUT;
import static com.mariacastro.targets.SearchTargets.DESTINATION_INPUT_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchALocation implements Task {

    private String search;

    public SearchALocation(String search) {
        this.search = search;
    }

    public static SearchALocation andSelectFirstElement(String search) {
        return Instrumented.instanceOf(SearchALocation.class).withProperties(search);
    }

    @Override
    @Step("{0} Search for a location and select the first item")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DESTINATION_INPUT_BUTTON),
                WaitUntil.the(DESTINATION_INPUT, isVisible()),
                Enter.theValue(search).into(DESTINATION_INPUT)
        );
    }
}
