Feature: Add to Cart from Recommended Items

  Scenario: User adds a recommended product to the cart
    Given I launch the browser and navigate to test automation website
    And I verify that the home page is visible successfully
    And I scroll to the bottom of the page
    And I verify 'RECOMMENDED ITEMS' are visible
    When I click on 'Add To Cart' on a recommended product
    And I click on 'View Cart' button
    Then I verify that the product is displayed in the cart page
