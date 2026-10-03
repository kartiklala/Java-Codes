import java.awt.*;
import java.awt.event.*;

public class Question6 {
    public static void main(String[] args) {
        StudentRegistration form = new StudentRegistration();
        form.setVisible(true);
    }
}

class StudentRegistration extends Frame implements ActionListener {
    Label nameLabel, rollLabel, courseLabel;
    TextField nameField, rollField, courseField;
    Button submitButton;

    StudentRegistration() {
        setTitle("Student Registration");
        setSize(400, 250);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        Panel formPanel = new Panel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 15));

        nameLabel = new Label("Name:");
        nameField = new TextField(20);

        rollLabel = new Label("Roll No:");
        rollField = new TextField(20);

        courseLabel = new Label("Course:");
        courseField = new TextField(20);

        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(rollLabel);
        formPanel.add(rollField);

        formPanel.add(courseLabel);
        formPanel.add(courseField);

        submitButton = new Button("Submit");
        submitButton.addActionListener(this);

        add(formPanel);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String rollNo = rollField.getText();
        String course = courseField.getText();

        String message = "Student Registered Successfully!\n\n"
                + "Name: " + name + "\n"
                + "Roll No: " + rollNo + "\n"
                + "Course: " + course;

        Dialog dialog = new Dialog(this, "Registration Details", true);
        dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        dialog.setSize(320, 220);

        TextArea details = new TextArea(message, 7, 30);
        details.setEditable(false);

        Button okButton = new Button("OK");
        okButton.addActionListener(a -> dialog.dispose());

        dialog.add(details);
        dialog.add(okButton);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
