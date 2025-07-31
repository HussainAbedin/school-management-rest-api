package in.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hello.dao.IClassRoomDao;
import in.hello.model.Classroom;

@Service
public class ClassRoomServiceImpl implements IClassRoomService {

    @Autowired
    private IClassRoomDao classroomDao;

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        return classroomDao.save(classroom);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomDao.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomDao.findById(id).orElse(null);
    }

   
    @Override
    public Classroom updateClassroom(Long id, Classroom classroom) {
        Optional<Classroom> existing = classroomDao.findById(id);
        if (existing.isPresent()) {
            Classroom updated = existing.get();
            updated.setName(classroom.getName());
            updated.setStudents(classroom.getStudents());
            updated.setSubjects(classroom.getSubjects());
            return classroomDao.save(updated);
        }
        return null;
    }

    @Override
    public boolean deleteClassroom(Long id) {
        Classroom classroom = getClassroomById(id);
        if (classroom != null) {
            classroomDao.delete(classroom);
            return true;
        } else {
            return false;
        }
    }


	
}