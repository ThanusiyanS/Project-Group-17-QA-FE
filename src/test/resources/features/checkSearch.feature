Feature: Website Search Verification

  Scenario: Verify search functionality on the homepage
    Given I am on the homepage of UOM website
    When I check the search icon
    Then I search for a keyword
