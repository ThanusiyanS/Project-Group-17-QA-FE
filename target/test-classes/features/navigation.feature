Feature: Website Navigation Testing

  Scenario: Verify navigation links
    Given I am on the homepage
    When I click on all the navigation links
    Then I should navigate to the correct page with matching titles
