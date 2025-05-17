package utils;

import model.Course;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

    public static void saveCourses(List<Course> courses, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Course course : courses) {
                writer.write(course.toFileFormat());
                writer.write("\n");
            }
            System.out.println("Courses saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    // You can keep your existing saveCourse(Course course, String filename) if you want
}
