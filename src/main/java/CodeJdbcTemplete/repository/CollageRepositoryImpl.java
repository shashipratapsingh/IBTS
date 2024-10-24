package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.Collage;
import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CollageRepositoryImpl implements CollageRepository {
    private final JdbcTemplate jdbcTemplate;
    public CollageRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void collageRegister(Collage collage) {
        String sql = Constant.REGISTER_COLLAGE;
         this.jdbcTemplate.update(sql,
                collage.getCollageId(),
                 collage.getCollageName(),
                 collage.getCollageType(),
                 collage.getCollageDescription(),
                 collage.getCollageStatus(),
                 collage.getCollageCity(),
                 collage.getCollageDate(),
                 collage.getCollageLocation(),
                 collage.getCollageContact(),
                 collage.getCollageContactEmail(),
                 collage.getCreatedBy(),
                 collage.getUpdatedBy()
         );

    }

    @Override
    public Collage findByCollageId(long collageId) {
        try{
            return jdbcTemplate.queryForObject(Constant.GET_COLLAGE_BY_ID,new Object[]{collageId},new CollageRepositoryImpl.CollageRowMapper());
        }catch (Exception e){
            throw new GlobleExceptionHandle("Collage not found with ID: " + collageId, 404);
        }
    }

    private static class CollageRowMapper implements RowMapper<Collage> {
        @Override
        public Collage mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Collage.builder()
                    .id((int) rs.getLong("id"))
                    .collageId(rs.getLong("collageId"))
                    .collageName(rs.getString("collageName"))
                    .collageType(rs.getString("collageType"))
                    .collageDescription(rs.getString("collageDescription"))
                    .collageStatus(rs.getString("collageStatus"))
                    .collageCity(rs.getString("collageCity"))
                    .collageDate(rs.getDate("collageDate"))
                    .collageLocation(rs.getString("collageLocation"))
                    .collageContact(rs.getString("collageContact"))
                    .collageContactEmail(rs.getString("collageContactEmail"))
                    .createdBy(rs.getTimestamp("createdBy") != null ? rs.getTimestamp("createdBy").toLocalDateTime() : null)
                    .updatedBy(rs.getTimestamp("updatedBy") != null ? rs.getTimestamp("updatedBy").toLocalDateTime() : null)
                    .build();
        }
    }
}
