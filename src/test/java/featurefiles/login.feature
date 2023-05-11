Feature: Application Login

Scenario: Login using valid credentials
Given Open any browser
And navigate to login page
When User enters username and password
And clicks login button
Then authentication page opens
