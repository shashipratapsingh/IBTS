package CodeJdbcTemplete.service;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.Collage;
import CodeJdbcTemplete.repository.CollageJPARepository;
import CodeJdbcTemplete.repository.CollageRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CollageService {

    private final CollageRepository collageRepository;
    private final CollageJPARepository collageJPARepository;

    public CollageService(CollageRepository collageRepository, CollageJPARepository collageJPARepository) {
        this.collageRepository = collageRepository;
        this.collageJPARepository = collageJPARepository;
    }
    public void registerCollage(Collage collage) {
        this.collageRepository.collageRegister(collage);
    }
    public Optional<Collage> findByCollageId(long collageId) {
        return Optional.ofNullable(this.collageRepository.findByCollageId(collageId));
    }

    public List<Collage> findAll()  {
        List<Collage> collages =this.collageJPARepository.findAll();
        System.out.println("collage details"+collages);
        try {
            if (!collages.isEmpty()) {
                return this.collageJPARepository.findAll();
            }
        }catch (Exception e) {
            throw new GlobleExceptionHandle("Data not found");
        }
        throw new GlobleExceptionHandle("Data not found");
    }
}
