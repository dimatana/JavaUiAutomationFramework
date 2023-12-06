Feature: Register Flow Test Suite

  Scenario: Register Page can be accessed from the HomePage
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current Url contains "https://www.elefant.md/new-account?TargetPipeline=ViewProfileSettings-ViewProfile" keyword

    Scenario: The account Page URL is opened when the registration is successful
      Given "/new-account?TargetPipeline=ViewProfileSettings-ViewProfile" endpoint is accessed
      When the register form is populated with valid random data
      And the "continueButton" from "RegisterPage" is clicked
      Then the current Url contains "my-account/profile?" keyword

  Scenario: user remains on registerPage when the continue button is no clicked
    Given "/" endpoint is accessed
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    Then the current Url contains "new-account?TargetPipeline" keyword

    @run
    Scenario Outline: An error message is displayed when invalid data is used for register flows
      Given "/new-account?TargetPipeline=ViewProfileSettings-ViewProfile" endpoint is accessed
      And the register form is populated with the following data:
        | firstName | <firstName>    |
        | lastName  | <lastName>     |
        | email     | <emailData>    |
        | password  | <passwordData> |
        | xpath     | <xpath>        |
      And the "continueButton" from "RegisterPage" is clicked
      Then the following list of error messages is displayed
        | Only alphanumeric characters are allowed. |
      Examples:
        | impacted attribute | firstName | lastName |  | emailData   | passwordData | xpath |
        |                    | Dima!     | Random   |  | RandomEmail | Random       | xpath |
        |                    | Dima      | Tana1!   |  | Random      | Random       | xpath |

