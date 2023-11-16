package com.mariacastro.tasks;

import com.mariacastro.targets.BookingTargets;
import com.mariacastro.utils.ScrollUtils;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mariacastro.steps.BookingStepDefinitions.SUBTOTAL_BOOKING_VALUE_KEY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectRooms implements Task {

    public static SelectRooms firstRoom() {
        return Instrumented.instanceOf(SelectRooms.class).newInstance();
    }

    @Override
    @Step("{0} Select the first room option")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BookingTargets.SEE_ROOMS_OPTIONS_BUTTON, isVisible()),
                Click.on(BookingTargets.SEE_ROOMS_OPTIONS_BUTTON)
        );

        String reserveSubTotal;

        WaitUntil.the(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(BookingTargets.ROOM_SUBTOTAL_LABEL_SELECT.resolveFor(actor)),
                ExpectedConditions.visibilityOf(BookingTargets.ROOM_SUBTOTAL_LABEL_RESERVE.resolveFor(actor))
        ));

        ScrollUtils.scrollToElementWithResourceId(actor, "com.booking:id/rooms_item_select_layout");

        if (BookingTargets.ROOM_SUBTOTAL_LABEL_SELECT.resolveFor(actor).isVisible()) {
            reserveSubTotal = BookingTargets.ROOM_SUBTOTAL_LABEL_SELECT.resolveFor(actor).getText();
            actor.attemptsTo(
                    WaitUntil.the(BookingTargets.SELECT_ROOMS_BUTTON, isVisible()),
                    Click.on(BookingTargets.SELECT_ROOMS_BUTTON)
            );
            actor.attemptsTo(
                    WaitUntil.the(BookingTargets.FOOTER_SUBTOTAL_LABEL, isVisible()).forNoMoreThan(10).seconds(),
                    Ensure.that(BookingTargets.FOOTER_SUBTOTAL_LABEL.resolveFor(actor).getText()).contains(reserveSubTotal),
                    WaitUntil.the(BookingTargets.FOOTER_SELECT_ROOMS_BUTTON, isVisible()),
                    Click.on(BookingTargets.FOOTER_SELECT_ROOMS_BUTTON)
            );
        } else {
            actor.attemptsTo(
                    WaitUntil.the(BookingTargets.ROOM_SUBTOTAL_LABEL_RESERVE, isVisible())
            );
            reserveSubTotal = BookingTargets.ROOM_SUBTOTAL_LABEL_RESERVE.resolveFor(actor).getText();
            actor.attemptsTo(
                    WaitUntil.the(BookingTargets.RESERVE_ROOMS_BUTTON, isVisible()),
                    Click.on(BookingTargets.RESERVE_ROOMS_BUTTON)
            );
        }
        actor.remember(SUBTOTAL_BOOKING_VALUE_KEY, reserveSubTotal);
    }
}
