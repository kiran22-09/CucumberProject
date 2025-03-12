Feature: Registration Functionality

Scenario: User creates an account with only mandatory fields
Given User navigates to Register Account Page 
When User enters the details into the below fields 
|firstName                   |krishna                  |
|lastName                    |Gundra                 |
|email                       |kri025@gmail.com     |
|telephone                   |123456789              |
|password                    |12345                  |
And User select Privacy Policy
And User clicks on continue button
Then User account should be created successfully  


#Scenario: User creates a duplicate account
#Given User navigates to Register Account Page 
#Then User enters the details into the below fields 
#|firstName                   |kiran                  |
#|lastName                    |Gundra                 |
#|email                       |krian2025@gmail.com     |
#|telephone                   |123456789              |
#|password                    |12345                  |
#And User selects Yes for Newsletter
#And User select Privacy Policy
#And User clicks on continue button
#Then User gets a proper warning message about duplicate email  


#Scenario: User creates an account without filling any details 
#Given User navigates to Register Account Page 
#When User dont enter any details 
#And User clicks on continue button
#Then User gets a proper warning messages for every mandatory fields
 