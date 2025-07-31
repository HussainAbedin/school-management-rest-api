package in.hello.restcontroller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.hello.model.Student;
import in.hello.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final IStudentService stdService;

    public StudentController(IStudentService studentService) {
        this.stdService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        Student savedStudent = stdService.saveStudent(student);
        return ResponseEntity.ok().body("{\"message\":\"Student has been successfully registered.\"}");
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return stdService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return stdService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = stdService.updateStudent(id, student);
        if (updatedStudent != null)
            return ResponseEntity.ok().body("{\"message\":\"Student updated successfully.\"}");
        else
            return ResponseEntity.status(404).body("{\"message\":\"Student not found.\"}");
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        stdService.deleteStudent(id);
        return ResponseEntity.ok("Student with ID " + id + " has been deleted successfully.");
    }
}
