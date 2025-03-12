Feature: Search Functionality

Scenario: User searches for a valid product
Given User navigates to the page
When User enters valid product "HP" into Search box field
And User clicks on the Search button 
Then User should get a valid product displayed in serch results


Scenario: User searches for an invalid product
Given User navigates to the page
When User enters invalid product "Honda" into Search box field
And User clicks on the Search button 
Then User should get a message about no product matching


Scenario: User searches without any product
Given User navigates to the page
When User dont enters any product into Search box field
And User clicks on the Search button 
Then User should get a message about no product matching