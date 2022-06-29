Feature: product features
  In order to be on shop page
  As a client
  I want to add items to the cart

  Scenario Outline: Add products to the cart
    Given the logged client is on the products page
    And the client adds the following items to the cart:
      | Item1   | Item2   |
      | <Item1> | <Item2> |
    When the client navigates to the Checkout Page
    Then all items are successfully added

    Examples:
      | Item1               | Item2                   |
      | Sauce Labs Backpack | Sauce Labs Bike Light   |
      | Sauce Labs Onesie   | Sauce Labs Bolt T-Shirt |

  Scenario: Verify inventory item names are in descending order
    Given Client click on filter icon
    And Select 'Name (Z to A)' from the dropdown
    Then Item 'names' should be in descending order

  Scenario: Verify inventory item prices are in ascending order
    Given Client click on filter icon
    And Select 'Price (low to high)' from the dropdown
    Then Item 'prices' should be in ascending order

