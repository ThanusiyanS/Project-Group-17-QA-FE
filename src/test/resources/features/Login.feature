Feature: Login functionality
  As a user
  I want to log into the website
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username "parkdan996@gmail.com" and password "1234"
    And I click on the login button
    Then I should see the user dashboard

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter invalid username "wrong@example.com" and password "wrong123"
    And I click on the login button
    Then I should see an error message
