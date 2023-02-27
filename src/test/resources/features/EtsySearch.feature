@etsy
Feature: Etsy search functionality
  Agile story : User should be able to type any keyword and see relevant information

  @etsy1
  Scenario: Etsy title verification
    Given user is on the Etsy home page
    Then user should see tile is as expected
    #Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
  @etsy2
  Scenario: Etsy title verification
    Given user is on the Etsy home page
    Then User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title

  @etsy3
  Scenario: Etsy title verification
    Given user is on the Etsy home page
    Then User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden spoon" is in the title