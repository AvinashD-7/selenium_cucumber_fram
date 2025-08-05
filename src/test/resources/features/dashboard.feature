@smoke @regression
Feature: Login feature

  Background:
    Given the user has logged in successfully

  Scenario: Verify all dashboard sections are displayed correctly
    Then the dashboard should display the following sections:
      | Time at Work                        |
      | My Actions                          |
      | Quick Launch                        |
      | Buzz Latest Posts                   |
      | Employees on Leave Today           |
      | Employee Distribution by Sub Unit  |
      | Employee Distribution by Location  |
