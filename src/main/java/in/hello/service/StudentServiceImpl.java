package in.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hello.dao.IClassRoomDao;
import in.hello.dao.ISchoolDao;
import in.hello.dao.IStudentDao;
import in.hello.model.Classroom;
import in.hello.model.School;
import in.hello.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentRepo;
    @Autowired
    private ISchoolDao schoolRepo;

    @Autowired
    private IClassRoomDao classRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudentOpt = studentRepo.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();

            Optional<School> schoolOpt = schoolRepo.findById(student.getSchool().getId());
            Optional<Classroom> classOpt = classRepo.findById(student.getClassroom().getId());

            if (schoolOpt.isPresent() && classOpt.isPresent()) {
                existingStudent.setName(student.getName());
                existingStudent.setSchool(schoolOpt.get());
                existingStudent.setClassroom(classOpt.get());

                return studentRepo.save(existingStudent);
            } else {
                throw new IllegalArgumentException("Invalid school or classroom ID");
            }
        }
        return null;
    }

}
