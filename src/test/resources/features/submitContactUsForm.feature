Feature: Submit Contact Us Form and verify details

  Scenario: Submit Contact Us Form and verify details
    Given I launch the browser and navigate to test automation website to submit contact us form
    Then I verify that the home page is visible to submit the form
    When I click on the Contact Us button
    Then I Verify 'GET IN TOUCH' is visible
    And I Enter name
    Then I enter my mail
    Then I enter the message
    Then I enter the subject
    And I hover over the 'Submit button'
    And I Click 'Submit button'
    And I Click 'OK' button appearing in the popup
    Then I Verify success message 'Success! Your details have been submitted successfully.' is visible
    And I Click 'Home' button and verify that landed to home page successfully
