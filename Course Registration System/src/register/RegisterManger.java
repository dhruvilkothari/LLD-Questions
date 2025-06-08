package register;

import course.Course;
import student.Student;

public class RegisterManger {

    private static RegisterManger instance ;
    private RegisterManger() {
    }

    public static RegisterManger getInstance() {
        if(instance == null){
            instance = new RegisterManger();
        }
        return instance;
    }
    public void registerStudent(Student student, Course course) {

        synchronized (course){
            if(course.getCapacity() > 0){
                course.setCapacity(course.getCapacity() - 1);
                System.out.println(student.getName() + " registered for " + course.getName());
                student.getCourseList().add(course);
            }else{
                System.out.println("Course is full");
            }
        }
    }
    public void dropStudent(Student student, Course course) {
        synchronized (course){
            student.getCourseList().remove(course);
            course.setCapacity(course.getCapacity() + 1);
        }
    }
}
