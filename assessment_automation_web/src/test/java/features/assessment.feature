Feature: Assessment Test Execution


  Scenario: TC1 : User registration
    Given  the user should see the header "Log in" on the page
    When user click on the signup button
    And the user should see the sub header as "Just a few more steps and you're finished!"
    And user enters "Sam" as "First Name"
    And user enters "Anderson" as "Last Name"
    And user enters "sam@gmail.com" as "Email"
    And user enters "String@123456" as "Password"
    And user selects 1994 as year "June" as month 2 as date for "Date of birth"
    And user enters "07736985699" as "Mobile No"
    And user adds "SW1A 1AA" as "Postcode"
    And user validates the postcodes
    And user clicks enter it manually option
    And user adds "Rose Cottage" as "Building Name"
    And user adds "10" as "Building Number"
    And user adds "High Street" as "Address 1"
    And user adds "Sutton" as "Address 2"
    And user adds "London" as "Town or City"
    And user adds "Greater London" as "County"
    Then user click on "Next" button
    Then user click on "Next" button
    And the user should see the header as "Every point matters" in points page
    And user click on "Next" button
    And user select plan as "Lite"
    Then user click on "Next" button
    And user click on "Show me how" button
    Then user click on "Start now" button



