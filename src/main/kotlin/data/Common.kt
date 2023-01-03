package data

import java.time.LocalDate

enum class Priority {
    LOW,
    MEDIUM,
    HIGH
}

data class Task(val id: Int? = null, val name: String, var priority: Priority, var completed: Boolean = false, var endDate:LocalDate) {
    override fun toString(): String = ("$id. [${if (completed) "x" else " "}] $name : ${priority} $endDate ")
}

abstract class TasksRepository {
    abstract fun getTasks(completed: Boolean = true): List<Task>
    abstract fun addTask(task: Task): Int
    abstract fun deleteTask(id: Int)
    abstract fun completeTask(id: Int)
    abstract fun uncompleteTask(id: Int)
    abstract fun sortingByNameOrderByASC():List<Task>
    abstract fun sortingByDate():List<Task>
}
