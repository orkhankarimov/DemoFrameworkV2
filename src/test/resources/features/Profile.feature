@regression @profile
Feature: This feature file will validate Home Page functionality

  Background:
    Given user navigates to HUDL Landing Page
    When user navigates to HUDL Login Page
    Then user logs in to HUDL homepage with valid credentials
    And user should be able to verify account name on HUDL Homepage

  Scenario Outline: User should be able to validate coach profile
    Then user makes a search for <user> on HUDL Homepage
    And user validates <user> profile on HUDL Homepage

    Examples:
      | user        |
      | Ethan Ball  |
      | Chloe Knepp |