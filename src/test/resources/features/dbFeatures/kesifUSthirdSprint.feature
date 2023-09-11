Feature: I should be able to see the course list in the database

  Scenario:Get Cources List from website
    Given login account page
    When Login Account text is visible
    Then enter username
    Then enter password
    Then click on login button
    Then click on programs button on side bar
    And verify courses

  Scenario: Get Informations from database
    Given connect with database
    Then execute a query
    Then make assertions