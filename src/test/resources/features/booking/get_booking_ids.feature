Feature: Get Booking IDs

  Scenario: Request all booking IDs
    Given I request all booking IDs
    Then I validate the response with a JSON Schema
