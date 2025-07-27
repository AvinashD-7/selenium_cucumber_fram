@smoke @regression
Feature: Login feature

  Scenario: Successful login
    Given user is on login page
    When user enters username "admin" and password "admin123"
    Then user should be logged in

  Scenario Outline: Successful and unsuccessful login attempts
    Given user is on login page
    When user enters username "<username>" and password "<password>"
    Then user should be <login_result>

    Examples:
      | username | password   | login_result |
      | Admin    | admin123   | logged in    |
      | user1    | wrongpass  | not logged in |
      | Admin    | admin123   | logged in    |
      | test     | test1234   | not logged in |