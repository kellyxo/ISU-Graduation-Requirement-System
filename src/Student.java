
public class Student {
    private String name;
    private Plan plan;

    public Student(String name) {
        this.name = name;
        this.plan = new Plan();
    }

    public Plan getPlan() {
        return plan;
    }

    public String getName() {
        return name;
    }
}

