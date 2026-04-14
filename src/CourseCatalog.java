import java.util.Arrays;
import java.util.List;

public class CourseCatalog {

    public static List<Course> getAvailableCourses() {
        return Arrays.asList(
            new Course("CS101", "ExampleCourse1", 3),
            new Course("CS102", "ExampleCourse2", 3),
            new Course("MATH201", "ExampleCourse3", 4)
        );
    }
}
