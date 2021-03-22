
Feature: Verify both students and librarians can login and land on their respective pages


  Scenario Outline: Users can login and land to main pages

    Given user login as a "<role>"
    Then user should land on "<page>" module

    Examples:

      | role      | page      |
      | student   | books     |
      | librarian | dashboard |


  Scenario: Student logs in
    Given user logs as a student
    Then user should land on books page