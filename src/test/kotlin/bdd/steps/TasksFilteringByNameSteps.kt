package bdd.steps

import data.Priority
import data.Task
import data.TasksRepositoryMemory
import io.cucumber.java.en.
import io.cucumber.java.en.*
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import java.time.LocalDate
import kotlin.test.assertEquals

class TasksFilteringByNameSteps :  {
    init {
        val repository = TasksRepositoryMemory()
        Given("Add two or more tasks with different names") {
            repository.addTask(Task(name = "B task", priority = Priority.MEDIUM,
                endDate = LocalDate.of(2023, 1, 1)))

            repository.addTask(Task(name = "A task", priority = Priority.MEDIUM,
                endDate = LocalDate.of(2023, 1, 1)))
        }
        When("Sorting tasks by name") {
            repository.sortingByNameOrderByASC()
        }
        Then("We get sorted tasks by name") {
            assertEquals("A task", repository.sortingByNameOrderByASC()[0].name)
        }
    }
}