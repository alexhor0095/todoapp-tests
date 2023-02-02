package bdd.steps

import data.Priority
import data.Task
import data.TasksRepositoryMemory
import io.cucumber.java8.En
import kotlin.test.assertEquals

class CompleteTaskSteps : En {
    init {
        val repository = TasksRepositoryMemory()
        Given("Add New task") {
            repository.addTask(Task(name = "Completed task", priority = Priority.MEDIUM))
        }
        When("Complete task") {
            repository.completeTask(1)
        }
        Then("Have new complete task") {
            val tasks = repository.getTasks(completed = true)
            assertEquals("Completed task", tasks[0].name)
        }
    }
}