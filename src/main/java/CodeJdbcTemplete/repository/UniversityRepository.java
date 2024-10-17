package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.University;

public interface UniversityRepository {
    void save(University university);

     University findById(int id);
      University findByEmail(String universityEmail);
      University findByEmailOnly(String universityEmail);
}
