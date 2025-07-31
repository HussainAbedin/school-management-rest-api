package in.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hello.model.Classroom;

public interface IClassRoomDao extends JpaRepository<Classroom, Long> {

}
