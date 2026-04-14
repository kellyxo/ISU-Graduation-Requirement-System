import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alex");

        System.out.println("Welcome " + student.getName());

        List<Course> courses = CourseCatalog.getAvailableCourses();

        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a course index: ");
        int choice = scanner.nextInt();

        student.getPlan().addCourse(courses.get(choice));
        student.getPlan().viewPlan();
    }
}
