import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public ArrayList<Student> getAllStudents() {
        return studentList;
    }

    public Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student s = findStudentById(id);
        if (s != null) {
            studentList.remove(s);
            return true;
        }
        return false;
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        Student s = findStudentById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            return true;
        }
        return false;
    }
}
