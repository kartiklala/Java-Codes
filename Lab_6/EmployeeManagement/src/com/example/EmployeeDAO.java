package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC logic for the Employee Management app (Experiment 6).
 * Handles connecting to MySQL, inserting employees, and reading them back.
 */
public class EmployeeDAO {

    // ---- Change these to match your MySQL installation ----
    private static final String URL =
            "jdbc:mysql://localhost:3306/company_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "molly123";

    // Simple data holder so the Swing form can display rows cleanly.
    public static class Employee {
        public final int empId;
        public final String name;
        public final String department;
        public final double salary;

        public Employee(int empId, String name, String department, double salary) {
            this.empId = empId;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    private static Connection getConnection() throws SQLException {
        // Driver is auto-registered by JDBC 4+, but loading it explicitly
        // makes the requirement obvious and helps older setups.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found on classpath", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /** Insert a new employee. Returns true on success. */
    public boolean addEmployee(int empId, String name, String department, double salary)
            throws SQLException {
        String sql = "INSERT INTO employees (emp_id, name, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);
            return ps.executeUpdate() == 1;
        }
    }

    /** Retrieve all employee records. */
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT emp_id, name, department, salary FROM employees ORDER BY emp_id";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")));
            }
        }
        return list;
    }
}
