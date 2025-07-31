package in.hello.restcontroller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hello.dto.SubjectRequestDTO;
import in.hello.dto.SubjectResponseDTO;
import in.hello.service.ISubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @PostMapping
    public ResponseEntity<String> saveSubject(@RequestBody SubjectRequestDTO subjectDto) {
        subjectService.saveSubject(subjectDto);
        return ResponseEntity.ok("Record inserted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody SubjectRequestDTO subjectDto) {
        boolean isUpdated = subjectService.updateSubject(id, subjectDto);
        if (isUpdated) {
            return ResponseEntity.ok("Record updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not available");
        }
    }

    
    @GetMapping
    public List<SubjectResponseDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public SubjectResponseDTO getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id) {
        String message = subjectService.deleteSubject(id);
        return ResponseEntity.ok(message);
    }

}
