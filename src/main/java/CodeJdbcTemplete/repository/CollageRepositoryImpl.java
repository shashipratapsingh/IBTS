package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.Collage;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
