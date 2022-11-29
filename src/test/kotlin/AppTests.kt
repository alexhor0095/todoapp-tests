import data.Priority
import data.Task
import data.TasksRepositoryMemory
import io.qameta.allure.Description
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class AppTests {

    private val repository = TasksRepositoryMemory()

    @Test()
    @DisplayName("Тестирование добавление тасок")
    @Description("Тестирование добавление тасок")
    fun addTaskTest() {
        repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM))
        repository.addTask(Task(name = "Test task 2", priority = Priority.HIGH))
        val task = repository.getTasks()
        assertEquals("1. [ ] Test task : MEDIUM", task[0].toString())
        assertEquals("2. [ ] Test task 2 : HIGH", task[1].toString())
    }

    @Test
    @DisplayName("Тестирование фильтра по закрытым таскам")
    @Description("Тестирование фильтра по закрытым таскам")
    fun closeTaskTest() {
        repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM))
        repository.completeTask(1)
        val completedTasks = repository.getTasks(completed = true)
        assertEquals("1. [x] Test task : MEDIUM", completedTasks[0].toString())
    }

    @Test
    @DisplayName("Eще не реализовано")
    fun nameFilterTest() {
        //ToDo Реализвать тесты после реализации соотвествующего функционала
    }
}