Feature: View Category Products

  Scenario: Verify navigation and product display in categories
    Given I launch the browser and navigate to test automation website
    Given I verify that categories are visible on the left sidebar
    When I click on the 'Women' category
    And I click on the Dress link under 'Women' category
    Then I verify that the category page is displayed with text 'WOMEN - DRESS PRODUCTS'
