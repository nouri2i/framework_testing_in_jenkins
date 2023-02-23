Feature: Google Search
  Scenario: search for edgewords
    Given   I am on the Google
    When  I search for "Edgewords"
    Then  "Edgewords" appears in the results
#    Scenario Outline:
#      Given I am in Google
#      When  I search for "something"
#      Then "something" appears in the results
#      Examples:
