Feature: Android demo script

  Scenario: Login
    Given Login with username "standard_user" and password "secret_sauce"

  Scenario Outline: verify user able to order product
    Then add "<productName>" product to cart
    And verify "<productName> " product is added to cart page
    Then checkout the added product
    And fill out the first name "<firstName> "
    And fill out the last name "<lastName>"
    And fill out the postal code "<postalCode>"
    Then click continue button
    Then verify "<productName>" product in overview page
    And click finish btn and verify complete page is displayed
    Then click back to home btn and verify home page is displayed

    Examples:
      | productName           | firstName  | lastName | postalCode |
      | Sauce Labs Backpack   | QA         | Tester   | 12456      |
      | Sauce Labs Bike Light | Automation | Engineer | 987456     |


  Scenario: verify user able to remove selected product from cart
    Then add a product to cart
    And verify the product is added to cart page
    And remove the added product from cart
    Then verify selected product is removed from cart
    And click continue shopping button
    And verify it's navigated to the home page

