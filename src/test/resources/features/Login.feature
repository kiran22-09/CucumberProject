Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into email field
And User has entered valid password <password> into password field
And user clicks on login button 
Then user should get successfully logged in
Examples:
|username              |password|
|amotooricap3@gmail.com|12345   |
|krian2025@gmail.com   |12345   |

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address "amotooricaprhugv3@gmail.com" into email field
And User has entered valid password "123456789" into password field
And user clicks on login button 
Then user should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password 
Given User has navigated to login page
When User enters valid email address "amotooricap3@gmail.com" into email field
And User has entered invalid password "12345678984" into password field
And user clicks on login button 
Then user should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password 
Given User has navigated to login page
When User enters invalid email address "amotooricaphjrekgnfsd3@gmail.com" into email field
And User has entered valid password "12345" into password field
And user clicks on login button 
Then user should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials 
Given User has navigated to login page
When User dont enters email address into email field
And User dont enters password into password field
And user clicks on login button 
Then user should get a proper warning message about credentials mismatch