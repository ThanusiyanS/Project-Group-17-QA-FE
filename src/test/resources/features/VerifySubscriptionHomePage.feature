Feature: Verify Subscription Homepage Details

Scenario: Verify Subscription in home page
Given I launch the browser and navigate to test automation website
And I verify that the home page is visible successfully
When I scroll down to the footer
Then I verify the text 'SUBSCRIPTION' is visible
And I enter email address "testuser@example.com" in the subscription input and click the arrow button
Then I verify the success message 'You have been successfully subscribed!' is visible

