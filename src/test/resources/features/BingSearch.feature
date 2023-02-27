Feature: Bing search functionality
  Agile story: As a user, when I am on the Bing search page
  I should be able to search anything and see relevant results

@bing
  Scenario: Search title verification
    Given user is on the Bing search page
    When user searches for orange
    Then user should see orange in the title