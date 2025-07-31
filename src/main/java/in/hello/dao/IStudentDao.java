package in.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hello.model.Student;

public interface IStudentDao extends JpaRepository<Student,Long>{

}
