Scenario: Filter records Test 15

Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I select statuses "i18n_policy_search_all"
Then I sort by "Created Date DESC"
Then I click search
Then records are shown

Scenario: Filter records Test 16

Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I select statuses "i18n_policy_search_all"
Then I select the product "AIL.Demo.LifeAggregator"
Then I sort by "Created Date DESC"
Then I click search
Then the following record IDs are shown "QF1046, QF1044, QF1042, QF1041"

Scenario: Filter records Test 17

Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I select statuses "i18n_policy_status_application"
Then I sort by "Created Date DESC"
Then I click search
Then the following record IDs are shown "QF1047, QF1046, QF1045, QF1044, QF1043, QF1042, QF1041, 1573"

Scenario: Filter records Test 18

Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I select statuses "i18n_policy_status_application"
Then I select the product "AIL.Demo.LifeAggregator"
Then I sort by "Created Date DESC"
Then I click search
Then the following record IDs are shown "QF1041, QF1042, QF1044, QF1046"

Scenario: Filter records Test 19

Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I select statuses "i18n_policy_status_submitted"
Then I sort by "Created Date ASC"
Then I click search
Then the following record IDs are shown "QF99912, POL1000, QF1007, QF1013, POL1001, POL1002"

Scenario: Filter records Test 20

Given I am on the openunderwriter main page
When I log in as Adam
Then I go to the policies page
Then I select statuses "i18n_policy_status_submitted"
Then I select the product "AIL.Demo.LifeAggregator"
Then I sort by "Created Date ASC"
Then I click search
Then no results are found