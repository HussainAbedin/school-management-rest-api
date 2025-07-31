package in.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hello.dao.ISchoolDao;
import in.hello.model.School;

@Service
public class SchoolServiceImpl implements ISchoolService {

    @Autowired
    private ISchoolDao schoolRepo;

    @Override
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepo.findById(id).orElse(null);
    }

    @Override
    public School createSchool(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public School updateSchool(Long id, School school) {
        Optional<School> existingSchool = schoolRepo.findById(id);
        if (existingSchool.isPresent()) {
            School s = existingSchool.get();
            s.setName(school.getName());
            s.setLocation(school.getLocation());
            return schoolRepo.save(s);
        }
        return null;
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepo.deleteById(id);
    }
}
