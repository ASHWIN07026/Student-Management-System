import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student Info");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option! Try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("✅ Student added successfully!");
    }

    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("⚠️ No student records found.");
            return;
        }
        for (Student s : studentList) {
            s.displayStudent();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.displayStudent();
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                System.out.println("🗑️ Student deleted successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter New Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter New Course: ");
                s.setCourse(sc.nextLine());
                System.out.println("✅ Student updated successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }
}
