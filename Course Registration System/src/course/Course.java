package course;

import java.util.UUID;

public abstract class Course {
    private final String id;
    private final String name;
    private final String code;
    private  int capacity;

    public Course(String name, String code, int capacity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
        this.capacity = capacity;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
