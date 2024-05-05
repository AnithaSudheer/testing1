Feature:Login Functionality

  As a user of the e-commerce website
  I want to be able to log in to my account
  So that I can register with my name

  Scenario: Registration Page with empty name field
    Given Iam on the login page
    When I Click on the Register button
    And I click on the Register Now button
    Then an error message 'Please enter your name' should be visible

  Scenario: Registration Page with valid inputs
    Given Iam on the login page
    When I Click on the Register button
    And I enter valid input and select 'Games option' from the dropdown list
    And I click on the Register Now button
    Then I should be redirected to the Home page