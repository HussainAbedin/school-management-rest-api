package in.hello.service;

import java.util.List;

import in.hello.dto.SubjectRequestDTO;
import in.hello.dto.SubjectResponseDTO;
import in.hello.model.Subject;

public interface ISubjectService {
    Subject saveSubject(SubjectRequestDTO subjectDto);
    List<SubjectResponseDTO> getAllSubjects();
    SubjectResponseDTO getSubjectById(Long id);
    boolean updateSubject(Long id, SubjectRequestDTO dto);
    String deleteSubject(Long id);

}
