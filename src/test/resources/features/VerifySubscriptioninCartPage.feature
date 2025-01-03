Feature: Verify Subscription in Cart Page

  Scenario: User subscribes to newsletter from the cart page
    Given I launch the browser and navigate to test automation website
    And I verify that the home page is visible successfully
    When I click the 'Cart' button
    And I scroll down to the footer
    Then I verify the text 'SUBSCRIPTION' is visible
    When I enter email address "testuser@example.com" in the subscription input and click the arrow button
    Then I verify the success message 'You have been successfully subscribed!' is visible
