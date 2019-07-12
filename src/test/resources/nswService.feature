Feature: Apply for a license plate

Scenario Outline: Successful search for the license and suburb
Given  User successfully navigate to the URL

Given User successfully search "Apply for a number plate"
Then user navigates to the appropriate page
And user validates the navigated page "Apply for a number plate"
Then user click on the Find Location button
And Enter the "<suburb>"
Then Search for the "<service_center>"




Examples:
    | suburb 		              | service_center 				|
    | Sydney 2000                 | Marrickville Service Centre |
    | Sydney Domestic Airport 2020| Rockdale Service Centre		|
