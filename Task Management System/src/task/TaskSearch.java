package task;

import java.util.ArrayList;
import java.util.List;

public class TaskSearch {
    private static TaskSearch instance;
    private List<Task> tasks;

    private TaskSearch() {
        this.tasks = new ArrayList<>();
    }
    public static TaskSearch getInstance() {
        synchronized (TaskSearch.class){
            if (instance == null) {
                instance = new TaskSearch();
            }
            return instance;
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public Task searchTasks(String id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}
