Feature: Verify All Products and Product Detail Page

  Scenario: View all products and verify product detail page
    Given I launch the browser and navigate to test automation website
    And I verify that the home page is visible successfully
    When I click on the Products button
    Then I verify that the user is navigated to the ALL PRODUCTS page successfully
    And I verify that the products list is visible
    When I click on 'View Product' of the first product
    Then I verify that the user is navigated to the product detail page
    And I verify that product details are visible: product name, category, price, availability, condition, brand
