package com.mariacastro.steps;


import com.mariacastro.tasks.SearchALocation;
import com.mariacastro.tasks.SelectDatesOnSearch;
import com.mariacastro.tasks.SelectPeople;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mariacastro.targets.SearchTargets.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SearchAccommodationStepDefinitions {


    @Given("{actor} is in Booking app in Search page")
    public void isInBookingSearchPage(Actor actor) {
        actor.attemptsTo(
                Click.on(CLOSE_LOGIN_SCREEN_BUTTON),
                WaitUntil.the(DESTINATION_INPUT_BUTTON, isVisible())
        );

    }

    @When("search for {string}")
    public void searchLocation(String search) {
        theActorInTheSpotlight().attemptsTo(
                SearchALocation.andSelectFirstElement(search)
        );
    }

    @And("select first element on search list")
    public void selectFirstLocationElement() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(FIRST_ELEMENT_ON_DESTINATION_LIST, isVisible()),
                Click.on(FIRST_ELEMENT_ON_DESTINATION_LIST)
        );
    }

    @And("should show an empty list")
    public void shouldShowEmptyList() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(EMPTY_MESSAGE_ON_DESTINATION_LIST, isVisible()),
                Ensure.that(EMPTY_MESSAGE_ON_DESTINATION_LIST.resolveFor(theActorInTheSpotlight()).isVisible()).isTrue()
        );
    }

    @And("select dates from {string} to {string}")
    public void selectDates(String from, String to) {
        theActorInTheSpotlight().attemptsTo(
                SelectDatesOnSearch.fromTo(from, to)
        );
    }

    @And("select 1 room, 2 adults, and 1 child or children of {int} years old")
    public void selectRoomAdultsAndChildren(int years) {
        theActorInTheSpotlight().attemptsTo(
                SelectPeople.withAChild(years)
        );

    }

    @Then("click on search button")
    public void clickOnSearchButton() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(SEARCH_BUTTON)
        );
    }


    @Given("{actor} Search for accommodations in {string} for 2 adults and 1 child from {string} to {string}")
    public void searchForAccommodations(Actor actor, String place, String from, String to) {
        isInBookingSearchPage(actor);
        searchLocation(place);
        selectFirstLocationElement();
        selectDates(from, to);
        selectRoomAdultsAndChildren(5);
        clickOnSearchButton();
    }

}
