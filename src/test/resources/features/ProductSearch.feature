Feature: Search for a product

  Scenario: Search for a specific product by name
    Given I launch the browser and navigate to test automation website to search product
    Then I verify that the home page is successfully visible
    When I click on the Products button in home page
    And I verify that the user is navigated to the "ALL PRODUCTS" page successfully
    When I enter a product name in the search input
    When I click the Search button
    Then I verify that the SEARCHED PRODUCTS section is visible
