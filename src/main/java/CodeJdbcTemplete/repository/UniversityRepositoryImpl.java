package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityRepositoryImpl implements UniversityRepository{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UniversityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public  int save(University university) {
        String sql = "INSERT INTO university (universityName, universityCity) VALUES (?, ?)";
        return jdbcTemplate.update(sql, university.getUniversityName(), university.getUniversityCity());
    }
}
