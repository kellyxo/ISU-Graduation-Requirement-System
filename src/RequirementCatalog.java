import java.util.Arrays;
import java.util.List;

public class RequirementCatalog {

    public static List<Requirement> getRequirements() {
        return Arrays.asList(
            new Requirement("World Language", Arrays.asList(
                new Course("SPAN101", "Intro to Spanish", 3),
                new Course("FREN101", "Intro to French", 3)
            )),
            new Requirement("Math", Arrays.asList(
                new Course("MATH201", "Calculus I", 4),
                new Course("STAT101", "Statistics", 3)
            )),
            new Requirement("Humanities", Arrays.asList(
                new Course("HIST101", "World History", 3),
                new Course("PHIL101", "Intro to Philosophy", 3)
            ))
        );
    }
}