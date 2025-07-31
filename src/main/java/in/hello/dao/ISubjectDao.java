package in.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hello.model.Subject;

public interface ISubjectDao extends JpaRepository<Subject,Long> {

}
