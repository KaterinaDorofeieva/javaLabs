import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost/studentsdatabase";
    private static final String USERNAME = "Kate";
    private static final String PASSWORD = "ketkatarina2002";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            while (true) {
                System.out.println("Виберіть опцію:");
                System.out.println("1. Отримати всіх студентів");
                System.out.println("2. Отримати студентів за місяцем народження");
                System.out.println("3. Вихід");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        List<Student> allStudents = getAllStudents(connection);
                        printStudents(allStudents);
                        break;
                    case 2:
                        System.out.println("Введіть місяць (від 1 до 12):");
                        int month = scanner.nextInt();
                        List<Student> studentsByMonth = getStudentsByBirthMonth(connection, month);
                        printStudents(studentsByMonth);
                        break;
                    case 3:
                        System.out.println("Програму завершено");
                        return;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static List<Student> getAllStudents(Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getDate("Birth_Date"),
                        resultSet.getString("student_id")
                );
                students.add(student);
            }
        }
        return students;
    }

    private static List<Student> getStudentsByBirthMonth(Connection connection, int month) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE MONTH(Birth_Date) = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, month);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("middle_name"),
                            resultSet.getDate("Birth_Date"),
                            resultSet.getString("student_id")
                    );
                    students.add(student);
                }
            }
        }
        return students;
    }

    private static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Немає студентів для відображення.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
