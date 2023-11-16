package com.mariacastro.tasks;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mariacastro.targets.SearchTargets.SELECT_DATES_CONFIRM_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectDatesOnSearch implements Task {

    private String from;
    private String to;

    public SelectDatesOnSearch(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public static SelectDatesOnSearch fromTo(String from, String to) {
        return Instrumented.instanceOf(SelectDatesOnSearch.class).withProperties(from, to);
    }

    @Override
    @Step("{0} Select from and to specific dates")
    public <T extends Actor> void performAs(T actor) {
        Target FROM_DATE = Target.the("From date").located(AppiumBy.accessibilityId(from));
        Target TO_DATE = Target.the("To date").located(AppiumBy.accessibilityId(to));
        actor.attemptsTo(
                WaitUntil.the(FROM_DATE, isVisible()),
                Click.on(FROM_DATE)
        );
        actor.attemptsTo(
                WaitUntil.the(TO_DATE, isVisible()),
                Click.on(TO_DATE),
                Click.on(SELECT_DATES_CONFIRM_BUTTON)
        );
    }
}
