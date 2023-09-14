Business Need: example 1

  @UI
  Scenario: links test 1
    Given users goes to homepage
    When user clicks on home button
    Then verify url is "https://test.kesifplus.com/"

    When user clicks on about us button
    Then verify url is "https://test.kesifplus.com/about-us"

    @UI
    Scenario: link test 2
      Given users goes to homepage
      Then assert with enum