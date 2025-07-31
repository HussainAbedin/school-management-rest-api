package in.hello.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hello.model.Classroom;
import in.hello.service.ClassRoomServiceImpl;

@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomServiceImpl classroomService;

    @PostMapping
    public Map<String, String> createClassroom(@RequestBody Classroom classroom) {
        classroomService.saveClassroom(classroom);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Classroom record inserted successfully!");
        return response;
    }

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    @PutMapping("/{id}")
    public Map<String, String> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
        Map<String, String> response = new HashMap<>();
        Classroom updatedClassroom = classroomService.updateClassroom(id, classroom);

        if (updatedClassroom != null) {
            response.put("message", "Record updated successfully!");
        } else {
            response.put("message", "Classroom ID not found.");
        }

        return response;
    }

  
    
    @DeleteMapping("/{id}")
    public Map<String, String> deleteClassroom(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        boolean deleted = classroomService.deleteClassroom(id);

        if (deleted) {
            response.put("message", "Record deleted successfully!");
        } else {
            response.put("message", "Classroom ID not found.");
        }

        return response;
    }

}
