Feature: week 4 database 1
  Scenario: database de kullanici okuma
    Given connection mysql database
    When we create new user
    Then assert new user in database