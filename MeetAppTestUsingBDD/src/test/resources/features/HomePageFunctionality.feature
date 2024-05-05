Feature: Home page Functionality
  As a user of the e-commerce website
  I want to be able to logout of my account
  So that I can log in when I desire

  Scenario:  Functionality of the Home page

    Given Iam on the login page
    When I Click on the Register button
    And I enter valid input and select 'Games option' from the dropdown list
    And I click on the Register Now button
    Then I can view with the login name