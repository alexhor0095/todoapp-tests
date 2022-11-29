package bdd.steps

import data.Priority
import data.Task

import data.TasksRepositoryMemory
import io.cucumber.java.En
import java.time.LocalDate

import kotlin.test.assertEquals

class AddNewTaskSteps: En {
    init {
        lateinit var repository: TasksRepositoryMemory
        Given("Task repository"){
            repository = TasksRepositoryMemory()
        }
        When("Add new task") {
            repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM, endDate = LocalDate.of(2023, 1, 1)))
        }
        Then("We have new task"){
            val tasks = repository.getTasks()
            assertEquals("Test task", tasks[0].name)
        }
    }
}