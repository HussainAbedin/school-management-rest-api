package in.hello.restcontroller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import in.hello.dto.TeacherRequestDTO;
import in.hello.model.School;
import in.hello.model.Teacher;
import in.hello.service.ITeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

  
    @PostMapping
    public ResponseEntity<Map<String, String>> createTeacher(@RequestBody TeacherRequestDTO dto) {
        teacherService.saveTeacher(dto);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Teacher created successfully.");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Teacher deleted successfully.");
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTeacher(
            @PathVariable Long id,
            @RequestBody TeacherRequestDTO dto) {
        
        Teacher existing = teacherService.getTeacherById(id);
        existing.setName(dto.getName());

        // Only update school if changed
        if (!existing.getSchool().getId().equals(dto.getSchoolId())) {
            School school = new School();
            school.setId(dto.getSchoolId());
            existing.setSchool(school);
        }

        teacherService.saveTeacher(dto); // You may want to refactor for update separately

        Map<String, String> response = new HashMap<>();
        response.put("message", "Teacher updated successfully.");
        return ResponseEntity.ok(response);
    }


}