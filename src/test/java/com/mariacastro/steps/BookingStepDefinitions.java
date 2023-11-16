package com.mariacastro.steps;


import com.mariacastro.targets.BookingTargets;
import com.mariacastro.tasks.SelectRooms;
import com.mariacastro.tasks.UserInfoForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.mariacastro.targets.SearchTargets.SEARCH_RESULTS_LIST;
import static com.mariacastro.targets.SearchTargets.SEARCH_RESULTS_SECOND_ELEMENT;
import static com.mariacastro.targets.VerifyDataTargets.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class BookingStepDefinitions {

    public static String SUBTOTAL_BOOKING_VALUE_KEY = "subtotal_booking";

    @Then("wait for results")
    public void waitForSearchResult() {
        List<WebElement> elements = SEARCH_RESULTS_LIST.resolveFor(theActorInTheSpotlight()).findElements(By.xpath("//android.view.ViewGroup"));
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(elements.size()).isGreaterThan(2)
        );
    }

    @When("select the second option in list of accommodations")
    public void selectSecondOptionOfAccommodations() {
        theActorInTheSpotlight().attemptsTo(
                Check.whether(WebElementQuestion.the(BookingTargets.DISMISS_INFO_BUTTON).answeredBy(theActorInTheSpotlight()).isVisible()).andIfSo(
                        Click.on(BookingTargets.DISMISS_INFO_BUTTON)
                ),
                Click.on(SEARCH_RESULTS_SECOND_ELEMENT)
        );
    }

    @And("books the first option of rooms")
    public void bookFirstOptionOfRooms() {
        theActorInTheSpotlight().attemptsTo(
                SelectRooms.firstRoom()
        );
    }


    @And("fills person info form")
    public void fillsInfoForm() {
        theActorInTheSpotlight().attemptsTo(
                UserInfoForm.fill()
        );
    }

    @And("verifies booking data")
    public void verifiesBookingData() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HOTEL_NAME_LABEL, isVisible()),
                Ensure.that(TOTAL_VALUE_LABEL.resolveFor(theActorInTheSpotlight()).getText()).contains(theActorInTheSpotlight().recall(SUBTOTAL_BOOKING_VALUE_KEY).toString()),
                Click.on(BOOK_NOW_BUTTON)
        );
    }


}
