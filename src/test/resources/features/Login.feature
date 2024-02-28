Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter Email "ana.nicora@testpro.io"
    And  I enter passwort "QaKoelApp_1234"
    And I click Submit Button
    Then I should be logged in