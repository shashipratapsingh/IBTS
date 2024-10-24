package CodeJdbcTemplete.service;

import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.repository.UniversityRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    public void saveUniversity(University university) {

        universityRepository.save(university);
    }

    public University getUniversityById(int id) {
        return universityRepository.findById(id);
    }
    public University findByEmail(String universityEmail) {
        return universityRepository.findByEmail(universityEmail);
    }

    public University getUniversityByEmailOnly(String universityEmail) {
        try {
            return universityRepository.findByEmailOnly(universityEmail);
        } catch (EmptyResultDataAccessException e) {
            // Return null if no result is found, indicating email is available for use
            return null;
        }
    }

}
