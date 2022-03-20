Feature: Employee directory UAT verification

  Background: 
    Given launch url

  Scenario: user addition
    Given user is on home page
    Then user click on add button
    And user navigated to add page
    When user enters the following details
      | Fullname   | Jobtitle | Location | Preferences  |
      | GarryWhite | ESS      | Dallas   | Windows User |
    And user click on save button
    Then user validate the details provided are saved
