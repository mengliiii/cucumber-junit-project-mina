Feature: Web table app login functionality
  Agile story: user should be able to login with correct credential

  @wt1
  Scenario: login url verification
    Given user is on Web Table login page
    Then user enters user name
    And user enters password
    And user clicks to login button
    Then Verify the URL

  @wt2
  Scenario: login url verification
    Given user is on Web Table login page
    Then user enters "Test" as user name and "Tester" as password
    And user clicks to login button
    Then Verify the URL

  @wt3
  Scenario: login url verification
    Given user is on Web Table login page
    Then user enters below correct credentials
      | username | Test   |
      | password | Tester |
    And user clicks to login button
    Then Verify the URL