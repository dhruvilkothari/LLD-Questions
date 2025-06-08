package student;

import course.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private final String id;
    private final String name;
    private final String rollNumber;
    private List<Course> courseList;


    public Student(String name, String rollNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.rollNumber = rollNumber;
        this.courseList = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public List<Course> getCourseList() {
        return courseList;
    }
    public void addCourse(Course course) {
        courseList.add(course);
    }



}
