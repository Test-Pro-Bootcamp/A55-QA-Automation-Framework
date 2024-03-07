Feature:
    Scenario: Login with valid email and password
    Given Open the browser
    When navigate to koel website
    Then website opens with input fields for email and password; submit button for login
    And koel logo is visible
    When enter valid email address and valid password and click on login button
    Then homepage is opened with avatar icon visible.

    Scenario:
      Given Open the browser
      When navigate to koel website
      Then website opens with input fields for email and password; submit button for login
      And koel logo is visible
      When enter invalid email address and valid password and click on login button
      Then koel logo is visible
