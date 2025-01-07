package sampleSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SqlInsertDeleteExample {

    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javaLab";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "2024";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Establish a database connection
            Class.forName("com.mysql.cj.jdbc.Driver"); // Dynamically load the MySQL driver
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // INSERT Operation
            String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            System.out.print("How many people do you want to add? : ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                insertStmt.setString(1, name);
                insertStmt.setString(2, email);
                int insertRows = insertStmt.executeUpdate();
                System.out.println(insertRows + " row(s) inserted.");
            }

            // DELETE Operation
            String deleteQuery = "DELETE FROM users WHERE name = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            System.out.print("Enter the name to delete: ");
            String deleteName = sc.nextLine();
            deleteStmt.setString(1, deleteName);
            int deleteRows = deleteStmt.executeUpdate();
            System.out.println(deleteRows + " row(s) deleted.");

            // SELECT Operation
            String selectQuery = "SELECT * FROM users";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            ResultSet rs = selectStmt.executeQuery();
            System.out.println("Current Users in the Database:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
