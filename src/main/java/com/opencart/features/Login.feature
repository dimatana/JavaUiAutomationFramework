Feature: Login Related Test Cases
  @run1
  Scenario: An error message is displayed when using invalid credentials
    Given "/login" endpoint is accessed
    When the login form is populated with following details
      | <email>    |
      | <password> |
    Then the following list of error messages is displayed
    |Adresa dumneavoastră de email / Parola este incorectă. Vă rugăm să încercați din nou.|
    Examples:
      | email | password |
    | dweqsuc@gmail.com      |     ffgsrggf     |