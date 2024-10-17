package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.University;

public interface UniversityRepository {
    int save(University university);

    public University findById(int id);
    public University findByEmail(String universityEmail);
    public University findByEmailOnly(String universityEmail);
}
