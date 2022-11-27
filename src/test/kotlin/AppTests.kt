import data.Priority
import data.Task
import data.TasksRepositoryMemory
import io.qameta.allure.kotlin.Description
import io.qameta.allure.kotlin.junit4.AllureRunner
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AllureRunner::class)
class AppTests {

    private val repository = TasksRepositoryMemory()

    @Test()
    @Description("Тестирование добавление тасок")
    fun addTaskTest() {
        repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM))
        repository.addTask(Task(name = "Test task 2", priority = Priority.HIGH))
        val task = repository.getTasks()
        assertEquals("1. [ ] Test task : MEDIUM", task[0].toString())
        assertEquals("2. [ ] Test task 2 : HIGH", task[1].toString())
    }

    @Test
    @Description("Тестирование фильтра по закрытым таскам")
    fun closeTaskTest() {
        repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM))
        repository.completeTask(1)
        val completedTasks = repository.getTasks(completed = true)
        assertEquals("1. [x] Test task : MEDIUM", completedTasks[0].toString())
    }

    @Test
    fun nameFilterTest() {
        //ToDo Реализвать тесты после реализации соотвествующего функционала
    }
}