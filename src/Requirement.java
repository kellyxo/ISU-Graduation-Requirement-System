import java.util.List;

public class Requirement {
    private String title;
    private List<Course> courses;

    public Requirement(String title, List<Course> courses) {
        this.title = title;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getTitle() {
        return title;
    }
}