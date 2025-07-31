package in.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hello.model.Teacher;

public interface ITeacherDao extends JpaRepository<Teacher, Long>{

}
