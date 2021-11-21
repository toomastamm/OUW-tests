Scenario: AFT2
Given I am on the travelplus quotation page
Then I fill the first page with valid information
Then I enter @ in the users name
Then I enter a normal surname
Then I enter a normal age
Then I click Get a Quote
Then I should see the error message

Scenario: AFT3
Given I am on the travelplus quotation page
Then I fill the first page with valid information
Then I enter a normal firstname
Then I enter a normal surname
Then I enter a invalid age
Then I click Get a Quote
Then I should see the error message

Scenario: AFT4
Given I am on the travelplus quotation page
Then I fill the first page with valid information
Then I enter a sql injection
Then I enter a normal surname
Then I enter a invalid age
Then I click Get a Quote
Then I should see the error message

Scenario: AFT5
Given I am on the travelplus quotation page
Then I fill the first page with valid information
Then I enter a firstname with an emoji
Then I enter a normal surname
Then I enter a normal age
Then I click Get a Quote
Then I should see the error message

Scenario: AFT6
Given I am on the travelplus quotation page
Then I fill the first page with valid information
Then I enter a firstname with an symbol
Then I enter a normal surname
Then I enter a normal age
Then I click Get a Quote
Then I should see the error message

Scenario: AFT7
Given I am on the openunderwriter main page
When I log in as Adam
Then I should be on the welcome page

Scenario: AFT8
Given I am on the openunderwriter main page
When I go to a protected route
Then I redirected to the welcome page

Scenario: AFT11/AFT12
Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I search for a policy by id
Then I click search
Then I will see that policy in the search results