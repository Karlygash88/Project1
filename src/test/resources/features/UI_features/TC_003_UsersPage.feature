Feature: As a librarian, I should see data on dashboard page

  @smoke
  Scenario: Librarian should land on dashboard
    Given user logs as a librarian
    Then user should land on "dashboard" page
    And librarian should see users count as 8626
    And librarian should see books count as 2086
    Then librarian should see borrowed books count as 768

