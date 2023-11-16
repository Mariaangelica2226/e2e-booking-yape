Feature: Create booking

  @smoke @happy
  Scenario: Create booking successfully
    Given Maria Search for accommodations in "Cusco" for 2 adults and 1 child from "26 November 2023" to "30 November 2023"
    When select the second option in list of accommodations
    And books the first option of rooms
    And fills person info form
    Then verifies booking data
    And fills credit card data

