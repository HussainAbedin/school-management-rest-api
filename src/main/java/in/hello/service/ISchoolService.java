package in.hello.service;

import java.util.List;

import in.hello.model.School;

public interface ISchoolService {
	 List<School> getAllSchools();
	 School getSchoolById(Long id);
	 School createSchool(School school);
	 School updateSchool(Long id, School school);
	 void deleteSchool(Long id);

}
