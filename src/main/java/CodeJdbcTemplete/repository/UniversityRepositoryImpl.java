package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UniversityRepositoryImpl implements UniversityRepository{


    private final JdbcTemplate jdbcTemplate;

    public UniversityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(University university) {
        String sql = Constant.SAVE_UNIVERCITY;
        jdbcTemplate.update(sql,
                university.getUniversityName(),
                university.getUniversityCity(),
                university.getUniversityAddress(),
                university.getUniversityContact(),
                university.getUniversityEmail(),
                university.getUniversityZipCode(),
                university.getRemark(),
                university.getCreateBy(),
                university.getUpdateBy()
        );
    }

    @Override
    public University findById(int id) {
        try {
            return jdbcTemplate.queryForObject(Constant.GET_UNIVERCITY_BY_ID,new Object[]{id},new UniversityRowMapper());
        }catch (Exception e) {
            throw new GlobleExceptionHandle("University not found with ID: " + id, 404);
        }
    }

    private static class UniversityRowMapper implements RowMapper<University> {
        @Override
        public University mapRow(ResultSet rs, int rowNum) throws SQLException {
            return University.builder()
                    .id(rs.getLong("id"))
                    .universityName(rs.getString("universityName"))
                    .universityCity(rs.getString("universityCity"))
                    .universityAddress(rs.getString("universityAddress"))
                    .universityContact(rs.getString("universityContact"))
                    .universityEmail(rs.getString("universityEmail"))
                    .universityZipCode(rs.getString("universityZipCode"))
                    .remark(rs.getString("remark"))
                    .createBy(rs.getTimestamp("createBy") != null ? rs.getTimestamp("createBy").toLocalDateTime() : null)
                    .updateBy(rs.getTimestamp("updateBy") != null ? rs.getTimestamp("updateBy").toLocalDateTime() : null)
                    .build();
        }
    }
    @Override
    public University findByEmail(String universityEmail) {
        try {
            return jdbcTemplate.queryForObject(Constant.GET_UNIVERCITY_BY_UniversityEmail,new Object[]{universityEmail},new UniversityRowMapper());
        }catch (Exception e) {
            throw new GlobleExceptionHandle("University not found with University Email: " + universityEmail, 404);
        }
    }

    public University findByEmailOnly(String universityEmail) {
        return jdbcTemplate.queryForObject(Constant.GET_UNIVERSITY_BY_EMAIL_ONLY,new Object[]{universityEmail},new UniversityRowMapperForEmail()
        );
    }

    private static class UniversityRowMapperForEmail implements RowMapper<University> {
        @Override
        public University mapRow(ResultSet rs, int rowNum) throws SQLException {
            return University.builder()
                    .universityEmail(rs.getString("universityEmail"))
                    .build();
        }
    }

}

