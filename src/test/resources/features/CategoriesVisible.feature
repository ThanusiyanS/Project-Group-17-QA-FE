Feature: Verify that categories are visible on left side bar

  Scenario: Verify that categories are visible on left side bar
    Given I launch the browser and navigate to test automation website to verify categories
    Then I verify that the home page is visible to verify categories
    Then I hover over the Categories
    When I click on the 'Women' button
    Then I  Click on 'Dress' category link under 'Women' category
   # Then I Verify that category page is displayed and confirm text 'WOMEN DRESS PRODUCTS'
    And On left side bar, click on any sub-category link of 'Men' category
    Then I click on any sub-category link of 'Men' category
    Then I Verify that user is navigated to that category page