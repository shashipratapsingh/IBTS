package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyProfile, Integer> {
}
