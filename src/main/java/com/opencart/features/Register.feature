Feature: Register Flow Test Suite

  Scenario: Register Page can be accessed from the HomePage
    Given HomePage is displayed
    When registerLink from Header menu is clicked
    Then the current Url contains "https://www.elefant.md/new-account?TargetPipeline=ViewProfileSettings-ViewProfile" keyword

    Scenario: The account Page URL is opened when the registration is successful
      Given HomePage is displayed
      And registerLink from Header menu is clicked
      When the register form is populated with valid random data
      And Continue button is clicked
      Then the current Url contains "my-account/profile?" keyword

  Scenario: user remains on registerPage when the continue button is no clicked
    Given "/" endpoint is accessed
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    Then the current Url contains "new-account?TargetPipeline" keyword