Feature: searching for the availability of the flights

Scenario: searching for flights from bangaluru
Given User is navigated to the Website 
And verify the title of the page
When user enter all required details
 |bangaluru|pune|15/04/2022|15/04/2022|
Then verify that navigated successfully to flight page