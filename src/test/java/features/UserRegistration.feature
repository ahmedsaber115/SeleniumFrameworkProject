@register
Feature: User Can Register
description : the purpose of this feature is user can register

Scenario Outline: user can register , log in and log out again
Given user is in Home Page
When he click in register link from home page 
And entered "<firstname>" , "<lastname>" ,"<email>" ,"<password>" 
And click register button from register page and check registration complete 
And click Log in link and insert "<email>" and "<password>" and click confirm button
Then ckeck if log out is displayed and log out 

Examples:
|firstname|lastname|email|password|
|ahmed|saber|ahmsff5kb0@gmail.com|12123688|
|rana|saber|ra41226ff99055992@gmail.com|45987444|
|ahmed|saber|ahmed12saber.com|126987441|