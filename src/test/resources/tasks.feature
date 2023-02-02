Feature: Tasks
  Scenario: Adding new task
    Given Task repository
    When Add new task
    Then Have new task

  Scenario: Complete task
    Given Add New task
    When Complete task
    Then Have new complete task

