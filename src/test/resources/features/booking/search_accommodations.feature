Feature: Search for accommodations

  @smoke @happy
  Scenario: Search for accommodations
    Given Maria is in Booking app in Search page
    When search for "Cusco"
    And select first element on search list
    And select dates from "26 November 2023" to "30 November 2023"
    And select 1 room, 2 adults, and 1 child or children of 5 years old
    Then click on search button
    And wait for results

  @smoke @unhappy
  Scenario: Search for accommodations and validate empty result
    Given Maria is in Booking app in Search page
    When search for "SomethingThatIsNotLegible"
    Then should show an empty list