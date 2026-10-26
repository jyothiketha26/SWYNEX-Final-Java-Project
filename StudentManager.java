import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());

            ps.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Could not add student: " + e.getMessage());
        }
    }

    public void viewStudents() {
        String sql = "SELECT id, name, age, course FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("--------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (SQLException e) {
            System.out.println("Could not view students: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        String sql = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (SQLException e) {
            System.out.println("Could not update student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (SQLException e) {
            System.out.println("Could not delete student: " + e.getMessage());
        }
    }
}