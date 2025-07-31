package in.hello.service;

import in.hello.model.Classroom;
import java.util.List;

public interface IClassRoomService {

    Classroom saveClassroom(Classroom classroom);

    List<Classroom> getAllClassrooms();

    Classroom getClassroomById(Long id);

    Classroom updateClassroom(Long id, Classroom classroom);

    boolean deleteClassroom(Long id);
}
