import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
	public static String DBFile = "gradDatabase.txt";
    public static void main(String[] args) throws IOException {

    	CheckDB();
    	DebugDB();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Graduation Planner System ===");
        System.out.println("1. Student Login");
        System.out.println("2. Admin Login");
        System.out.println("3. Advisor Login");
        System.out.print("Select option: ");

        int roleChoice = scanner.nextInt();

        if (roleChoice == 1) {
            studentLogin(scanner);
        } else {
            System.out.println("Feature not implemented yet.");
        }
    }
    private static void CheckDB() 
    {
    	try {
            File myObj = new File(DBFile);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void DebugDB() throws IOException 
    {
    	List<String> lines = Files.readAllLines(Paths.get(DBFile));
        for(int i = 0; i<lines.size(); i++) 
        {
        	String[] auth = lines.get(i).split(" ");
        	System.out.println(lines.get(i));
        }
    }
    public static void studentLogin(Scanner scanner) throws IOException
    {
    	
        System.out.println("\n=== Student Login Menu ===");
        System.out.println("1. Login as existing student");
        System.out.println("2. Create new student account");
        System.out.print("Select option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            loginStudent(scanner);
        } else {
            createStudent(scanner);
            }
    }
    public static void loginStudent(Scanner scanner)  throws IOException
    {
    	String username = null;
        boolean found = false;
    	while (!found) 
    	{
    		scanner.nextLine();
	        System.out.println("\n=== Student Login ===");
	        System.out.println("Enter Username:");
	        username = scanner.nextLine();
	        System.out.println("\n=== Student Login ===");
	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();
	        
	        //Check txt file database for student
	        List<String> lines = Files.readAllLines(Paths.get(DBFile));
	        for(int i = 0; i<lines.size(); i++) 
	        {
	        	String[] auth = lines.get(i).split(" ");
	        	if (auth.length < 2) continue;
	        	if (auth[0].equals(username) && auth[1].equals(password)) 
	        	{
	        		found=true;
	        		break;
	        	}
	        }
    	}
        viewRequirements(new Student(username), scanner);
        

    }
    public static void createStudent(Scanner scanner) throws IOException
    {
        scanner.nextLine();
    	System.out.println("\n=== Create Student Account ===");
        System.out.println("Enter new Username:");
        String username = scanner.nextLine();
        System.out.println("\n=== Create Student Account ===");
        System.out.println("Enter new Password:");
        String password = scanner.nextLine();

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DBFile))) {
            writer.write(username + " " + password + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        viewRequirements(new Student(username), scanner);
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