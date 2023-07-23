@register
Feature: Automate End2End Tests
description : the purpose of this feature is test End 2 End Integration.

Scenario Outline: Customer place an order by purchasing an item from search 
Given user is in Home Page
When he search for "<productName>"
And choose to buy Tow items
And moves to checkout cart and enter personal details on checkout page and place the order 
Then he can view the order and download the invoice



Examples:
|  productName                |
|  Apple MacBook Pro 13-inch  |