package service;

import model.Course;
import model.Module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    public void createCourse(Scanner sc) {
        System.out.print("Course Name: ");
        String name = sc.nextLine();
        System.out.print("Course Code: ");
        String code = sc.nextLine();
        Course newCourse = new Course(name, code);
        courses.add(newCourse);
        System.out.println("Course created successfully.");
    }

    private Course findCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    public void addModule(Scanner sc) {
        System.out.print("Enter Course Code to add module: ");
        String courseCode = sc.nextLine();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Module Name: ");
        String name = sc.nextLine();
        System.out.print("Deadline (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        course.addModule(new Module(name, date));
        System.out.println("Module added successfully.");
    }

    public void markComplete(Scanner sc) {
        System.out.print("Enter Course Code: ");
        String courseCode = sc.nextLine();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter module name to mark as complete: ");
        String moduleName = sc.nextLine();
        course.markModuleComplete(moduleName);
    }

    public void showCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses created yet.");
            return;
        }
        for (Course c : courses) {
            c.display();
            System.out.println();
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
