package in.hello.service;

import java.util.List;

import in.hello.model.Teacher;



import in.hello.dto.TeacherRequestDTO;

public interface ITeacherService {
    Teacher saveTeacher(TeacherRequestDTO dto);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    void deleteTeacher(Long id);
    Teacher updateTeacher(Long id, TeacherRequestDTO dto);

}
