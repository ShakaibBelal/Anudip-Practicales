import java.sql.*;
import java.util.Scanner;

public class EMPloyeeManagement {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/JDBC";
    private static final String USER = "root";
    private static final String PASSWORD = "Shakaib@2005";

    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");

            int choice;
            do {
                System.out.println("1. Create Employee Table");
                System.out.println("2. Insert Employee");
                System.out.println("3. Retrieve Employees");
                System.out.println("4. Update Employee Email");
                System.out.println("5. Delete Employee");
                System.out.println("6. Search Employee by ID");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createTable(connection);
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        insertData(connection, id, name, email);
                        break;
                    case 3:
                        retrieveData(connection);
                        break;
                    case 4:
                        System.out.print("Enter ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Email: ");
                        String newEmail = scanner.nextLine();
                        updateData(connection, updateId, newEmail);
                        break;
                    case 5:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = scanner.nextInt();
                        deleteData(connection, deleteId);
                        break;
                    case 6:
                        System.out.print("Enter ID to search: ");
                        int searchId = scanner.nextInt();
                        searchEmployeeById(connection, searchId);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    public static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employee (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Employee table created (if not exists).");
        }
    }

    public static void insertData(Connection connection, int id, String name, String email) throws SQLException {
        String sql = "INSERT INTO employee (id, name, email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("Employee inserted.");
        }
    }

    public static void retrieveData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM employee";
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID\tName\t\tEmail");
            while (rs.next()) {
                System.out.printf("%d\t%s\t\t%s\n", rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        }
    }

    public static void updateData(Connection connection, int id, String newEmail) throws SQLException {
        String sql = "UPDATE employee SET email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee email updated.");
            } else {
                System.out.println("Employee not found.");
            }
        }
    }

    public static void deleteData(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Employee not found.");
            }
        }
    }

    public static void searchEmployeeById(Connection connection, int id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Email: " + rs.getString("email"));
                } else {
                    System.out.println("Employee not found.");
                }
            }
        }
    }
}