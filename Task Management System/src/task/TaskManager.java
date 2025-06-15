package task;

import user.User;

import java.security.Key;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class TaskManager {
    private static TaskManager instance;
    private  TaskSearch taskSearch;

    private TaskManager() {
        taskSearch = TaskSearch.getInstance();
    }
    public static TaskManager getInstance() {
        synchronized (TaskManager.class){
            if (instance == null) {
                instance = new TaskManager();
            }
            return instance;
        }
    }

    public Task createTask(String name, String description, TaskStatus status, User user, TaskPriority priority, LocalDate startDate, LocalDate endDate){
        Task task = new Task(name, description, status, user, priority, startDate, endDate);
        taskSearch.addTask(task);
        return task;
    }
    public Task searchTasks(String id) {
        return taskSearch.searchTasks(id);
    }
    public void updateTask(HashMap<Object,Object> updateFields, Task task){
        synchronized (task){
            for (Object key : updateFields.keySet()){
                switch (key.toString()){
                    case "name":
                        task.setName((String) updateFields.get(key));
                        break;
                    case "description":
                        task.setDescription((String) updateFields.get(key));
                        break;
                    case "status":
                        task.setStatus((TaskStatus) updateFields.get(key));
                        break;
                    case "user":
                        task.setUser((User) updateFields.get(key));
                        break;
                    case "priority":
                        task.setPriority((TaskPriority) updateFields.get(key));
                        break;
                    case "endDate":
                        task.setEndDate((LocalDate) updateFields.get(key));
                        break;
                }
            }

        }

    }
    public void deleteTask(String id){
        Task task = taskSearch.searchTasks(id);
        if (task != null){
            taskSearch.getAllTasks().remove(task);
        }
    }


    public boolean assignTaskToAnother(Task task, User user) {
        if (task.getUser() != user) {
            task.setUser(user);
            return true;
        }
        return false;
    }
}
