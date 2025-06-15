import task.Task;
import task.TaskManager;
import task.TaskPriority;
import task.TaskStatus;
import user.User;

import java.time.LocalDate;
import java.util.HashMap;

public class TaskManagerImpl {
    private static TaskManagerImpl instance;
    private HashMap<String, User> users;
    private TaskManager taskManager;

    private TaskManagerImpl() {
        users = new HashMap<>();
        taskManager = TaskManager.getInstance();
    }
    public static TaskManagerImpl getInstance() {
        synchronized (TaskManagerImpl.class){
            if (instance == null) {
                instance = new TaskManagerImpl();
            }
            return instance;
        }
    }
    public User createUser(String name){
        User  user = new User(name);
        users.put(user.getId(), user);
        return user;
    }
    public User getUser(String id){
        return users.get(id);
    }
    public void deleteUser(String id){
        users.remove(id);
    }
    public Task createTask(String name, String description, TaskStatus status, User user, TaskPriority priority, LocalDate startDate, LocalDate endDate ){
        Task task =taskManager.createTask(name, description, status, user, priority, startDate, endDate);
        return task;
    }
    public Task getTask(String id){
        return taskManager.searchTasks(id);
    }
    public boolean assignTaskToAnother(Task task, User user){
        synchronized (task){
            return taskManager.assignTaskToAnother(task, user);
        }
    }

}
