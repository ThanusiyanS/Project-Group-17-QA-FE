Feature: Verify Product Quantity in Cart

  Scenario: Verify adding a product to the cart with exact quantity
    Given I launch the browser and navigate to test automation website
    And I verify that the home page is visible successfully
    When I click on 'View Product' of the first product
    Then  I verify that the user is navigated to the product detail page
    When I increase the quantity to 1
    And I click Add to cart button
    And I click on 'View Cart' button
    Then I verify that the product is displayed in the cart page with exact quantity 1
