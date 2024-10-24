package CodeJdbcTemplete.service;

import CodeJdbcTemplete.model.Collage;
import CodeJdbcTemplete.repository.CollageRepository;
import org.springframework.stereotype.Service;

@Service
public class CollageService {

    private final CollageRepository collageRepository;

    public CollageService(CollageRepository collageRepository) {
        this.collageRepository = collageRepository;
    }

    public void registerCollage(Collage collage) {
        this.collageRepository.collageRegister(collage);
    }

    public Collage findByCollageId(long collageId) {
       return this.collageRepository.findByCollageId(collageId);
    }


}
