Feature: Add review on products and verify details

  Scenario: Add review on products and verify details
    Given I launch the browser and navigate to test automation website to add a review
    Then I verify that the home page is visible
    When I click on the Products button to add review
    And I hover over the first product and click view product
    Then I hover over the review forum
    Then I enter my name
    Then I enter my mailId
    Then I enter my review
    Then I click on the submit button
    Then I verify the review success message is displayed