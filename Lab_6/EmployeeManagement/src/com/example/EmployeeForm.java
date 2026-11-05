package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Swing frontend for the Employee Management app (Experiment 6).
 * Provides a form to add an employee and a table to view all employees.
 */
public class EmployeeForm extends JFrame {

    private final EmployeeDAO dao = new EmployeeDAO();

    private final JTextField idField = new JTextField(10);
    private final JTextField nameField = new JTextField(15);
    private final JTextField deptField = new JTextField(15);
    private final JTextField salaryField = new JTextField(10);

    private final DefaultTableModel tableModel =
            new DefaultTableModel(new Object[]{"Employee ID", "Name", "Department", "Salary"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // table is read-only
                }
            };
    private final JTable table = new JTable(tableModel);

    public EmployeeForm() {
        super("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- Input form panel ---
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Employee"));
        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Department:"));
        formPanel.add(deptField);
        formPanel.add(new JLabel("Salary:"));
        formPanel.add(salaryField);

        JButton submitButton = new JButton("Submit");
        JButton viewAllButton = new JButton("View All Employees");
        submitButton.addActionListener(e -> onSubmit());
        viewAllButton.addActionListener(e -> onViewAll());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(viewAllButton);

        JPanel westPanel = new JPanel(new BorderLayout(5, 5));
        westPanel.add(formPanel, BorderLayout.NORTH);
        westPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(westPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        pack();
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            double salary = Double.parseDouble(salaryField.getText().trim());

            if (name.isEmpty() || dept.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Department are required.",
                        "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            dao.addEmployee(id, name, dept, salary);
            JOptionPane.showMessageDialog(this, "Employee added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
            onViewAll();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Employee ID must be an integer and Salary must be a number.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onViewAll() {
        try {
            List<EmployeeDAO.Employee> employees = dao.getAllEmployees();
            tableModel.setRowCount(0);
            for (EmployeeDAO.Employee emp : employees) {
                tableModel.addRow(new Object[]{emp.empId, emp.name, emp.department, emp.salary});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeForm().setVisible(true));
    }
}
