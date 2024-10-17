package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityRepositoryImpl implements UniversityRepository{


    private final JdbcTemplate jdbcTemplate;

    public UniversityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(University university) {
        String sql = Constant.SAVE_UNIVERCITY;
        return jdbcTemplate.update(sql, university.getUniversityName(), university.getUniversityCity(),university.getUniversityAddress()
        ,university.getUniversityContact(),university.getUniversityEmail(),university.getUniversityZipCode(),university.getRemark(),university.getCreateBy()
                ,university.getUpdateBy()
        );
    }
}
