Feature: GmailTest

  Background:
    Given I opened LogInPage

  Scenario Outline: Log In Under account

    When I entered email
    And I opened GmailPasswordPage entered password
    Then I opened GmailMainPage

    Examples:
      | email                 | password         |
      | HannaTest34@gmail.com | PasswordPassword |


