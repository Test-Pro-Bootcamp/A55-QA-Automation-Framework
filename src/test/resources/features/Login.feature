Feature: Login feature

  Scenario: Login Success
    #Given I open Login Page
    When I enter email "nicolai.luta@testpro.io"
    And I enter password "tAPO0uuR"
    And I click on login button
    Then I should be logged in
