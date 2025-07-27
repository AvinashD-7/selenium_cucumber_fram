@smoke @regression
Feature: Login feature

  Scenario: Successful login
    Given user is on login page
    When user enters username "admin" and password "admin123"
    Then user should be logged in

  Scenario: Login with empty username
    When user enters username "" and password "admin123"
    Then I should see the error message "Required" below the username field

  Scenario: Login with empty password
    When user enters username "admin" and password ""
    Then I should see the error message "Required" below the password field

  Scenario: Login with empty username and password
    When user enters username "" and password ""
    Then I should see the error message "Required" below the username field
    And I should see the error message "Required" below the password field

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