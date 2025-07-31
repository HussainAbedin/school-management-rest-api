package in.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.hello.dao.ISubjectDao;
import in.hello.dao.ITeacherDao;
import in.hello.dto.SubjectRequestDTO;
import in.hello.dto.SubjectResponseDTO;
import in.hello.model.Subject;
import in.hello.model.Teacher;

@Service
public class SubjectServiceImpl implements ISubjectService {

    private final ISubjectDao subjectRepo;
    private final ITeacherDao teacherRepo;

    public SubjectServiceImpl(ISubjectDao subjectRepo, ITeacherDao teacherRepo) {
        this.subjectRepo = subjectRepo;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Subject saveSubject(SubjectRequestDTO dto) {
        Teacher teacher = teacherRepo.findById(dto.getTeacherId()).orElse(null);
        if (teacher == null) {
            throw new IllegalArgumentException("Invalid teacher ID: " + dto.getTeacherId());
        }

        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setTeacher(teacher);

        return subjectRepo.save(subject);
    }

    @Override
    public List<SubjectResponseDTO> getAllSubjects() {
        List<Subject> subjects = subjectRepo.findAll();

        return subjects.stream()
            .map(s -> new SubjectResponseDTO(
                s.getId(),
                s.getName(),
                s.getTeacher().getName()
            ))
            .toList();
    }

    @Override
    public SubjectResponseDTO getSubjectById(Long id) {
        Subject s = subjectRepo.findById(id).orElse(null);
        if (s == null) return null;

        return new SubjectResponseDTO(
            s.getId(),
            s.getName(),
            s.getTeacher().getName()
        );
    }
    


    @Override
    public String deleteSubject(Long id) {
        Subject subject = subjectRepo.findById(id).orElse(null);
        if (subject == null) {
            return "Record not available";
        } else {
            subjectRepo.deleteById(id);
            return "Record deleted successfully...";
        }
    }


    @Override
    public boolean updateSubject(Long id, SubjectRequestDTO dto) {
        Subject subject = subjectRepo.findById(id).orElse(null);
        if (subject == null) {
            return false;
        }

        Teacher teacher = teacherRepo.findById(dto.getTeacherId()).orElse(null);
        if (teacher == null) {
            throw new IllegalArgumentException("Invalid teacher ID: " + dto.getTeacherId());
        }

        subject.setName(dto.getName());
        subject.setTeacher(teacher);
        subjectRepo.save(subject);
        return true;
    }
}
