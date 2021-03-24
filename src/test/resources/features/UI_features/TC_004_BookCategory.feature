@regression
Feature: Filtering the books by their categories
  As a Student, I can filter the books by their categories,
  then I can see all the books from the same category only.

  Background:
    Given user logs as a student

  Scenario: Student should be able to see all categories from Book Categories dropdown
    Then Student should see below info in book categories dropdown
      | ALL                     |
      | Action and Adventure    |
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |



  Scenario Outline: Student selects particular category from the dropdown
  and should see all the books from that category
    And Student selects "<category>" from category dropdown
    Then Student should see all the books from that category

    Examples: selecting the particular category
      | category                |
      | Action and Adventure    |
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |