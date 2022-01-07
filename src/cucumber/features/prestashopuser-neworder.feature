Feature: PrestaShopUser-NewOrder
  Scenario Outline: Adding a new order by selecting a sample product in an exemplary size and quantity, adding it to the basket, confirming the address and selecting the method of collection and payment from the logged-in user
    Given Web page https://mystore-testlab.coderslab.pl opened in Google Chrome browser
    And logged on a previously created user using the same e-mail and password as when adding a new address
    When Searched for 'Hummingbird Printed Sweater' for purchase
    And selected size <size>
    And selected <quantity> items
    And added a product to the cart
    And selected checkout options
    And confirmed previously added address
    And selected the pickup method as 'Pick up in-store'
    And selected the payment option as 'Pay by Check'
    And agreed to the terms of service and to adhere with them unconditionally
    And clicked on 'Order with an obligation to pay'
    Then Confirmed a new order by a screenshot with the order confirmation and the amount
    Examples:
      | size | quantity |
      | M    | 5        |