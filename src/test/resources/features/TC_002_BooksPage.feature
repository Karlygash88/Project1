Feature: : As a student, I should see books page

@1
Scenario: Student can see default value of records dropdown
  Given user logs as a student
  Then user should see dropdown value as 10
