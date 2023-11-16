package com.mariacastro.tasks;

import com.mariacastro.targets.CreditCardTargets;
import com.mariacastro.utils.ScrollUtils;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mariacastro.steps.BookingStepDefinitions.SUBTOTAL_BOOKING_VALUE_KEY;
import static com.mariacastro.targets.CreditCardTargets.CREDIT_CARD_CVV_INPUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreditCardForm implements Task {

    public static CreditCardForm fill() {
        return Instrumented.instanceOf(CreditCardForm.class).newInstance();
    }

    @Override
    @Step("{0} Fill credit card data in form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreditCardTargets.CREDIT_CARD_NUMBER_INPUT, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.attemptsTo(
                Enter.theValue("5").into(CreditCardTargets.CREDIT_CARD_NUMBER_INPUT),
                Enter.theValue("10/26").into(CreditCardTargets.CREDIT_CARD_EXPIRATION_DATE_INPUT),
                Check.whether(WebElementQuestion.the(CREDIT_CARD_CVV_INPUT).answeredBy(actor).isVisible()).andIfSo(
                        Enter.theValue("630").into(CREDIT_CARD_CVV_INPUT)
                )
        );


        ScrollUtils.scrollToElementWithResourceId(actor, "com.booking:id/bp_price_summary_total_price_value");
        actor.attemptsTo(
                WaitUntil.the(CreditCardTargets.FINAL_TOTAL_LABEL, isVisible()),
                Ensure.that(CreditCardTargets.FINAL_TOTAL_LABEL.resolveFor(actor).getText()).contains(actor.recall(SUBTOTAL_BOOKING_VALUE_KEY).toString())
        );
    }
}
