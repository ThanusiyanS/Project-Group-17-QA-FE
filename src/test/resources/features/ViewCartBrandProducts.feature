Feature: View Cart Brand Products

Scenario: Verify Brand Functionality on Products Page
Given I launch the browser and navigate to the test automation website to verify brands functionality
Then I verify that the home page is visible
When I click on the 'Products' button
Then I verify that 'Brands' are visible on the left sidebar
When I click on a brand name
Then I verify that the user is navigated to the brand page
And I verify that brand products are displayed
When I click on another brand name on the left sidebar
Then I verify that the user is navigated to the other brand page
And I verify that the other brand's products are displayed
And I click the 'Home' button and verify that I landed on the home page successfully
