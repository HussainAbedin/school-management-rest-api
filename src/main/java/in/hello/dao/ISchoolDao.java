package in.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hello.model.School;

public interface ISchoolDao extends JpaRepository<School, Long> {

}
