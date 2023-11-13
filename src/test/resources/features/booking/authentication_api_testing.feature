Feature: Authentication API Testing

  @smoke @happypath
  Scenario Outline: Successful user authentication
    Given  The API endpoint is "https://restful-booker.herokuapp.com/auth"
    When a POST request is made with username "<username>" and password "<password>"
    Then the response status code should be <status_code>
    And the response should contain a token
    Examples:
      | username | password    | status_code |
      | admin    | password123 | 200         |

  @smoke @unhappypath
  Scenario Outline: Failed Authentication
    Given The API endpoint is "https://restful-booker.herokuapp.com/auth"
    When a POST request is made with username "<username>" and password "<password>"
    Then the response status code should be <status_code>
    And the response should contain the text "Bad credentials"
    Examples:
      | username    | password    | status_code |
      | invaliduser | invalidpass | 400         |
