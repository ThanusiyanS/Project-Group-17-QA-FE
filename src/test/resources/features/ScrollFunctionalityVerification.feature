Feature: Verify Scroll Up using 'Arrow' button and Scroll Down functionality

  Scenario: Scroll down to bottom and scroll up to top using 'Arrow' button
    Given I launch the browser and navigate to test automation website
    Then I verify that the home page is visible successfully
    When I scroll down to the bottom of the page
    Then I verify that 'SUBSCRIPTION' is visible
    When I click on the 'Arrow' button at the bottom right to scroll up
    Then I verify that the page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on the screen
