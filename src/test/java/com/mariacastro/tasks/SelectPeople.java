package com.mariacastro.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.mariacastro.targets.SearchTargets.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectPeople implements Task {

    private int yearsOfChild;

    public SelectPeople(int yearsOfChild) {
        this.yearsOfChild = yearsOfChild;
    }

    public static SelectPeople withAChild(int yearsOfChild) {
        return Instrumented.instanceOf(SelectPeople.class).withProperties(yearsOfChild);
    }

    @Override
    @Step("{0} Search for a location and select the first item")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ROOMS_AND_PEOPLE_SELECTOR_BUTTON),
                WaitUntil.the(ACCOMMODATION_COUNTERS, isVisible())
        );
        List<WebElementFacade> counters = ACCOMMODATION_COUNTERS.resolveAllFor(actor);
        WebElementFacade ROOMS_COUNTER = counters.get(0);
        WebElementFacade ADULTS_COUNTER = counters.get(1);

        actor.attemptsTo(
                Ensure.that(ROOMS_COUNTER.getText()).isEqualTo("1"),
                Ensure.that(ADULTS_COUNTER.getText()).isEqualTo("2")
        );

        actor.attemptsTo(
                Click.on(ADD_CHILDREN_BUTTON),
                WaitUntil.the(NUMBER_PICKER_SELECTED_ELEMENT, isVisible())
        );
        WebElement numberPickerSelectedElement = NUMBER_PICKER_SELECTED_ELEMENT.resolveFor(actor);
        while (!numberPickerSelectedElement.getText().equals(yearsOfChild + " years old")) {
            NUMBER_PICKER_BOTTOM_BUTTON_SCROLL.resolveAllFor(actor).get(1).click();
        }
        actor.attemptsTo(
                Click.on(NUMBER_PICKER_CONFIRM_BUTTON)
        );

        actor.attemptsTo(
                Ensure.that(SELECTED_CHILD_LABEL.resolveFor(actor).getText()).isEqualTo(yearsOfChild + " years old"),
                Click.on(ACCOMMODATION_APPLY_BUTTON)
        );
    }
}
