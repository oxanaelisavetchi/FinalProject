@LoginFunctionality
Feature: Login Tests


  Background: Navigate to Home
    Given user navigates to 'Home' page
@UI
  Scenario Outline: Check the login functionality with valid credentials
    When user enters the <username> and <password>
    Then user enters on product page

    Examples:
      | username                  | password       |
      | "standard_user"           | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "performance_glitch_user" | "secret_sauce" |
