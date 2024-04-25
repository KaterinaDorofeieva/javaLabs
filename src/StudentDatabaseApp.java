import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDatabaseApp {
    // URL адреса бази даних
    private static final String DB_URL = "jdbc:mysql://localhost/studentsdatabase";
    // Ім'я користувача бази даних
    private static final String USERNAME = "Kate";
    // Пароль для доступу до бази даних
    private static final String PASSWORD = "ketkatarina2002";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Завантажуємо драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Встановлюємо з'єднання з базою даних
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            // Якщо з'єднання успішно встановлено, виводимо повідомлення
            System.out.println("З'єднання з базою даних успiшно!");
            
            // Виводимо інформацію про студентів, які народилися у січні
            printStudentsBornInMonth(connection, 5); // 1 - січень
            
        } catch (SQLException | ClassNotFoundException e) {
            // Виводимо помилку, якщо вона виникла
            e.printStackTrace();
        } finally {
            // Закриваємо з'єднання
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Метод для виведення інформації про студентів, які народилися в певному місяці
    private static void printStudentsBornInMonth(Connection connection, int month) throws SQLException {
        // SQL запит для отримання даних про студентів, які народилися у вказаному місяці
        String sql = "SELECT * FROM students WHERE MONTH(birth_date) = ?";
        
        // Підготовка SQL запиту
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, month);
            
            // Виконання запиту і отримання результатів
            try (ResultSet resultSet = statement.executeQuery()) {
                // Виведення результатів
                System.out.println("Студенти, якi народилися у мiсяцi " + month + ":");
                while (resultSet.next()) {
                    String lastName = resultSet.getString("last_name");
                    String firstName = resultSet.getString("first_name");
                    String middleName = resultSet.getString("middle_name");
                    String dateOfBirth = resultSet.getString("birth_date");
                    String studentId = resultSet.getString("student_id");
                    String studentDatabaseId = resultSet.getString("id");
                    
                    System.out.println("Прізвище: " + lastName + ", Ім'я: " + firstName + ", По батькові: " + middleName
                            + ", Дата народження: " + dateOfBirth + ", Номер залікової книжки: " + studentId
                            + ", ID: " + studentDatabaseId);
                }
            }
        }
    }
}
