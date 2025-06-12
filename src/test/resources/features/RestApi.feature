@API
Feature: Rest Api Tests

  Background: Ensure API is available
    Given the API is accessible via the configured base URL

  @GetRequests
  Scenario Outline: Validate GET endpoint responses
    When a GET request is sent to the endpoint "<path>"
    Then the response of GET status code should be <status> with message "<message>"
    And the response should contain "<data>" with value <value>

    Examples:
      | path       | status | message         | data       | value |
      | USERS_ID   | 200    | Single user     | data.id    | 2     |
      | UNKNOWN_2  | 200    | Single resource | data.id    | 2     |
      | USERS_PAGE | 200    | List user       | per_page   | 6     |

  @RegisterUser
  Scenario: Register user successfully
    When I create a user with the following details:
      | email    | eve.holt@reqres.in |
      | password | pistol             |
    Then the response status code should be 200, with message "User registered"
    And the response should contain field "id"
    And the response should contain token
