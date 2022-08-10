#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: Login,Logout Scenarios

Feature: Login and Logout Functionality
Description this feature validates login and logout functionalities

Scenario:Login with valid credentials
Given I launch the chrome browser
And I navigate the Application url
When I enter the username in username text field
And I enter the password in password text field
And I click on login button
Then I find the home page
And I click on minimize flyout window

Scenario: Logout functionality
Then I find the home page
When I click on logout link
Then I find the login page
And I close Application