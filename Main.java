import model.*;
import service.CourseService;
import utils.FileManager;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseService service = new CourseService();
        User admin = new User("admin", "admin123", true);

        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!admin.getUsername().equals(user) || !admin.checkPassword(pass)) {
            System.out.println("❌ Invalid credentials.");
            return;
        }

        int choice;
        do {
            System.out.println("\n📘 Smart Course Planner - Admin Panel");
            System.out.println("1. Create Course");
            System.out.println("2. Add Module");
            System.out.println("3. Mark Module Complete");
            System.out.println("4. Show Course");
            System.out.println("5. Save and Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
    case 1 -> service.createCourse(sc);
    case 2 -> service.addModule(sc);
    case 3 -> service.markComplete(sc);
    case 4 -> service.showCourses();  // plural now
    case 5 -> FileManager.saveCourses(service.getCourses(), "course_data.txt");  // plural now
    default -> System.out.println("Invalid choice.");
}

        } while (choice != 5);
    }
}
