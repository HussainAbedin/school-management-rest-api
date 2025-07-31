package in.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.hello.dao.ISchoolDao;
import in.hello.dao.ITeacherDao;
import in.hello.dto.TeacherRequestDTO;
import in.hello.model.School;
import in.hello.model.Teacher;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherDao teacherRepo;
    private final ISchoolDao schoolRepo;

    public TeacherServiceImpl(ITeacherDao teacherRepository, ISchoolDao schoolRepository) {
        this.teacherRepo = teacherRepository;
        this.schoolRepo = schoolRepository;
    }

    @Override
    public Teacher saveTeacher(TeacherRequestDTO dto) {
        School school = schoolRepo.findById(dto.getSchoolId())
            .orElseThrow(() -> new RuntimeException("School not found with id: " + dto.getSchoolId()));

        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setSchool(school);

        return teacherRepo.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }
    
    @Override
    public Teacher updateTeacher(Long id, TeacherRequestDTO dto) {
        Teacher teacher = teacherRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        School school = schoolRepo.findById(dto.getSchoolId())
            .orElseThrow(() -> new RuntimeException("School not found with id: " + dto.getSchoolId()));

        teacher.setName(dto.getName());
        teacher.setSchool(school);

        return teacherRepo.save(teacher);
    }

}
