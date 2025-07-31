import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGUI {
    StudentService service = new StudentService();

    public static void main(String[] args) {
        new StudentGUI().createGUI();
    }

    public void createGUI() {
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View All Students");
        JButton searchBtn = new JButton("Search Student");
        JButton deleteBtn = new JButton("Delete Student");
        JButton updateBtn = new JButton("Update Student");

        JTextArea output = new JTextArea(15, 40);
        output.setEditable(false);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(searchBtn);
        frame.add(deleteBtn);
        frame.add(updateBtn);
        frame.add(new JScrollPane(output));

        addBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
            String name = JOptionPane.showInputDialog("Enter Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
            String course = JOptionPane.showInputDialog("Enter Course:");

            service.addStudent(new Student(id, name, age, course));
            output.setText("✅ Student Added.");
        });

        viewBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Student s : service.getAllStudents()) {
                sb.append("ID: ").append(s.getId())
                        .append(", Name: ").append(s.getName())
                        .append(", Age: ").append(s.getAge())
                        .append(", Course: ").append(s.getCourse()).append("\n");
            }
            output.setText(sb.toString());
        });

        searchBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Search:"));
            Student s = service.findStudentById(id);
            if (s != null) {
                output.setText("ID: " + s.getId() + ", Name: " + s.getName() +
                        ", Age: " + s.getAge() + ", Course: " + s.getCourse());
            } else {
                output.setText("❌ Student Not Found.");
            }
        });

        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Delete:"));
            if (service.deleteStudent(id)) {
                output.setText("🗑️ Student Deleted.");
            } else {
                output.setText("❌ Student Not Found.");
            }
        });

        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update:"));
            String name = JOptionPane.showInputDialog("New Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("New Age:"));
            String course = JOptionPane.showInputDialog("New Course:");

            if (service.updateStudent(id, name, age, course)) {
                output.setText("✅ Student Updated.");
            } else {
                output.setText("❌ Student Not Found.");
            }
        });

        frame.setVisible(true);
    }
}
