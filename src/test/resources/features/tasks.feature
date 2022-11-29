Feature: Tasks
  Scenario: Adding new task
    Given Task repository
    When Add new task
    Then We have new task

  Scenario: Complete task
    Given Add New task
    When Complete task
    Then Have new complete task

  Scenario: Sorting tasks by name
    Given Add two or more tasks with different names
    When Sorting tasks by name
    Then We get sorted tasks by name

  Scenario: Sorting tasks by date
    Given Add two or more tasks with different dates
    When Sorting tasks by date
    Then We get sorted tasks by date



