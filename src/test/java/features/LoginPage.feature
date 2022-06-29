Feature: Login page
  In order to use the website
  As a client
  I want to login successfully

Scenario Outline: User should not be able to login with invalid credential
When the client is on the login page
And enters: '<username>' and '<password>'
Then System should display '<errorMsg>' Error Message

Examples:
| username      | password     | errorMsg                                                                   |
| standard_user | smthElse     | Epic sadface: Username and password do not match any user in this service  |
| smth_else     | secret_sauce | Epic sadface: Username and password do not match any user in this service |

  Scenario: Login with valid username and password
    Given the client is on the login page
    When provides username: "standard_user" and password: "secret_sauce"
    Then the user is  successfully logged


