Feature: Login feature
  Scenario:
    Given I open browser
    And I open Login page
    When I enter email "charita.ramnathsing@testpro.io"
    And I enter password "108KvbVhb2024"
    And I submit
    Then I am logged in
