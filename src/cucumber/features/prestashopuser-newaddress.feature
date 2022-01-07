Feature: PrestaShopUser-NewAddress

  Scenario Outline: Adding a new address by filling the form of sample data from the logged-in user
    Given Web page https://mystore-testlab.coderslab.pl opened in browser
    And logged on a previously created user using the correct e-mail and password
    When Clicked on the 'Addresses' tile after logging in
    And clicked on '+ Create new address'
    And filled the 'New address' form with data: <alias>, <address>, <city>, <zipcode>, <country>, <phone>
    And clicked on 'Save' button
    And checked if the data in the form is correct
    Then Added new address with corrected data
    Examples:
      | alias | address         | city       | zipcode | country        | phone     |
      | Kowal | 89 Crown Street | Manchester | 56-254  | United Kingdom | 872123942 |