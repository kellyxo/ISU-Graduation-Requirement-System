import java.util.ArrayList;

public class Plan {
    private ArrayList<Course> selectedCourses = new ArrayList<>();

    public void addCourse(Course course) {
        selectedCourses.add(course);
        System.out.println(course.getName() + " added to plan.");
    }

    public void viewPlan() {
        System.out.println("Current Plan:");
        for (Course c : selectedCourses) {
            System.out.println("- " + c);
        }
    }
}
