# 🎓 Student Management System (Java + GUI)

A comprehensive **Student Management System** built using **Java**, following modular design patterns with **GUI support (Swing)** and organized into **service and model layers**. This project helps students understand layered architecture, GUI development, and file-based data persistence.

---

## 📁 Project Structure
StudentManagementSystem/
├── .vscode/
│ └── launch.json # VS Code run configuration
├── src/
│ ├── Student.java # Data model class
│ ├── StudentService.java # Business logic (Add, Update, Delete, Save)
│ ├── StudentManagementSystem.java # GUI and main application
│ └── StudentGUI.java # Swing GUI code
├── students.txt # Data file for persistence
├── README.md
└── LICENSE

---

## 🧰 Technologies Used

- Java (JDK 8+)
- Swing (for GUI)
- File I/O for data storage
- Visual Studio Code (with launch.json for easy run)

---

## 🎮 Features

- ➕ Add New Student
- 📋 View All Students
- 🔍 Search by ID
- 📝 Update Student Details
- ❌ Delete Student Record
- 💾 File-based storage (`students.txt`)
- 🖥️ GUI built using Java Swing
- 🧠 Clean architecture with separation of concerns

---

## 🚀 How to Run (VS Code or Terminal)

### 💻 Using VS Code:
1. Open the folder in VS Code.
2. Open `StudentManagementSystem.java`.
3. Click **Run > Run Without Debugging** or use the existing `launch.json`.

### 🛠️ Using Command Line:
```bash
javac src/*.java
java -cp src StudentManagementSystem

