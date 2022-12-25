import data.Priority
import data.Task
import data.TasksRepositoryMemory
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class AppTests {

    private val repository = TasksRepositoryMemory()

    @Test
    @DisplayName("Тестирование добавления тасок")
    fun addTaskTest() {
        repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM))
        repository.addTask(Task(name = "Test task 2", priority = Priority.HIGH))
        val task = repository.getTasks()
        assertEquals("Test task", task[0].name)
        assertEquals(Priority.MEDIUM, task[0].priority)
    }

    @Test
    @DisplayName("Тестирование фильтра по закрытым таскам")
    fun closeTaskTest() {
        repository.addTask(Task(name = "Test task", priority = Priority.MEDIUM))
        repository.completeTask(1)
        val completedTasks = repository.getTasks(completed = true)
        assertEquals("Test task", completedTasks[0].name)
    }

    @Test
    @DisplayName("Сортировка по имени")
    fun nameFilterTest() {
        repository.addTask(Task(name = "B task", priority = Priority.MEDIUM))
        repository.addTask(Task(name = "A task", priority = Priority.HIGH))
        assertEquals("A task", repository.sortingByNameOrderByASC()[0].name)
    }

    @Test
    @DisplayName("Сортировка по дате")
    fun dateFilterTest() {
        repository.addTask(Task(name = "B task", priority = Priority.MEDIUM))
        repository.addTask(Task(name = "A task", priority = Priority.HIGH))
        assertEquals("A task", repository.sortingByDate()[0].name)
    }
}