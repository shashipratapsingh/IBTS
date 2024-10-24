package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.Collage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollageJPARepository extends JpaRepository<Collage, Long> {
}
