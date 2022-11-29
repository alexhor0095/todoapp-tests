package bdd.steps

import data.Priority
import data.Task
import data.TasksRepositoryMemory
import io.cucumber.java.en.*
import io.cucumber.java.nl.En
import java.time.LocalDate
import kotlin.test.assertEquals

class TasksFilteringByDateSteps: En {
    init {
        val repository = TasksRepositoryMemory()
        Given("Add two or more tasks with different dates") {
            repository.addTask(Task(name = "B task",
                priority = Priority.MEDIUM, endDate = LocalDate.of(2024, 5, 1)))
            repository.addTask(Task(name = "A task",
                priority = Priority.HIGH, endDate = LocalDate.of(2023, 2, 1)))

        }
        When("Sorting tasks by date") {
            repository.sortingByNameOrderByASC()
        }
        Then("We get sorted tasks by date") {
            assertEquals("A task", repository.sortingByDate()[0].name)
        }
    }
}