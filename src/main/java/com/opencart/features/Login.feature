Feature: Login Related Test Cases

  @run1
  Scenario Outline: An error message is displayed when using invalid credentials
    Given "/login" endpoint is accessed
    When the login form is populated with following details
      | <email>    |
      | <password> |
    And the "loginButton" from "LoginPage" is clicked
    Then the following list of error messages is displayed
      | Adresa dumneavoastră de email / Parola este incorectă. Vă rugăm să încercați din nou. |
      | Adresa dumneavoastră de email / Parola este incorectă. Vă rugăm să încercați din nou. |
    Examples:
      | email             | password |
      | dweqsuc@gmail.com | ffgsrggf |

    @Regression
    Scenario Outline: Successful login with valid data credentials
      Given "/login" endpoint is accessed
      When the following form "LoginPage" is populated as follow:
        | emailInput    | <emailInput>    |
        | passwordInput | <passwordInput> |
      And the "loginButton" from "LoginPage" is clicked
      Then the current Url contains "my-account" keyword
      Examples:
        | emailInput               | passwordInput |
        | dima.tanasciuc@gmail.com | 19932008      |


