import java.util.List;

public class Requirement {
    private String category;
    private List<Course> courses;

    public Requirement(String category, List<Course> courses) {
        this.category = category;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getCategory() {
        return category;
    }
}
