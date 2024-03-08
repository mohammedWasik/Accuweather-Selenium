Feature: Weather Information
  I am an user
  I want to see the weather in a certain city
  I also want to see the recent location's weather

  Background:
    Given the Main page is open
    When I consent to data usage

  Scenario: Search City
    And I input "New York" in the search field
    Then the search results list should be displayed
    When I click on the first search result
    Then the city weather page header should contain the city name "New York"

  Scenario: Recent Locations
    And I choose the first city in "Recent locations"
    Then the city weather page header should contain the selected recent city name

  Scenario: Search City (Current Location)
    And I click on the search field
    Then the search results list should be displayed
    And the "Use your current location" label should be displayed
