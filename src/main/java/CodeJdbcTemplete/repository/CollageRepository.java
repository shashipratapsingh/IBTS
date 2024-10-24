package CodeJdbcTemplete.repository;

import CodeJdbcTemplete.model.Collage;


public interface CollageRepository {
    void collageRegister(Collage collage);
    Collage findByCollageId(long  collageId);
}
