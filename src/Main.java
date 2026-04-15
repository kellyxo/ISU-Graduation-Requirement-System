import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Graduation Planner System ===");
        System.out.println("1. Student Login");
        System.out.println("2. Admin Login");
        System.out.println("3. Advisor Login");
        System.out.print("Select option: ");

        int roleChoice = scanner.nextInt();

        if (roleChoice == 1) {
            Student student = new Student("Alex");
            studentMenu(student, scanner);
        } else {
            System.out.println("Feature not implemented yet.");
        }
    }

    public static void studentMenu(Student student, Scanner scanner) {

        System.out.println("\n=== Student Menu ===");
        System.out.println("1. View Graduation Requirements");
        System.out.println("2. View Available Courses");
        System.out.println("3. Generate Semester Course Plan");
        System.out.print("Select option: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            viewRequirements(student, scanner);
        } else {
            System.out.println("Feature not implemented yet.");
        }
    }

    public static void viewRequirements(Student student, Scanner scanner) {

        List<Requirement> requirements = RequirementCatalog.getRequirements();

        System.out.println("\n=== Graduation Requirements ===");

        for (int i = 0; i < requirements.size(); i++) {
            System.out.println((i + 1) + ". " + requirements.get(i).getTitle());
        }

        System.out.print("Select a requirement: ");
        int reqChoice = scanner.nextInt() - 1;

        Requirement selected = requirements.get(reqChoice);

        System.out.println("\nCourses for " + selected.getTitle() + ":");

        List<Course> courses = selected.getCourses();

        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i));
        }

        System.out.print("Select a course to add: ");
        int courseChoice = scanner.nextInt();

        student.getPlan().addCourse(courses.get(courseChoice));
        student.getPlan().viewPlan();
    }
}