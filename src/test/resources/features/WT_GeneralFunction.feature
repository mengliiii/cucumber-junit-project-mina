Feature: ome of the general functionality verifications

  @wt4
  Scenario: Dropdown options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

  @wt5
  Scenario: Payment options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees Visa as enabled payment option
    Then user sees MasterCard as enabled payment option
    Then user sees American Express as enabled payment option

  @wt6
  Scenario: Oder Place verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user selects Product "Familybea"
    And user enters quantity "2"
    Then user clicks to the calculate button
    And user enters customer name "Jimmy Key"
    And user enters street name "OrangeTree Street"
    And user enters city name "Orlando"
    And user enters state name "Florida"
    And user enters zip code "32819"
    And user selects card type "Visa"
    And user enters card number "1111222233334444"
    And user enters expire date "12/25"
    And user clicks to Process Order button
    Then user should see "Jimmy Key" in the first row of the web table

  @wt7
  Scenario Outline: Oder Place verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user selects Product "<product>"
    And user enters quantity "<quantity>"
    Then user clicks to the calculate button
    And user enters customer name "<customerName>"
    And user enters street name "<street>"
    And user enters city name "<city>"
    And user enters state name "<state>"
    And user enters zip code "<zip>"
    And user selects card type "<paymentType>"
    And user enters card number "<cardNumber>"
    And user enters expire date "<expireDate>"
    And user clicks to Process Order button
    Then user should see "<expectedName>" in the first row of the web table
    Examples:
      | product    | quantity | customerName | street | city | state | zip   | paymentType | cardNumber       | expireDate | expectedName |
      | Familybea  | 3        | Ali Doe      | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25      | Ali Doe     |
      | MoneyCog   | 2        | Black Doe    | 8th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25      | Black Doe     |
      | Screenable | 1        | Carol Doe    | 9th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25      | Carol Doe     |