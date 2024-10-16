package CodeJdbcTemplete.service;

import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {
    @Autowired
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void saveUniversity(University university) {
        universityRepository.save(university);
    }
}
