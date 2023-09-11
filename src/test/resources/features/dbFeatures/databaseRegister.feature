Feature: week 4 database 2
  Scenario: database de kullanici okuma
    Given connection mysql database
    When we create new user
    Then assert new user in database

    @SQLiteDB
    @smoke
    Scenario: database sqlite okuma
      When sql database bilgisi yazdir
