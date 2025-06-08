package course;

import java.util.ArrayList;
import java.util.List;

public class CourseSearch {

    List<Course> courses;
    public CourseSearch() {
        this.courses = new ArrayList<>();
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    public Course searchCourse(String name) {

        return courses.stream().filter(course -> course.getName().equals(name)).findFirst().orElse(null);
    }

}
