Feature: I can get As

  Scenario: Get All As
    When I get /as
    Then I expect As with Ids 0, 1 and 2

  Scenario: Get All As with at least one B that has a status of -1
    When I get /as/bMinusOne
    Then I expect As with Ids 0 and 1