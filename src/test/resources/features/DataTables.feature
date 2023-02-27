Feature: Cucumber Data Tables implementation practices


  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | pear       |
      | eggplant   |
    #to beatify the pipes===> command option L

  #create a new scenario where we list the type of pets we love
  #print out all the string in the list

  Scenario: List of pets I love
    Then user should see below pet list
      | cat    |
      | dog    |
      | parrot |
      | duck   |


  Scenario: Officer reads data without driver
    Then officer is able to see any data he wants
      | name    | Jane      |
      | surname | Doe       |
      | age     | 29        |
      | address | somewhere |
      | state   | CA        |
      | zipcode | 43090     |
      | phone   | 999999999 |
  @dataTable
  Scenario: User should be able to see all 12 moths in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |
