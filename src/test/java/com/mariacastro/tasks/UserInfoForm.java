package com.mariacastro.tasks;

import com.mariacastro.targets.BookingTargets;
import com.mariacastro.utils.ScrollUtils;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mariacastro.steps.BookingStepDefinitions.SUBTOTAL_BOOKING_VALUE_KEY;
import static com.mariacastro.targets.UserFormTargets.*;
import static com.mariacastro.targets.UserFormTargets.NEXT_STEP_FORM_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UserInfoForm implements Task {

    public static UserInfoForm fill() {
        return Instrumented.instanceOf(UserInfoForm.class).newInstance();
    }

    @Override
    @Step("{0} Fill user info data in form")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FIRST_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.attemptsTo(
                Enter.theValue("Maria").into(FIRST_NAME_INPUT),
                Enter.theValue("Castro").into(LAST_NAME_INPUT),
                Enter.theValue("macastrod22@gmail.com").into(EMAIL_INPUT)
        );

        ScrollUtils.scrollToElementWithText(actor, "Leisure");

        actor.attemptsTo(
                Check.whether(WebElementQuestion.the(ADDRESS_INPUT).answeredBy(actor).isVisible()).andIfSo(
                        Enter.theValue("Cll 101 68d-43").into(ADDRESS_INPUT)
                ),
                Check.whether(WebElementQuestion.the(ZIP_CODE_INPUT).answeredBy(actor).isVisible()).andIfSo(
                        Enter.theValue("111111").into(ZIP_CODE_INPUT)
                ),
                Check.whether(WebElementQuestion.the(CITY_INPUT).answeredBy(actor).isVisible()).andIfSo(
                        Enter.theValue("Bogotá").into(CITY_INPUT)
                )
        );

        actor.attemptsTo(
                Clear.field(COUNTRY_INPUT),
                Enter.theValue("Colombia").into(COUNTRY_INPUT),
                Enter.theValue("3203531906").into(PHONE_INPUT),
                Click.on(LEISURE_RADIO_BUTTON)
        );
        System.out.println(actor.recall(SUBTOTAL_BOOKING_VALUE_KEY).toString());
        actor.attemptsTo(
                Ensure.that(SUBTOTAL_INFO_FORM_LABEL.resolveFor(actor).getText()).contains(actor.recall(SUBTOTAL_BOOKING_VALUE_KEY).toString()),
                Click.on(NEXT_STEP_FORM_BUTTON)
        );
    }
}
