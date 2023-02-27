Feature: Google search functionality
  Agile story:As a user, when I am on the Google search page
  I should be able to search anything and see relevant results

  Scenario: Search page default title verification
    When user is on the Google search page
    Then user should see the title is Google
    # Mac--->command + option +L for formatting



  Scenario: Search result title verification
    Given user is on the Google search page
    When user searches for "orange"
    Then user should see "orange - Google Search" in the title