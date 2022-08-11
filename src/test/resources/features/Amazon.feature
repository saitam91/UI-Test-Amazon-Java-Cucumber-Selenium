@Amazon
Feature: Testing different actions on Amazon

Scenario Outline: As a customer when I search for Nintendo, I want to see if the third option on the second page is available for purchase and can be added to the cart.

Given the user navigate to www.amazon.com
And search for <Product>
When navigate to page number 2
And select item 3
Then the user is able to add it to the cart

  Examples:
          |Product        |
          |Playstation    |
