package in.hello.service;

import java.util.List;
import in.hello.model.Student;

public interface IStudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Long id, Student student);
}
