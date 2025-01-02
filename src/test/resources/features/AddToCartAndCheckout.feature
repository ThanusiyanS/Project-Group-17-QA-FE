Feature: Add Product to Cart and Verify Details

  Scenario: Add a product to the cart and verify details
    Given I launch the browser and navigate to test automation website
    Then I verify that the home page is visible successfully
    When I click on the Products button
    And I hover over the first product and click 'Add to cart'
    And I click 'View Cart' button
    Then I verify the product is added to the cart
    And I verify the price, quantity, and total price