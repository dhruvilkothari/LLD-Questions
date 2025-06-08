import course.Course;
import course.MathCourse;
import register.RegisterManger;
import student.Student;

public class Main {
    public static void main(String[] args) {

        Student s1= new Student("John", "123");
        Student s2= new Student("Jane", "456");
        Student s3= new Student("Jack", "789");

        Course math = new MathCourse("Math123", 1);
        Course science = new MathCourse("Science123", 2);
        Course english = new MathCourse("English123", 2);

        RegisterManger  registerManger = RegisterManger.getInstance();

        Thread t1 = new Thread(() -> {
            registerManger.registerStudent(s1, math);
        });
        Thread t2 = new Thread(() -> {
            registerManger.registerStudent(s2, math);
        });
        t1.start();
        t2.start();




    }
}