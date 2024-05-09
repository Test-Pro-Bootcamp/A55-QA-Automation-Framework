Feature: New Smart Playlist

  Scenario: Create smart playlist with one rule
    Given I open page
    When I enter the email "jason.fenstermaker1234@testpro.io"
    And I enter the password "Testpro.io2"
    And I click on koel login button
    Then I should now be logged in
    And I select + by playlist
    And I select New Smart Playlist
    And I enter SprintSix into NAME field
    And I select dropdown that Title Contains
    And I enter the letter a
    And I select SAVE
    Then New Smart Playlist SprintSix appears in the sidebar


  Scenario: Create a Smart playlist in app with multiple rules
    Given I open page
    When I enter the email "jason.fenstermaker1234@testpro.io"
    And I enter the password "Testpro.io2"
    And I click on koel login button
    Then I should now be logged in
    And I select + by playlist
    And I select New Smart Playlist
    And I enter SprintSix.MultipleRules into NAME field
    And I select dropdown that Title Contains
    And I enter the letter a
    And I select the ADD RULE button
    And I select dropdown that Title Begins With
    And I enter the letter a again
    And I select SAVE
    Then New Smart Playlist SprintSix.MultipleRules appears in the sidebar

    Scenario: Create a Smart playlist in app with Group
      Given I open page
      When I enter the email "jason.fenstermaker1234@testpro.io"
      And I enter the password "Testpro.io2"
      And I click on koel login button
      Then I should now be logged in
      And I select + by playlist
      And I select New Smart Playlist
      And I enter SprintSix.Group into NAME field
      And I select dropdown that Title Contains
      And I enter the letter a
      And I select the GROUP button
      And I select second dropdown that Title Contains
      And I enter the letter b
      And I select SAVE
      Then New Smart Playlist SprintSix.Group appears in the sidebar







